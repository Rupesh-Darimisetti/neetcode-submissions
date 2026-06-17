class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int left = 0, res = 0, len = s.length();
        for (int right = 0; right < len; right++) {
            if (charMap.containsKey(s.charAt(right))) {
                left = Math.max(charMap.get(s.charAt(right)) + 1, left);
            }
            charMap.put(s.charAt(right), right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
