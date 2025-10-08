#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define IO_WAIT 2

typedef struct
{
    int pid;
    int arrival_time;
    int first_cpu_burst;
    int next_cpu_burst;
    int start_time_first;
    int finish_time_first;
    int start_time_next;
    int finish_time_next;
    int turnaround_time;
    int waiting_time;
} Process;

int main()
{
    int n, i;
    srand(time(NULL));

    printf("Enter number of processes: ");
    scanf("%d", &n);

    Process p[n];

    // Input arrival time and first CPU burst
    for (i = 0; i < n; i++)
    {
        p[i].pid = i + 1;
        printf("Process %d - Enter arrival time: ", p[i].pid);
        scanf("%d", &p[i].arrival_time);
        printf("Process %d - Enter first CPU burst time: ", p[i].pid);
        scanf("%d", &p[i].first_cpu_burst);
        p[i].next_cpu_burst = rand() % 10 + 1; // Random next CPU burst [1-10]
    }

    // Sort processes by arrival time (simple bubble sort for clarity)
    for (i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (p[j].arrival_time > p[j + 1].arrival_time)
            {
                Process temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }

    int current_time = 0;
    // FCFS scheduling simulation
    for (i = 0; i < n; i++)
    {
        if (current_time < p[i].arrival_time)
            current_time = p[i].arrival_time;

        // First CPU burst
        p[i].start_time_first = current_time;
        current_time += p[i].first_cpu_burst;
        p[i].finish_time_first = current_time;

        // IO wait
        current_time += IO_WAIT;

        // Next CPU burst
        p[i].start_time_next = current_time;
        current_time += p[i].next_cpu_burst;
        p[i].finish_time_next = current_time;

        // Calculate turnaround = finish of second CPU burst - arrival
        p[i].turnaround_time = p[i].finish_time_next - p[i].arrival_time;

        // Waiting time = turnaround - (CPU bursts)
        p[i].waiting_time = p[i].turnaround_time - (p[i].first_cpu_burst + p[i].next_cpu_burst);
    }

    printf("Gantt Chart:");
    for (i = 0; i < n; i++) {
        if (i == 0)
            printf("| ");
        if (p[i].start_time_first > (i == 0 ? 0 : p[i - 1].finish_time_next))
            printf("IDLE (%d-%d) | ", (i == 0 ? 0 : p[i - 1].finish_time_next), p[i].start_time_first);

        printf("P%d_CPU1 (%d-%d) | IO (%d-%d) | P%d_CPU2 (%d-%d) | ",
               p[i].pid, p[i].start_time_first, p[i].finish_time_first,
               p[i].finish_time_first, p[i].start_time_next,
               p[i].pid, p[i].start_time_next, p[i].finish_time_next);
    }
    printf("Process ID  Arrival  CPU1 Burst  CPU2 Burst  Waiting Time  Turnaround Time");
    int total_wt = 0, total_tat = 0;
    for (i = 0; i < n; i++) {
        printf("P%-10d %-8d %-11d %-11d %-13d %-15d",p[i]    .pid,p[i].arrival_time,p[i].first_cpu_burst, p[i].next_cpu_burst,p[i].waiting_time, p[i].turnaround_time);
        total_wt += p[i].waiting_time;
        total_tat += p[i].turnaround_time;
    }

    printf("Average Waiting Time: %.2f", (float)total_wt / n);    printf("Average Turnaround Time: %.2f", (float)total_tat / n);

    return 0;
}