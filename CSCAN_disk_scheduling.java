import java.util.Vector;

public class CSCAN_disk_scheduling {
    static int disksize = 200;

    static void cscan(int arr[], int n, int head) {
        int distance, curtrack, seek_count = 0;
        Vector<Integer> left = new Vector<>(), right = new Vector<>(),
                seekSequence = new Vector<>();

        left.add(0);
        right.add(disksize - 1);

        for (int i = 0; i < n; i++) {
            if (arr[i] < head)
                left.add(arr[i]);
            else
                right.add(arr[i]);
        }

        left.sort(null);
        right.sort(null);

        for (int i = 0; i < right.size(); i++) {
            curtrack = right.get(i);
            distance = Math.abs(head - curtrack);
            seek_count += distance;
            head = curtrack;
            seekSequence.add(curtrack);
        }
        head = 0;
        seek_count += (disksize - 1);
        for (int i = 0; i < left.size(); i++) {
            curtrack = left.get(i);
            distance = Math.abs(head - curtrack);
            seek_count += distance;
            head = curtrack;
            seekSequence.add(curtrack);
        }

        System.out.println("Total no of seek operations is : " + seek_count);
        System.out.print("Seek Sequence is : ");
        for (int i = 0; i < seekSequence.size(); i++)
            System.out.print(seekSequence.get(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60,
                92, 11, 41, 114 };
        int head = 50;
        int n = arr.length;
        cscan(arr, n, head);

    }
}
