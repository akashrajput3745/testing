#include <stdio.h>

#define REF_LEN 16

// Reference String
int ref_string[REF_LEN] = {12, 15, 12, 18, 6, 8, 11, 12, 19, 12, 6, 8, 12, 15, 19, 8};

// Function to check if page is in frames
int isPresent(int frames[], int n, int page)
{
    for (int i = 0; i < n; i++)
    {
        if (frames[i] == page)
            return 1;
    }
    return 0;
}

// ---------- OPTIMAL Implementation ----------
void OPT(int n)
{
    int frames[10], page_faults = 0;

    for (int i = 0; i < n; i++)
        frames[i] = -1;

    printf("\n--- OPTIMAL Page Replacement ---\n");

    for (int i = 0; i < REF_LEN; i++)
    {
        int page = ref_string[i];

        if (!isPresent(frames, n, page))
        {
            int replaceIndex = -1;

            // Check if there is an empty frame
            for (int j = 0; j < n; j++)
            {
                if (frames[j] == -1)
                {
                    replaceIndex = j;
                    break;
                }
            }

            // If no empty frame -> find page with farthest future use
            if (replaceIndex == -1)
            {
                int farthest = -1;
                for (int j = 0; j < n; j++)
                {
                    int k;
                    for (k = i + 1; k < REF_LEN; k++)
                    {
                        if (frames[j] == ref_string[k])
                            break;
                    }
                    if (k == REF_LEN)
                    { // never used again
                        replaceIndex = j;
                        break;
                    }
                    if (k > farthest)
                    {
                        farthest = k;
                        replaceIndex = j;
                    }
                }
            }

            frames[replaceIndex] = page;
            page_faults++;
        }

        // Print frames
        printf("Step %2d (Page %2d): ", i + 1, page);
        for (int j = 0; j < n; j++)
        {
            if (frames[j] == -1)
                printf(" - ");
            else
                printf("%2d ", frames[j]);
        }
        if (!isPresent(frames, n, page))
            printf(" <-- Page Fault");
        printf("\n");
    }

    printf("Total Page Faults (OPT): %d\n", page_faults);
}

// ---------- MFU Implementation ----------
void MFU(int n)
{
    int frames[10], freq[50] = {0}; // frequency count
    int page_faults = 0;

    for (int i = 0; i < n; i++)
        frames[i] = -1;

    printf("\n--- MFU Page Replacement ---\n");

    for (int i = 0; i < REF_LEN; i++)
    {
        int page = ref_string[i];

        if (isPresent(frames, n, page))
        {
            freq[page]++; // increase frequency if page already exists
        }
        else
        {
            int replaceIndex = -1;

            // Check for empty frame
            for (int j = 0; j < n; j++)
            {
                if (frames[j] == -1)
                {
                    replaceIndex = j;
                    break;
                }
            }

            // If no empty frame -> replace Most Frequently Used page
            if (replaceIndex == -1)
            {
                int maxFreq = -1;
                for (int j = 0; j < n; j++)
                {
                    if (freq[frames[j]] > maxFreq)
                    {
                        maxFreq = freq[frames[j]];
                        replaceIndex = j;
                    }
                }
            }

            frames[replaceIndex] = page;
            freq[page]++; // increase frequency of new page
            page_faults++;
        }

        // Print frames
        printf("Step %2d (Page %2d): ", i + 1, page);
        for (int j = 0; j < n; j++)
        {
            if (frames[j] == -1)
                printf(" - ");
            else
                printf("%2d ", frames[j]);
        }
        if (!isPresent(frames, n, page))
            printf(" <-- Page Fault");
        printf("\n");
    }

    printf("Total Page Faults (MFU): %d\n", page_faults);
}

// ---------- Main Function ----------
int main()
{
    int n;
    printf("Enter number of frames: ");
    scanf("%d", &n);

    OPT(n);
    MFU(n);

    return 0;
}
