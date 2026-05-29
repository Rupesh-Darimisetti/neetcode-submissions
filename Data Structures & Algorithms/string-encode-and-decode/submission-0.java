class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){return"";}

        StringBuilder res = new StringBuilder();
        List<Integer>sizes = new ArrayList<>();

        for(String str:strs){
            sizes.add(str.length());
        }
        for(int size:sizes){
            res.append(size).append(',');
        }
        res.append('#');
        for(String str:strs){
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length()==0){
            return new ArrayList<>();
        }
        List<String> res=new ArrayList<>();
        List<Integer>sizes=new ArrayList<>();
        int pos =0;
        while(str.charAt(pos)!='#'){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(pos)!= ','){
                cur.append(str.charAt(pos));
                pos++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            pos++;
        }
        pos++;
        for(int size:sizes){
            res.add(str.substring(pos,pos+size));
            pos+=size;
        }
        return res;
    }
}
