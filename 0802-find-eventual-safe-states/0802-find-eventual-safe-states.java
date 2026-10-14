class Solution {
public List<Integer> eventualSafeNodes(int[][] graph) {
int n = graph.length;
int[] indegree = new int[n];

    List<List<Integer>> reverse = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        reverse.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
        for (int next : graph[i]) {
            reverse.get(next).add(i);
            indegree[i]++;
        }
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }

    List<Integer> safe = new ArrayList<>();

    while (!queue.isEmpty()) {
        int node = queue.poll();
        safe.add(node);

        for (int prev : reverse.get(node)) {
            indegree[prev]--;

            if (indegree[prev] == 0) {
                queue.offer(prev);
            }
        }
    }

    Collections.sort(safe);
    return safe;
}

}