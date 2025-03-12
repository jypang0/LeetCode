class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> before = new ArrayList<>(List.of(1));
        List<Integer> current = new ArrayList<>(List.of(1,1));

        if(rowIndex==0) {
            return before;
        } else if(rowIndex==1){
            return current;
        }

        int idx = 2;
        while(idx<=rowIndex) {
            before = current;
            current = new ArrayList<>(List.of(1));

            for(int i=1;i<idx;i++) {
                current.add(before.get(i-1)+before.get(i));
            }

            current.add(1);
            idx++;
        }

        return current;
    }
}