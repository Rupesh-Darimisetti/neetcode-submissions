class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res=new int[len];
        Stack<int[]>stack=new Stack<>();

        for(int pos =0;pos<len;pos++){
            int temp = temperatures[pos];
            while(!stack.isEmpty()&&temp>stack.peek()[0]){
                int[]pair=stack.pop();
                res[pair[1]]=pos-pair[1];
            }
            stack.push(new int[]{temp,pos});
        }
        return res;
    }
}
