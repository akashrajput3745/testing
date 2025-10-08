#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

#define MAX 256

// Function to search first occurrence
void searchFirst(char *filename, char *pattern)
{
    FILE *fp = fopen(filename, "r");
    if (!fp)
    {
        printf("Cannot open file %s\n", filename);
        return;
    }

    char line[MAX];
    int line_no = 1;
    int found = 0;

    while (fgets(line, sizeof(line), fp))
    {
        if (strstr(line, pattern))
        {
            printf("Found at line %d: %s", line_no, line);
            found = 1;
            break;
        }
        line_no++;
    }

    if (!found)
        printf("Pattern not found.\n");
    fclose(fp);
}

// Function to search all occurrences
void searchAll(char *filename, char *pattern)
{
    FILE *fp = fopen(filename, "r");
    if (!fp)
    {
        printf("Cannot open file %s\n", filename);
        return;
    }

    char line[MAX];
    int line_no = 1;
    int found = 0;

    while (fgets(line, sizeof(line), fp))
    {
        char *ptr = line;
        while ((ptr = strstr(ptr, pattern)) != NULL)
        {
            printf("Found at line %d, position %ld\n", line_no, ptr - line + 1);
            ptr += strlen(pattern);
            found = 1;
        }
        line_no++;
    }

    if (!found)
        printf("Pattern not found.\n");
    fclose(fp);
}

// Function to count occurrences
void searchCount(char *filename, char *pattern)
{
    FILE *fp = fopen(filename, "r");
    if (!fp)
    {
        printf("Cannot open file %s\n", filename);
        return;
    }

    char line[MAX];
    int count = 0;

    while (fgets(line, sizeof(line), fp))
    {
        char *ptr = line;
        while ((ptr = strstr(ptr, pattern)) != NULL)
        {
            count++;
            ptr += strlen(pattern);
        }
    }

    printf("Total occurrences: %d\n", count);
    fclose(fp);
}

// Execute other commands in Windows
void executeCommand(char **tokens)
{
    STARTUPINFO si;
    PROCESS_INFORMATION pi;
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

    char cmdline[MAX * 2] = "";
    for (int i = 0; tokens[i] != NULL; i++)
    {
        strcat(cmdline, tokens[i]);
        if (tokens[i + 1] != NULL)
            strcat(cmdline, " ");
    }

    if (!CreateProcess(NULL, cmdline, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi))
    {
        printf("Command not found or failed to execute.\n");
        return;
    }

    WaitForSingleObject(pi.hProcess, INFINITE);
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);
}

int main()
{
    char input[MAX];

    while (1)
    {
        printf("myshell$ ");
        fflush(stdout);

        if (fgets(input, sizeof(input), stdin) == NULL)
        {
            printf("\n");
            break;
        }

        input[strcspn(input, "\n")] = 0;

        if (strcmp(input, "exit") == 0)
            break;

        // Tokenize input
        char *tokens[10];
        int i = 0;
        char *token = strtok(input, " ");
        while (token != NULL)
        {
            tokens[i++] = token;
            token = strtok(NULL, " ");
        }
        tokens[i] = NULL;

        // Custom 'search' command
        if (strcmp(tokens[0], "search") == 0)
        {
            if (i != 4)
            {
                printf("Usage: search f|a|c filename pattern\n");
                continue;
            }
            char option = tokens[1][0];
            char *filename = tokens[2];
            char *pattern = tokens[3];

            if (option == 'f')
                searchFirst(filename, pattern);
            else if (option == 'a')
                searchAll(filename, pattern);
            else if (option == 'c')
                searchCount(filename, pattern);
            else
                printf("Invalid option. Use f, a, or c.\n");
        }
        else
        {
            executeCommand(tokens);
        }
    }

    return 0;
}
