import java.util.*;

class prg1_SJF {

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of processes");
        n = sc.nextInt();

        int arr[] = new int[n], bt[] = new int[n], tat[] = new int[n], wt[] = new int[n], start[] = new int[n],
                finish[] = new int[n], pn[] = new int[n];

        int totwt = 0, tottat = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name , arrival time and the burst time of the process " + (i + 1));
            pn[i] = sc.nextInt();
            arr[i] = sc.nextInt();
            bt[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                if (bt[j] < bt[i]) {
                    swap(bt, i, j);
                    swap(arr, i, j);
                    swap(pn, i, j);
                }
            }
        }

        start[0] = arr[0];
        wt[0] = 0;
        finish[0] = start[0] + bt[0];
        tat[0] = finish[0] - arr[0];

        for (int i = 1; i < n; i++) {
            start[i] = finish[i - 1];
            finish[i] = start[i] + bt[i];
            tat[i] = finish[i] - arr[i];
            wt[i] = tat[i] - bt[i];
        }

        System.out.println("Pname\tArrival\tBurst\tStart\tWaiting\tFinish\tTurnAround");
        for (int i = 0; i < n; i++) {
            System.out
                    .println(pn[i] + "\t" + arr[i] + "\t" + bt[i] + "\t" + start[i] + "\t" + wt[i] + "\t" + finish[i]
                            + "\t" + tat[i]);

            totwt += wt[i];
            tottat += tat[i];
        }
        System.out.println("Average waiting time is : " + (double) (totwt) / n);
        System.out.println("Average turnaround time is : " + (double) (tottat) / n);
        sc.close();
    }
}
