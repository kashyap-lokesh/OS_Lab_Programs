import java.util.*;

public class FIFO_page_replacement {
    static int countPageFault(int pages[], int n, int capacity) {
        int page_faults = 0;
        HashSet<Integer> s = new HashSet<>(capacity);
        Queue<Integer> indexes = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);
                    indexes.add(pages[i]);
                    page_faults++;
                }
            } else {
                if (!s.contains(pages[i])) {
                    int temp = indexes.peek();
                    indexes.poll();
                    s.remove(temp);
                    page_faults++;
                    indexes.add(pages[i]);
                    s.add(pages[i]);
                }
            }
        }
        return page_faults;
    }

    public static void main(String[] args) {
        int capacity = 4;
        int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        int n = pages.length;
        System.out.println("Page Faults : " + countPageFault(pages, n, capacity));
    }
}
