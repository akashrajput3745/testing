#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

#define MAX 100

// Function to handle 'list' command
void listDir(char option, char *dirname)
{
    WIN32_FIND_DATA findFileData;
    HANDLE hFind;
    char searchPath[MAX];

    // Append \* to path to search all files
    snprintf(searchPath, MAX, "%s\\*", dirname);

    hFind = FindFirstFile(searchPath, &findFileData);
    if (hFind == INVALID_HANDLE_VALUE)
    {
        printf("Unable to open directory: %s\n", dirname);
        return;
    }

    int count = 0;
    do
    {
        if (strcmp(findFileData.cFileName, ".") == 0 || strcmp(findFileData.cFileName, "..") == 0)
            continue;

        if (option == 'f')
        {
            printf("%s\n", findFileData.cFileName);
        }
        else if (option == 'i')
        {
            // Windows does not have inode; we can print FileIndex
            printf("%s\t FileIndex: %llu\n", findFileData.cFileName,
                   (((unsigned long long)findFileData.nFileIndexHigh) << 32) + findFileData.nFileIndexLow);
        }
        count++;
    } while (FindNextFile(hFind, &findFileData) != 0);

    if (option == 'n')
    {
        printf("Total entries: %d\n", count);
    }

    FindClose(hFind);
}

// Function to execute other commands in Windows
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

        if (strcmp(tokens[0], "list") == 0)
        {
            if (i != 3)
            {
                printf("Usage: list f|n|i dirname\n");
                continue;
            }
            char option = tokens[1][0];
            char *dirname = tokens[2];
            listDir(option, dirname);
        }
        else
        {
            executeCommand(tokens);
        }
    }

    return 0;
}
