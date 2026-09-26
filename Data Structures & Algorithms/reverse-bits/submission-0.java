class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int pos=0;pos<32;pos++){
           int bit = (n>>pos)&1;
           res+=(bit<<(31-pos));
        }
        return res;
    }
}
