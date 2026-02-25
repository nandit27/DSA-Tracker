import java.util.Scanner;
import java.util.*;

public class slidingPuzzle {
    private static int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private static final String target = "123450";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[2][3];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = sc.nextInt();
            }
        }
        for(int[] row: board){
            for(int num: row){
                sb.append(num);
            }
        }
        String start = sb.toString();

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                if(curr.equals(target)){
                    System.out.println(moves);
                    return;
                }
                int idx = curr.indexOf('0');
                int row = idx / 3;
                int col = idx % 3;
                for(int[] dir: directions){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr >= 0 && nr < 2 && nc >= 0 && nc < 3) {
                        int newPos = nr * 3 + nc;
                        char[] chars = curr.toCharArray();
                        chars[idx] = chars[newPos];
                        chars[newPos] = '0';
                        String next = new String((chars));
                        if (!set.contains(next)) {
                            set.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            moves++;
        }
        System.out.println(-1);
    }
}
