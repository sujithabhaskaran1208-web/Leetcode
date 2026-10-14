class Solution {
    public int[] findEvenNumbers(int[] digits) {
        java.util.Set<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {

                    if (i == j || j == k || i == k)
                        continue;

                    if (digits[i] == 0)
                        continue;

                    if (digits[k] % 2 != 0)
                        continue;

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    set.add(num);
                }
            }
        }

        int[] ans = new int[set.size()];
        int index = 0;

        for (int num : set) {
            ans[index++] = num;
        }

        java.util.Arrays.sort(ans);

        return ans;
    }
}