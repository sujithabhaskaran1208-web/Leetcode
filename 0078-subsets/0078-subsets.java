class Solution { 
    public List<List<Integer>> subsets(int[] nums) { 
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result); 
        return result; 
    } 

    private void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> result) { 
        result.add(new ArrayList<>(path)); 
        
        for (int i = index; i < nums.length; i++) { 
            path.add(nums[i]);             // Choose the element
            backtrack(nums, i + 1, path, result); // Explore next elements
            path.remove(path.size() - 1);  // Un-choose (backtrack)
        } 
    } 
}