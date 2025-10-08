#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

#define MAX 100

// Function to count characters, words, or lines in a file
void countFile(char option, char *filename) {
    FILE *fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Error: Cannot open file %s\n", filename);
        return;
    }

    int ch_count = 0, word_count = 0, line_count = 0;
    char c;
    int inWord = 0;

    while ((c = fgetc(fp)) != EOF) {
        ch_count++;
        if (c == '\n') line_count++;
        if (c == ' ' || c == '\n' || c == '\t')
            inWord = 0;
        else if (!inWord) {
            inWord = 1;
            word_count++;
        }
    }

    fclose(fp);

    switch(option) {
        case 'c': printf("Characters: %d\n", ch_count); break;
        case 'w': printf("Words: %d\n", word_count); break;
        case 'l': printf("Lines: %d\n", line_count); break;
        default: printf("Invalid option. Use c, w, or l.\n");
    }
}

// Function to execute other commands in Windows
void executeCommand(char **tokens) {
    STARTUPINFO si;
    PROCESS_INFORMATION pi;
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

    // Build command line
    char cmdline[MAX * 2] = "";
    for (int i = 0; tokens[i] != NULL; i++) {
        strcat(cmdline, tokens[i]);
        if (tokens[i+1] != NULL)
            strcat(cmdline, " ");
    }

    // Create process
    if (!CreateProcess(NULL, cmdline, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("Command not found or failed to execute.\n");
        return;
    }

    // Wait until child process exits
    WaitForSingleObject(pi.hProcess, INFINITE);

    // Close process and thread handles
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);
}

int main() {
    char input[MAX];

    while (1) {
        printf("myshell$ ");
        fflush(stdout);

        if (fgets(input, MAX, stdin) == NULL) {
            printf("\n");
            break;
        }

        // Remove newline
        input[strcspn(input, "\n")] = 0;

        // Exit command
        if (strcmp(input, "exit") == 0) break;

        // Tokenize input
        char *tokens[MAX];
        int i = 0;
        char *token = strtok(input, " ");
        while(token != NULL) {
            tokens[i++] = token;
            token = strtok(NULL, " ");
        }
        tokens[i] = NULL;

        // Check for custom "count" command
        if (strcmp(tokens[0], "count") == 0) {
            if (i != 3) {
                printf("Usage: count c|w|l filename\n");
                continue;
            }
            char option = tokens[1][0];
            char *filename = tokens[2];
            countFile(option, filename);
        } else {
            // Execute other commands
            executeCommand(tokens);
        }
    }

    return 0;
}
