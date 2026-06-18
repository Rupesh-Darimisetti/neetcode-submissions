class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charMap = new HashMap<>();

        int left = 0, res = 0, maxf = 0, len = s.length();

        for (int right = 0; right < len; right++) {
            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);
            maxf = Math.max(maxf, charMap.get(s.charAt(right)));

            while ((right - left + 1) - maxf > k) {
                charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
