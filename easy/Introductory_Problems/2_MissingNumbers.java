import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long sum = 0;
        long actualSum = (n*(n+1))/2;
        for(int i=1;i<n;i++) sum += sc.nextInt();
        System.out.println(actualSum-sum);
        sc.close();
    }
}
