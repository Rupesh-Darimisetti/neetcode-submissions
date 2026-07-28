class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dynamicProgram = new boolean[len][len];
        for (int l = 1; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                dynamicProgram[i][i + l - 1] = (s.charAt(i) == s.charAt(i + l - 1)
                    && (i + 1 > (i + l - 2) || dynamicProgram[i + 1][i + l - 2]));
            }
        }
        return dfs(s, dynamicProgram, 0);
    }
    private List<List<String>> dfs(String s, boolean[][] dynamicProgram, int i) {
        if (i >= s.length()) {
            return new ArrayList<List<String>>() {
                {
                    add(new ArrayList<>());
                }
            };
        }
        List<List<String>> ret = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            if (dynamicProgram[i][j]) {
                List<List<String>> nxt = dfs(s, dynamicProgram, j + 1);
                for (List<String> part : nxt) {
                    List<String> curr = new ArrayList<>();
                    curr.add(s.substring(i, j + 1));
                    curr.addAll(part);
                    ret.add(curr);
                }
            }
        }
        return ret;
    }
}
