#include <stdio.h>

int main()
{
    int n, sb[20], s[20], m[20], b[20][20], i, j, x;

    printf("Enter the no. of files\n");
    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        printf("Enter the starting block and the size of file %d : ", (i + 1));
        scanf("%d %d", &sb[i], &s[i]);
        printf("Enter the number of blocks occupied by process %d : ", i + 1);
        scanf("%d", &m[i]);

        printf("Enter the blocks occupied by the process %d : ", i + 1);
        for (j = 0; j < m[i]; j++)
            scanf("%d", &b[i][j]);
    }

    printf("File\tIndex\tLength\n");
    for (i = 0; i < n; i++)
    {
        printf("%d\t%d%\t%d\n", (i + 1), sb[i], m[i]);
    }

    printf("Enter the file number\n");
    scanf("%d", &x);
    printf("File name is %d\n", x);
    printf("File Index is %d\n", sb[x - 1]);
    printf("Blocks occupied are : ");
    for (i = 0; i < m[x - 1]; i++)
        printf("%d ", b[x - 1][i]);
    printf("\n");

    return 0;
}

/* OUTPUT
Enter the no. of files
2
Enter the starting block and the size of file 1 : 2 5
Enter the number of blocks occupied by process 1 : 10
Enter the blocks occupied by the process 1 : 3 2 5 4 6 7 2 6 4 7
Enter the starting block and the size of file 2 : 3 4
Enter the number of blocks occupied by process 2 : 5
Enter the blocks occupied by the process 2 : 2 3 4 5 6
File    Index   Length
1       2       10
2       3       5
Enter the file number
1
File name is 1
File Index is 2
Blocks occupied are : 3 2 5 4 6 7 2 6 4 7
*/