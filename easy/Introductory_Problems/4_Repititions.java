import java.util.*;
 
public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        long count = 1;
        long maxCount = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == str.charAt(i-1)){
                count++;
            }
            else{
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
        sc.close();
    }
}