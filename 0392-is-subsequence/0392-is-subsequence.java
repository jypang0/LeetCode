class Solution {
    public boolean isSubsequence(String s, String t) {
        int sP = 0;
        int tP = 0;

        while(sP<s.length() && tP<t.length()) {
            if(s.charAt(sP)==t.charAt(tP)) sP++;
            tP++;
        }

        return sP==s.length();
    }
    // public boolean isSubsequence(String s, String t) {

    //     int sL = s.length();
    //     int tL = t.length();

    //     if(sL==0) return true;
    //     if(sL>tL) return false;

    //     // s's index
    //     int sI = 0;
    //     char cur = s.charAt(sI);

    //     for(int tI=0;tI<tL;tI++) {
    //         if(cur==t.charAt(tI)) {
    //             sI++;
    //             if(sI==sL) {
    //                 return true;
    //             }
    //             cur = s.charAt(sI);
    //         }
    //     }

    //     return false;
    // }
}