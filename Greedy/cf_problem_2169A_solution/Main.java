import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            long a = sc.nextLong();
            
            int count_low = 0;
            int count_high = 0;
            
            for (int i = 0; i < n; i++) {
                long val = sc.nextLong();
                if (val < a) count_low++;
                else if (val > a) count_high++;
            }
            
            
            if (count_high > count_low) {
                System.out.println(a + 1);
            } else {
         
                if (a == 1 && n > 1) System.out.println(2);
                else if (count_low >= count_high) System.out.println(a - 1);
                else System.out.println(a + 1);
            }
        }
    }
}
