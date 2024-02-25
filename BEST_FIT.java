public class BEST_FIT {
    public static void best_fit(int processsize[], int blocksize[], int n, int m) {
        int allocation[] = new int[n];
        for (int i = 0; i < n; i++)
            allocation[i] = -1;

        for (int i = 0; i < n; i++) {
            int bestidx = -1;
            for (int j = 0; j < m; j++) {
                if (blocksize[j] >= processsize[i]) {
                    if (bestidx == -1)
                        bestidx = j;
                    else if (blocksize[j] < blocksize[bestidx]) {
                        bestidx = j;
                    }
                }
            }
            if (bestidx != -1) {
                allocation[i] = bestidx;
                blocksize[bestidx] -= processsize[i];

            }
        }

        System.out.println("Process No.\tProcess Size\tBlock No.");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "\t\t" + processsize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.println(allocation[i] + 1);
            else
                System.out.println("Not Allocated");
        }
    }

    public static void main(String[] args) {
        int blocksize[] = { 100, 500, 200, 300, 600 };
        int processsize[] = { 212, 417, 112, 426 };
        int m = blocksize.length;
        int n = processsize.length;
        best_fit(processsize, blocksize, n, m);
    }
}

// output
// Process No. Process Size Block No.
// 1 212 4
// 2 417 2
// 3 112 3
// 4 426 5
