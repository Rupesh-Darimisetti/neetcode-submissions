class Solution {
    public int[] countBits(int n) {
        int[]res=new int[n+1];
        for(int pos=0;pos<=n;pos++){
            res[pos]=Integer.bitCount(pos);
        }
        return res;
    }
}
