#include <stdio.h>
#include <stdlib.h>

struct Process {
    int id;
    int at;   // Arrival Time
    int bt;   // Burst Time
    int rt;   // Remaining Time
    int ct;   // Completion Time
    int tat;  // Turnaround Time
    int wt;   // Waiting Time
};

int main() {
    int n, tq, i;
    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n];

    for(i = 0; i < n; i++) {
        p[i].id = i+1;
        printf("Enter Arrival Time and Burst Time for P%d: ", i+1);
        scanf("%d %d", &p[i].at, &p[i].bt);
        p[i].rt = p[i].bt;
    }

    printf("Enter Time Quantum: ");
    scanf("%d", &tq);

    int time = 0, completed = 0;
    float avgWT = 0, avgTAT = 0;

    int readyQ[100], front = 0, rear = 0; // queue
    int visited[n];
    for(i = 0; i < n; i++) visited[i] = 0;

    printf("\nGantt Chart:\n");

    // start by pushing the first arrived process
    while(completed < n) {
        // Add new arrivals to queue
        for(i = 0; i < n; i++) {
            if(p[i].at <= time && visited[i] == 0) {
                readyQ[rear++] = i;
                visited[i] = 1;
            }
        }

        if(front < rear) { // if queue not empty
            int idx = readyQ[front++];
            if(p[idx].rt > tq) {
                printf("| %d: P%d ", time, p[idx].id);
                p[idx].rt -= tq;
                time += tq;

                // new arrivals during this quantum
                for(i = 0; i < n; i++) {
                    if(p[i].at <= time && visited[i] == 0) {
                        readyQ[rear++] = i;
                        visited[i] = 1;
                    }
                }

                readyQ[rear++] = idx; // put back into queue
            } else {
                printf("| %d: P%d ", time, p[idx].id);
                time += p[idx].rt;
                p[idx].rt = 0;
                time += 2; // fixed IO wait
                p[idx].ct = time;
                p[idx].tat = p[idx].ct - p[idx].at;
                p[idx].wt = p[idx].tat - p[idx].bt;

                avgWT += p[idx].wt;
                avgTAT += p[idx].tat;
                completed++;
            }
        } else {
            time++; // idle
        }
    }
    printf("| %d\n", time);

    printf("\nProcess\tAT\tBT\tCT\tTAT\tWT\n");
    for(i = 0; i < n; i++) {
        printf("P%d\t%d\t%d\t%d\t%d\t%d\n",
               p[i].id, p[i].at, p[i].bt,
               p[i].ct, p[i].tat, p[i].wt);
    }

    printf("\nAverage Turnaround Time = %.2f", avgTAT/n);
    printf("\nAverage Waiting Time = %.2f\n", avgWT/n);

    return 0;
}
