class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        int[] freq2 = new int[26];
        int left = 0;
        int right = s1.length() - 1;
        for(char s: s1.toCharArray()) {
            freq[s - 'a'] += 1;
        }
        for (int i = 0; i <= right; i ++) {
            freq2[s2.charAt(i) - 'a'] += 1;
        }

        while (right < s2.length()) {
            if (Arrays.equals(freq, freq2)) {
                return true;
            } else {
                freq2[s2.charAt(left) - 'a'] -= 1;
                left += 1;
                right += 1;
                if (right < s2.length()) {
                    freq2[s2.charAt(right) - 'a'] += 1;
                }
            }
        }
        return false;
    }
}
