import java.util.*;

public class LRU_page_replacement {
    static int countPageFault(int pages[], int n, int capacity) {
        int page_faults = 0;
        HashSet<Integer> s = new HashSet<>(capacity);
        HashMap<Integer, Integer> indexes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    page_faults++;
                    s.add(pages[i]);
                }
                indexes.put(pages[i], i);
            } else {
                if (!s.contains(pages[i])) {
                    page_faults++;
                    int lru = Integer.MAX_VALUE, val = 0;
                    Iterator<Integer> itr = s.iterator();
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (indexes.get(temp) < lru) {
                            lru = indexes.get(temp);
                            val = temp;
                        }
                    }
                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);
                }
                indexes.put(pages[i], i);
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
