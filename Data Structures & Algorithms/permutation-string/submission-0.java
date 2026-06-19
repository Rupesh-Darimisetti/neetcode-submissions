class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int pos = 0; pos < s1.length(); pos++) {
            s1Count[s1.charAt(pos) - 'a']++;
            s2Count[s2.charAt(pos) - 'a']++;
        }

        int matches = 0;
        for (int pos = 0; pos < 26; pos++) {
            if (s1Count[pos] == s2Count[pos]) {
                matches++;
            }
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(right) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}
