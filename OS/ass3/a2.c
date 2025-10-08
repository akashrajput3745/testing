#include <stdio.h>
#include <stdlib.h>

struct Process
{
    int id;
    int at;  // Arrival Time
    int bt;  // Burst Time
    int ct;  // Completion Time
    int tat; // Turnaround Time
    int wt;  // Waiting Time
};

int main()
{
    int n, i, j, time = 0, completed = 0;
    float avgWT = 0, avgTAT = 0;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n];
    int visited[n];

    for (i = 0; i < n; i++)
    {
        printf("Enter Arrival Time and Burst Time for P%d: ", i + 1);
        p[i].id = i + 1;
        scanf("%d %d", &p[i].at, &p[i].bt);
        visited[i] = 0;
    }

    printf("\nGantt Chart:\n");

    while (completed < n)
    {
        int idx = -1;
        int minBT = 9999;

        // Find process with shortest burst time that has arrived
        for (i = 0; i < n; i++)
        {
            if (p[i].at <= time && visited[i] == 0)
            {
                if (p[i].bt < minBT)
                {
                    minBT = p[i].bt;
                    idx = i;
                }
            }
        }

        if (idx != -1)
        {
            printf("| P%d (%d-%d) ", p[idx].id, time, time + p[idx].bt);
            time += p[idx].bt;
            time += 2; // fixed IO wait
            p[idx].ct = time;
            p[idx].tat = p[idx].ct - p[idx].at;
            p[idx].wt = p[idx].tat - p[idx].bt;
            avgWT += p[idx].wt;
            avgTAT += p[idx].tat;
            visited[idx] = 1;
            completed++;
        }
        else
        {
            time++; // If no process has arrived yet
        }
    }
    printf("|\n");

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
