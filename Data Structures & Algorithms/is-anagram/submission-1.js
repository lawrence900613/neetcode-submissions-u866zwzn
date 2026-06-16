class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isAnagram(s, t) {
        if (s.length !== t.length) {
            return false;
        }

        const alphabetMap = Array(26).fill(0);

        for (let char of s) {
            const index = char.charCodeAt(0) - "a".charCodeAt(0);
            alphabetMap[index]++;
        }

        for (let char of t) {
            const index = char.charCodeAt(0) - "a".charCodeAt(0);
            alphabetMap[index]--;

            if (alphabetMap[index] < 0) {
                return false;
            }
        }

        return true;
    }
}
