class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitsToCharacter = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }

        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int position, String currentString, String digits) {
        if (currentString.length() == digits.length()) {
            res.add(currentString);
            return;
        }

        String characters = digitsToCharacter[digits.charAt(position) - '0'];

        for (char character : characters.toCharArray()) {
            backtrack(position + 1, currentString + character, digits);
        }
    }
}
