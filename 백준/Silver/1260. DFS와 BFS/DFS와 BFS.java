import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[N + 1];
        List<Integer> dfsResult = new ArrayList<>();
        List<Integer> bfsResult = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 1; i < N + 1; i++) {
            graph.put(i, graph.get(i).stream().sorted().collect(Collectors.toList()));
        }

        // dfs
        dfs(graph, V, dfsResult, visited);

        // bfs
        Arrays.fill(visited, false);
        bfs(graph, V, bfsResult, new LinkedList<>(), visited);
        
        System.out.println(dfsResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(bfsResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int node, List<Integer> result, boolean[] visited) {
        List<Integer> nodeList = graph.get(node); // 연결 노드 리스트
        visited[node] = true;
        result.add(node);
        for (int nextNode : nodeList) {
            if (!visited[nextNode]) {
                dfs(graph, nextNode, result, visited);
            }
        }
    }

    public static void bfs(Map<Integer, List<Integer>> graph, int node, List<Integer> result, Deque<Integer> deque, boolean[] visited) {
        visited[node] = true;
        result.add(node);
        deque.addAll(graph.get(node));

        while (!deque.isEmpty()) {
            int nextNode = deque.poll();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                result.add(nextNode);
                deque.addAll(graph.get(nextNode));
            }
        }
    }
}
