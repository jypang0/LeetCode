class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        dp.add(new ArrayList<>(List.of(1)));

        for(int i=1;i<numRows;i++) {
            List<Integer> row = new ArrayList<>(List.of(1));
            for(int j=1;j<i;j++) {
                row.add(dp.get(i-1).get(j-1) + dp.get(i-1).get(j));
            }
            row.add(1);
            dp.add(row);
        }

        return dp;
    }
}