#include <stdio.h>

#define REF_LEN 16

// Reference String
int ref_string[REF_LEN] = {12,15,12,18,6,8,11,12,19,12,6,8,12,15,19,8};

// Function to check if page is present in frames
int isPresent(int frames[], int n, int page) {
    for (int i = 0; i < n; i++) {
        if (frames[i] == page)
            return 1;
    }
    return 0;
}

// ---------- FIFO Implementation ----------
void FIFO(int n) {
    int frames[10], index = 0, page_faults = 0;

    for (int i = 0; i < n; i++) frames[i] = -1;

    printf("\n--- FIFO Page Replacement ---\n");
    for (int i = 0; i < REF_LEN; i++) {
        if (!isPresent(frames, n, ref_string[i])) {
            frames[index] = ref_string[i];
            index = (index + 1) % n; // circular replacement
            page_faults++;
        }

        // Print frame status
        printf("Step %2d (Page %2d): ", i + 1, ref_string[i]);
        for (int j = 0; j < n; j++) {
            if (frames[j] == -1) printf(" - ");
            else printf("%2d ", frames[j]);
        }
        if (!isPresent(frames, n, ref_string[i])) printf(" <-- Page Fault");
        printf("\n");
    }
    printf("Total Page Faults (FIFO): %d\n", page_faults);
}

// ---------- LRU Implementation ----------
void LRU(int n) {
    int frames[10], last_used[10], time = 0, page_faults = 0;

    for (int i = 0; i < n; i++) {
        frames[i] = -1;
        last_used[i] = 0;
    }

    printf("\n--- LRU Page Replacement ---\n");
    for (int i = 0; i < REF_LEN; i++) {
        int page = ref_string[i];
        time++;
        int found = -1;

        // Check if page is already in frames
        for (int j = 0; j < n; j++) {
            if (frames[j] == page) {
                found = j;
                break;
            }
        }

        if (found != -1) {
            last_used[found] = time; // update usage time
        } else {
            // Find empty slot
            int replaceIndex = -1;
            for (int j = 0; j < n; j++) {
                if (frames[j] == -1) {
                    replaceIndex = j;
                    break;
                }
            }

            // If no empty slot, find least recently used
            if (replaceIndex == -1) {
                int minTime = last_used[0];
                replaceIndex = 0;
                for (int j = 1; j < n; j++) {
                    if (last_used[j] < minTime) {
                        minTime = last_used[j];
                        replaceIndex = j;
                    }
                }
            }

            frames[replaceIndex] = page;
            last_used[replaceIndex] = time;
            page_faults++;
        }

        // Print frame status
        printf("Step %2d (Page %2d): ", i + 1, page);
        for (int j = 0; j < n; j++) {
            if (frames[j] == -1) printf(" - ");
            else printf("%2d ", frames[j]);
        }
        if (found == -1) printf(" <-- Page Fault");
        printf("\n");
    }
    printf("Total Page Faults (LRU): %d\n", page_faults);
}

// ---------- Main Function ----------
int main() {
    int n;
    printf("Enter number of frames: ");
    scanf("%d", &n);

    FIFO(n);
    LRU(n);

    return 0;
}
