import java.util.*;

public class Paging_technique {
    public static void main(String[] args) {
        int n, ms, ps, nop;
        Scanner sc = new Scanner(System.in);
        int s[] = new int[20];
        int fno[][] = new int[20][20];
        System.out.println("Enter the memory size");
        ms = sc.nextInt();
        System.out.println("Enter the page size: ");
        ps = sc.nextInt();
        nop = ms / ps;
        System.out.println("No of available pages are : " + nop);
        int rempages = nop;
        System.out.println("Enter the no of processes");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter the no of pages required for process p[" + i + "] : ");
            s[i] = sc.nextInt();
            if (s[i] > rempages) {
                System.out.println("Memeory is full");
                break;
            }
            rempages -= s[i];
            System.out.println("Enter the page table for process p[" + i + "] : ");
            for (int j = 0; j < s[i]; j++)
                fno[i][j] = sc.nextInt();
        }
        System.out.println("Enter the logical address to find physical address");
        System.out.println("Enter the process no , pageno and offset");
        int x, y, offset, pa;
        x = sc.nextInt();
        y = sc.nextInt();
        offset = sc.nextInt();
        if (x > n || y > nop || offset > ps) {
            System.out.println("Invalid input");
        } else {
            pa = fno[x][y] * ps + offset;
            System.out.println("Physical address is : " + pa);
        }

        sc.close();
    }
}
