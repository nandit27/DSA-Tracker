import java.util.Scanner;
import java.util.Stack;

public class deleteAdj {
    public static class Pair{
        char ch;
        int cnt;

        Pair(char ch, int cnt){
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    //i/p = "airporqqt" k = 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String str = sc.next();
            int k = sc.nextInt();
            Stack<Pair> stk = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(!stk.isEmpty() && stk.peek().ch == ch){
                    stk.peek().cnt++;

                    if(stk.peek().cnt == k) {
                        stk.pop();
                    }
                }
                else{
                    stk.push(new Pair(ch,1));
                }
            }
            StringBuilder result = new StringBuilder();
            for(Pair p : stk){
                for(int i = 0; i < p.cnt; i++){
                    result.append(p.ch);
                }
            }
            System.out.println(result.toString());
        }
    }
