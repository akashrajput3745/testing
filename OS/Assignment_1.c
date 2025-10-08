// Set A
// (1)
#include <stdio.h>
#include <unistd.h>
int main() {
    pid_t pid = fork();

    if (pid == 0) {
        // Child process
        printf("I am Child Process\n");
    } else if (pid > 0) {
        // Parent process
        printf("I am Parent Process\n");
    } else {
        printf("Fork failed\n");
    }
    return 0;
}

// (2)
// #include <stdio.h>
// #include <sys/types.h>
// #include <unistd.h>
// #include <sys/resource.h>
// #include <stdlib.h>
// int main() {
//     pid_t pid;
//     int prio;
//     pid = fork();
//     if (pid == 0) {
//         printf("I am child process, id=%d\n", getpid());
//         prio = nice(-7);
//         printf("Priority :%d, id=%d\n", prio, getpid());
//     } else if (pid > 0) {
//         printf("I am parent process, id=%d\n", getpid());
//         nice(1); 
//         prio = nice(15); 
//         printf("Priority :%d, id=%d\n", prio, getpid());
//     } else {
//         perror("fork failed");
//         exit(1);
//     }
//     return 0;
// }
// Set B
// (1)
// #include<stdio.h>
// #include<sys/types.h>
// #include<unistd.h>
// #include<stdlib.h>
// void bubblesort(int arr[], int n) {
//     int i, j, temp;
//     for(i = 0; i < n; i++) {
//         for(j = 0; j < n - 1; j++) {
//             if(arr[j] > arr[j + 1]) {
//                 temp = arr[j];
//                 arr[j] = arr[j + 1];
//                 arr[j + 1] = temp;
//             }
//         }
//     }
// }
// void insertionsort(int arr[], int n) {
//     int i, j, temp;
//     for(i = 1; i < n; i++) {
//         temp = arr[i];
//         j = i - 1;
//         while(j >= 0 && temp <= arr[j]) {
//             arr[j + 1] = arr[j];
//             j = j - 1;
//         }
//         arr[j + 1] = temp;
//     }
// }
// int main() {
//     int arr[30], n, i;
//     printf("\nEnter the number of values in array: ");
//     scanf("%d", &n);
//     printf("\nEnter the array elements: ");
//     for(i = 0; i < n; i++)
//         scanf("%d", &arr[i]);
//     int pid = fork();
//     if(pid == 0) {
//         sleep(10); 
//         printf("\nChild process\n");
//         printf("Child process id = %d\n", getpid());
//         insertionsort(arr, n);
//         printf("\nElements Sorted Using insertion sort:\n");
//         for(i = 0; i < n; i++)
//             printf("%d, ", arr[i]);
//         printf("\nParent process id = %d\n", getppid());
//     } else {
//         printf("\nParent process\n");
//         printf("Parent process id = %d\n", getpid());
//         bubblesort(arr, n);
//         printf("Elements Sorted Using bubble sort:\n");
//         for(i = 0; i < n; i++)
//             printf("%d, ", arr[i]);
//         printf("\n\n");
//         wait(NULL);
//     }
//     return 0;
// }

// (2)
// #include <stdio.h>
// #include <unistd.h>
// #include <sys/types.h>
// #include <stdlib.h>
// int main() {
//     pid_t pid = fork();
//     if (pid < 0) {
//         fprintf(stderr, "Fork failed\n");
//         exit(1);
//     } else if (pid == 0) {
//         printf("Child: PID=%d, Parent PID=%d\n", getpid(), getppid());
//         sleep(5);
//         printf("Child after parent termination: PID=%d, Parent PID=%d\n", getpid(), getppid());
//     } else {
//         printf("Parent: PID=%d, Child PID=%d\n", getpid(), pid);
//         exit(0);
//     }
//     return 0;
// }
// Set C
// (1)
// #include <stdio.h>
// #include <unistd.h>
// #include <sys/wait.h>
// int binarySearch(int arr[], int l, int r, int x) {
//     while (l <= r) {
//         int m = l + (r - l) / 2;
//         if (arr[m] == x) return m;
//         if (arr[m] < x) l = m + 1;
//         else r = m - 1;
//     }
//     return -1;
// }
// int main() {
//     int n, arr[20], x, i;
//     printf("Enter size of array: ");
//     scanf("%d", &n);
//     printf("Enter sorted array elements:\n");
//     for (i = 0; i < n; i++) scanf("%d", &arr[i]);
//     pid_t pid = fork();
//     if (pid == 0) {
//         printf("Enter value to search: ");
//         scanf("%d", &x);
//         int res = binarySearch(arr, 0, n-1, x);
//         if (res == -1)
//             printf("Element not found.\n");
//         else
//             printf("Element found at index %d.\n", res);
//     } else if (pid > 0) {
//         wait(NULL);
//         printf("Parent process ended.\n");
//     } else {
//         printf("Fork failed\n");
//     }
//     return 0;
// }

