import java.util.*;

class Bankers {

    static void calculate_need(int max[][], int need[][], int allocated[][], int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                need[i][j] = max[i][j] - allocated[i][j];
        }
    }

    static boolean checkSafeSystem(int max[][], int allocated[][], int available[], int n, int m) {
        int need[][] = new int[n][m];
        calculate_need(max, need, allocated, n, m);

        int work[] = new int[m];
        int safesequence[] = new int[n];
        boolean finish[] = new boolean[n];
        for (int i = 0; i < n; i++)
            finish[i] = false;
        for (int i = 0; i < m; i++)
            work[i] = available[i];

        int count = 0;

        while (count < n) {
            boolean foundSafeSystem = false;
            for (int i = 0; i < n; i++) {
                if (finish[i] == false) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > work[j])
                            break;
                    }

                    if (j == m) {
                        for (int k = 0; k < m; k++)
                            work[k] += allocated[i][k];

                        safesequence[count++] = (i + 1);
                        finish[i] = true;
                        foundSafeSystem = true;
                    }
                }

            }
            if (foundSafeSystem == false) {
                System.out.println("System is not in safe state because lack of resources");
                return false;
            }

        }

        System.out.println("The system is in safe state.");
        System.out.print("The safe sequence is : ");
        for (int i = 0; i < n; i++)
            System.out.print(safesequence[i] + " ");
        System.out.println();
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.println("Enter the no of processes");
        n = sc.nextInt();
        System.out.println("Enter the no of resources");
        m = sc.nextInt();

        int available[] = new int[n];
        int max[][] = new int[n][m], allocated[][] = new int[n][m];

        for (int i = 0; i < m; i++) {
            System.out.println("Enter the no of availabe resources of type " + (i + 1));
            available[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter the maximum no of resources of type " + (j + 1)
                        + " that can be allocated to process " + (i + 1));
                max[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter the instances resources of type " + (j + 1)
                        + " that are allocated to process " + (i + 1));
                allocated[i][j] = sc.nextInt();
            }
        }

        checkSafeSystem(max, allocated, available, n, m);

        sc.close();
    }
}