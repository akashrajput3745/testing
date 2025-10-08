#include <stdio.h>

#define REF_LEN 16

// Reference String
int ref_string[REF_LEN] = {2, 5, 2, 8, 5, 4, 1, 2, 3, 2, 6, 1, 2, 5, 9, 8};

// Function to check if page is in frames
int isPresent(int frames[], int n, int page)
{
    for (int i = 0; i < n; i++)
        if (frames[i] == page)
            return 1;
    return 0;
}

// ---------- MRU (Most Recently Used) ----------
void MRU(int n)
{
    int frames[10], last_used[10] = {0}, time = 0, page_faults = 0;
    for (int i = 0; i < n; i++)
        frames[i] = -1;

    printf("\n--- MRU Page Replacement ---\n");

    for (int i = 0; i < REF_LEN; i++)
    {
        time++;
        int page = ref_string[i];
        int found = -1;

        for (int j = 0; j < n; j++)
            if (frames[j] == page)
                found = j;

        if (found != -1)
        {
            last_used[found] = time; // update last used
        }
        else
        {
            int replaceIndex = -1;

            // Empty frame?
            for (int j = 0; j < n; j++)
            {
                if (frames[j] == -1)
                {
                    replaceIndex = j;
                    break;
                }
            }

            // If no empty frame -> replace Most Recently Used
            if (replaceIndex == -1)
            {
                int maxTime = last_used[0];
                replaceIndex = 0;
                for (int j = 1; j < n; j++)
                {
                    if (last_used[j] > maxTime)
                    {
                        maxTime = last_used[j];
                        replaceIndex = j;
                    }
                }
            }

            frames[replaceIndex] = page;
            last_used[replaceIndex] = time;
            page_faults++;
        }

        // Print frames
        printf("Step %2d (Page %2d): ", i + 1, page);
        for (int j = 0; j < n; j++)
            if (frames[j] == -1)
                printf(" - ");
            else
                printf("%2d ", frames[j]);
        if (found == -1)
            printf(" <-- Page Fault");
        printf("\n");
    }
    printf("Total Page Faults (MRU): %d\n", page_faults);
}

// ---------- Second Chance (Clock) ----------
void SecondChance(int n)
{
    int frames[10], ref_bit[10] = {0}, pointer = 0, page_faults = 0;
    for (int i = 0; i < n; i++)
        frames[i] = -1;

    printf("\n--- Second Chance Page Replacement ---\n");

    for (int i = 0; i < REF_LEN; i++)
    {
        int page = ref_string[i];
        int found = -1;

        for (int j = 0; j < n; j++)
            if (frames[j] == page)
            {
                found = j;
                break;
            }

        if (found != -1)
        {
            ref_bit[found] = 1; // give second chance
        }
        else
        {
            while (1)
            {
                if (ref_bit[pointer] == 0)
                {
                    frames[pointer] = page;
                    ref_bit[pointer] = 1;
                    pointer = (pointer + 1) % n;
                    break;
                }
                else
                {
                    ref_bit[pointer] = 0;
                    pointer = (pointer + 1) % n;
                }
            }
            page_faults++;
        }

        // Print frames
        printf("Step %2d (Page %2d): ", i + 1, page);
        for (int j = 0; j < n; j++)
            if (frames[j] == -1)
                printf(" - ");
            else
                printf("%2d ", frames[j]);
        if (found == -1)
            printf(" <-- Page Fault");
        printf("\n");
    }
    printf("Total Page Faults (Second Chance): %d\n", page_faults);
}

// ---------- LFU (Least Frequently Used) ----------
void LFU(int n)
{
    int frames[10], freq[50] = {0}, page_faults = 0;
    for (int i = 0; i < n; i++)
        frames[i] = -1;

    printf("\n--- LFU Page Replacement ---\n");

    for (int i = 0; i < REF_LEN; i++)
    {
        int page = ref_string[i];
        int found = -1;

        for (int j = 0; j < n; j++)
            if (frames[j] == page)
            {
                found = j;
                break;
            }

        if (found != -1)
        {
            freq[page]++;
        }
        else
        {
            int replaceIndex = -1;

            // empty frame
            for (int j = 0; j < n; j++)
                if (frames[j] == -1)
                {
                    replaceIndex = j;
                    break;
                }

            // no empty frame -> replace least frequently used
            if (replaceIndex == -1)
            {
                int minFreq = freq[frames[0]];
                replaceIndex = 0;
                for (int j = 1; j < n; j++)
                {
                    if (freq[frames[j]] < minFreq)
                    {
                        minFreq = freq[frames[j]];
                        replaceIndex = j;
                    }
                }
            }

            frames[replaceIndex] = page;
            freq[page]++;
            page_faults++;
        }

        // Print frames
        printf("Step %2d (Page %2d): ", i + 1, page);
        for (int j = 0; j < n; j++)
            if (frames[j] == -1)
                printf(" - ");
            else
                printf("%2d ", frames[j]);
        if (found == -1)
            printf(" <-- Page Fault");
        printf("\n");
    }
    printf("Total Page Faults (LFU): %d\n", page_faults);
}

// ---------- Main Function ----------
int main()
{
    int n;
    printf("Enter number of frames: ");
    scanf("%d", &n);

    MRU(n);
    SecondChance(n);
    LFU(n);

    return 0;
}
