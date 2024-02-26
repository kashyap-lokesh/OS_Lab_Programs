public class FCFS_disk_scheduling {

    static void fcfs(int arr[], int n, int head) {
        int distance, curtrack, seek_count = 0;
        for (int i = 0; i < n; i++) {
            curtrack = arr[i];
            distance = Math.abs(head - curtrack);
            seek_count += distance;
            head = curtrack;
        }
        System.out.println("Total no of seek operations is : " + seek_count);
        System.out.print("Seek Sequence is : ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60,
                92, 11, 41, 114 };
        int head = 50;
        int n = arr.length;
        fcfs(arr, n, head);

    }
}
