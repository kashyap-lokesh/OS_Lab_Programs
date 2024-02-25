#include <stdio.h>

struct file
{
    char fname[20];
    int start, size, blocks[20];
} f[10];

int main()
{
    int n, i, j;
    printf("Enter the number of processes\n");
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        printf("Enter the name of the process %d : ", (i + 1));
        scanf("%s", &f[i].fname);
        printf("Enter the starting block of process %d : ", (i + 1));
        scanf("%d", &f[i].start);
        printf("Enter the no of blocks of process %d : ", (i + 1));
        scanf("%d", &f[i].size);

        printf("Enter the block no of process %d : ", (i + 1));
        for (j = 1; j <= f[i].size; j++)
            scanf("%d", &f[i].blocks[j]);
    }

    printf("File\tStart\tSize\tBlocks\n");
    for (i = 0; i < n; i++)
    {
        printf("%s\t%d\t%d\t", f[i].fname, f[i].start, f[i].size);
        for (j = 1; j <= f[i].size - 1; j++)
            printf("%d-->", f[i].blocks[j]);
        printf("%d\n", f[i].blocks[j]);
    }
    return 0;
}