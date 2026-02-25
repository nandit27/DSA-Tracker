import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wordSearch {
    private static int rows, cols;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        char[][] grid = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        rows = a;
        cols = b;

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exists(grid, word)) {
                result.add(word);
            }
        }
        System.out.println(String.join(" ", result));
    }
    public static boolean exists(char[][] grid, String word){
        if(word.isEmpty()) return true;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    if (dfs(grid, visited, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] grid,boolean[][] visited, String word, int idx, int i, int j){
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] != word.charAt(idx)){
            return false;
        }

        visited[i][j] = true;
        boolean found = dfs(grid,visited,word,idx+1,i+1,j) ||
                        dfs(grid,visited,word,idx+1,i-1,j) ||
                        dfs(grid,visited,word,idx+1,i,j+1) ||
                        dfs(grid,visited,word,idx+1,i,j-1);

        visited[i][j] = false;
        return found;
    }
}
