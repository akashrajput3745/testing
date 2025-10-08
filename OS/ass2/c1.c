#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>

#define MAX 256

// Function to display first n lines
void displayFirstNLines(char *filename, int n) {
    FILE *fp = fopen(filename, "r");
    if (!fp) {
        printf("Cannot open file %s\n", filename);
        return;
    }
    char line[MAX];
    int count = 0;
    while (fgets(line, sizeof(line), fp) && count < n) {
        printf("%s", line);
        count++;
    }
    fclose(fp);
}

// Function to display last n lines
void displayLastNLines(char *filename, int n) {
    FILE *fp = fopen(filename, "r");
    if (!fp) {
        printf("Cannot open file %s\n", filename);
        return;
    }

    int total = 0;
    char line[MAX];
    while (fgets(line, sizeof(line), fp)) total++;
    rewind(fp);

    int start = total - n;
    if (start < 0) start = 0;
    int count = 0;
    while (fgets(line, sizeof(line), fp)) {
        if (count >= start) printf("%s", line);
        count++;
    }
    fclose(fp);
}

// Function to display all lines
void displayAllLines(char *filename) {
    FILE *fp = fopen(filename, "r");
    if (!fp) {
        printf("Cannot open file %s\n", filename);
        return;
    }
    char line[MAX];
    while (fgets(line, sizeof(line), fp)) {
        printf("%s", line);
    }
    fclose(fp);
}

// Execute other commands in Windows
void executeCommand(char **tokens) {
    STARTUPINFO si;
    PROCESS_INFORMATION pi;
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

    char cmdline[MAX * 2] = "";
    for (int i = 0; tokens[i] != NULL; i++) {
        strcat(cmdline, tokens[i]);
        if (tokens[i+1] != NULL)
            strcat(cmdline, " ");
    }

    if (!CreateProcess(NULL, cmdline, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("Command not found or failed to execute.\n");
        return;
    }

    WaitForSingleObject(pi.hProcess, INFINITE);
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);
}

int main() {
    char input[MAX];

    while (1) {
        printf("myshell$ ");
        fflush(stdout);

        if (fgets(input, sizeof(input), stdin) == NULL) {
            printf("\n");
            break;
        }

        input[strcspn(input, "\n")] = 0;

        if (strcmp(input, "exit") == 0) break;

        // Tokenize input
        char *tokens[10];
        int i = 0;
        char *token = strtok(input, " ");
        while (token != NULL) {
            tokens[i++] = token;
            token = strtok(NULL, " ");
        }
        tokens[i] = NULL;

        // Custom 'typeline' command
        if (strcmp(tokens[0], "typeline") == 0) {
            if (i != 3) {
                printf("Usage: typeline n|-n|a filename\n");
                continue;
            }
            char *option = tokens[1];
            char *filename = tokens[2];

            if (strcmp(option, "a") == 0) {
                displayAllLines(filename);
            } else if (option[0] == '-') {
                int n = atoi(option + 1);
                displayLastNLines(filename, n);
            } else {
                int n = atoi(option);
                displayFirstNLines(filename, n);
            }
        } else {
            executeCommand(tokens);
        }
    }

    return 0;
}
