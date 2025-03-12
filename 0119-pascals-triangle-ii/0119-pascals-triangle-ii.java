class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            int first = 1;
            int second = 1;
            for (int j = 0; j <= i/2; j++) {
                if (j == 0) {
                    row[j] = 1;
                    row[i-j] = 1;
                } else {
                    first = second;
                    second = row[j];
                    row[j] = first + second;
                    row[i-j] = first + second;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(row[i]);
        }
        return ans;
    }
}