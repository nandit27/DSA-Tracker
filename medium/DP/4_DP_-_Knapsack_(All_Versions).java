import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight[] = new int[]{1,3,4,5};
        int[] value = new int[]{1,4,5,7};
        int weight_max = 7;
        int ans = knapsack(weight, value, weight_max, weight.length);
        int ans1 = knapsackMemo(weight, value, weight_max, weight.length);
        System.out.println(ans);
        System.out.println(ans1);   
        int[][] t = new int[weight.length + 1][weight_max + 1];
        for (int[] row : t) Arrays.fill(row, -1);    
        sc.close();
    }
    //Recursive Solution
    private static int knapsack(int weight[], int value[], int w, int n){
        if(n == 0 || w == 0) return 0;

        if(weight[n-1] <= w){
            return Math.max(value[n-1] + knapsack(weight,value,w - weight[n-1],n-1), knapsack(weight,value,w,n-1));
        }
        else{
            return knapsack(weight,value,w,n-1);
        }
    }
    //Memoisation
    private static int knapsackMemo(int weight[], int value[], int w, int n){
        if(n == 0 || w == 0) return 0;
        if(t[n][w] != -1) return t[n][w];
        if(weight[n-1] <= w){
            t[n][w] = Math.max(value[n-1] + knapsackMemo(weight, value, w - weight[n-1], n-1), knapsackMemo(weight, value, w, n-1));
        }
        else{
            t[n][w] = knapsackMemo(weight, value, w, n-1);
        }
        return t[n][w];
    }
    //Top-Down DP
    private static int knapsackTD(int weight[], int value[], int w, int n){
        int[][] t = new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
                else if(weight[i-1] <= j){
                    t[i][j] = Math.max(value[i-1] + t[i-1][j-weight[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }
}

// public class BFSExample{
//     public void bfs(Map<Integer, List<Integer>> graph, int start){
//         Queue<Integer> queue = new LinkedList<>();
//         Set<Integer> visited = new HashSet<>();

//         queue.offer(start);
//         visited.add(start);

//         while(!queue.isEmpty()){
//             int current = queue.poll();
//             System.out.println("Visited: " + current);
//             for(int neighbor : graph.getOrDefault(current, new ArrayList<>())){
//                 if(!visited.contains(neighbor)){
//                     visited.add(neighbor);
//                     queue.offer(neighbor);
//                 }
//             }
//         }
//     }
// }

// public class TreeBFS{
//     public List<List<Integer>> levelOrder(TreeNode root){
//         List<List<Integer>> result = new ArrayList<>();
//         if(root == null) return result;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while(!queue.isEmpty()){
//             int size = queue.size();
//             List<Integer> level = new ArrayList<>();

//             for(int i=0;i<size;i++){
//                 TreeNode current = queue.poll();
//                 level.add(current.val);

//                 if(current.left != null) queue.offer(current.left);
//                 if(current.right != null) queue.offer(current.right);
//             }
//             result.add(level);
//         }
//     }
// }

//Djsktra's algorithm 
// public class WeightedBFS{
//     public int dijkstra(Map<Integer, List<int[]>> graph, int start, int target, int n){
//         int[] dist = new int[n+1];
//         Arrays.fill(dist,Integer.MAX_VALUE);
//         dist[start] = 0;

//         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//         pq.offer(new int[]{0, start});
//         while(!pq.isEmpty()){
//             int[] cirrent = pq.poll();
//             int cost = current[0],node = current[1];
//             if(node == target) return cost;

//             for(int[] neighbor : graph.getOrDefault(node, new ArrayList<>())){
//                 int nextNode = neighbor[0], weight = neighbor[1];
//                 int newDist = cost + weight;

//                 if(newDist < dist[mextNode]){
//                     dist[nextNode] = newDist;
//                     pq.offer(new int[]{newDist, nextNode});
//                 }
//             }
//         }
//     }
// }