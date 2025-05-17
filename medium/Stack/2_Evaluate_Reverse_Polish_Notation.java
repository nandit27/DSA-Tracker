import java.util.*;
 
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
             if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int op2 = stk.pop(); 
                int op1 = stk.pop();
                int result = 0;

                if(token.equals("+")) result = op1 + op2;
                else if(token.equals("-")) result = op1 - op2;
                else if(token.equals("*")) result = op1 * op2;
                else result = op1 / op2;  

                stk.push(result);            
            }
            else{
                stk.push(Integer.parseInt(token));
            }
        }
        return stk.pop();
    }
}