#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct Process
{
    int id;
    int at;  // Arrival Time
    int bt;  // Burst Time
    int rt;  // Remaining Time
    int ct;  // Completion Time
    int tat; // Turnaround Time
    int wt;  // Waiting Time
};

int main()
{
    int n, i, time = 0, completed = 0;
    float avgWT = 0, avgTAT = 0;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n];

    for (i = 0; i < n; i++)
    {
        printf("Enter Arrival Time and Burst Time for P%d: ", i + 1);
        p[i].id = i + 1;
        scanf("%d %d", &p[i].at, &p[i].bt);
        p[i].rt = p[i].bt;
    }

    printf("\nGantt Chart:\n");

    int prev = -1;
    while (completed < n)
    {
        int idx = -1;
        int minRT = INT_MAX;

        // Select process with shortest remaining time
        for (i = 0; i < n; i++)
        {
            if (p[i].at <= time && p[i].rt > 0)
            {
                if (p[i].rt < minRT)
                {
                    minRT = p[i].rt;
                    idx = i;
                }
            }
        }

        if (idx != -1)
        {
            // Print only when process changes (for Gantt chart clarity)
            if (prev != idx)
            {
                printf(" | %d: P%d ", time, p[idx].id);
                prev = idx;
            }

            // Execute process for 1 unit
            p[idx].rt--;
            time++;

            // If process finishes
            if (p[idx].rt == 0)
            {
                time += 2; // fixed IO wait
                p[idx].ct = time;
                p[idx].tat = p[idx].ct - p[idx].at;
                p[idx].wt = p[idx].tat - p[idx].bt;
                avgWT += p[idx].wt;
                avgTAT += p[idx].tat;
                completed++;
            }
        }
        else
        {
            time++; // No process has arrived yet
        }
    }
    printf(" | %d\n", time);

    printf("\nProcess\tAT\tBT\tCT\tTAT\tWT\n");
    for (i = 0; i < n; i++)
    {
        printf("P%d\t%d\t%d\t%d\t%d\t%d\n", p[i].id, p[i].at, p[i].bt,
               p[i].ct, p[i].tat, p[i].wt);
    }

    printf("\nAverage Turnaround Time = %.2f", avgTAT / n);
    printf("\nAverage Waiting Time = %.2f\n", avgWT / n);

    return 0;
}
