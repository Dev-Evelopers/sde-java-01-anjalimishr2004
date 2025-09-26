import java.util.*;

public class MinFolds {

    
    private static int foldsNeeded(long from, long to) {
        int folds = 0;
        while (from > to) {
            
            long next = (from + 1) / 2; 
            if (next < to) {
               
                from = to;
            } else {
                from = next;
            }
            folds++;
        }
        return folds;
    }

    public static int minMoves(long h, long w, long h1, long w1) {
        
        int folds1 = foldsNeeded(h, h1) + foldsNeeded(w, w1);

        
        int folds2 = foldsNeeded(h, w1) + foldsNeeded(w, h1);

        return Math.min(folds1, folds2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long h = sc.nextLong();
        long w = sc.nextLong();
        long h1 = sc.nextLong();
        long w1 = sc.nextLong();

        System.out.println(minMoves(h, w, h1, w1));
    }
}
