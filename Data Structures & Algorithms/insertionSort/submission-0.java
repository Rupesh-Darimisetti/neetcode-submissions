// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        List<List<Pair>> res = new ArrayList<>();
        for(int pos = 0; pos < n; pos++){
            int curr_pos = pos -1;
            while(curr_pos >=0 && pairs.get(curr_pos).key >pairs.get(curr_pos + 1).key ){
                Pair temp = pairs.get(curr_pos);
                pairs.set(curr_pos, pairs.get(curr_pos + 1));
                pairs.set(curr_pos + 1, temp);
                curr_pos--;
            }
            List<Pair> cloneList = new ArrayList<>(pairs);
            res.add(cloneList);
        }
        return res;
    }
}
