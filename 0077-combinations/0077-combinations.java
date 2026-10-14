class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, new ArrayList<>());
        return result;
    }
    void backtrack(int n, int k, int start, List<Integer> path) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {

            path.add(i);
            backtrack(n, k, i + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
