import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        List<Integer> ls = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n%i == 0) {
                ls.add(i);
                while (n%i == 0) n = n/i;
            }
        }
        if (n != 1) ls.add(n);
        System.out.println(ls.toString());
        sc.close();
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