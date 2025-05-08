import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long[] arr = new long[(int)n];
        for(int i=0;i<n;i++) arr[i] = sc.nextLong();
        long count = 0;
        for(int i=1;i<n;i++){
            if(arr[i] <= arr[i-1]){
                count+= Math.abs(arr[i-1]-arr[i]);
                arr[i] = arr[i-1];
            }
            else{
                continue;
            }
        }
        System.out.println(count);
        sc.close();

}
}
