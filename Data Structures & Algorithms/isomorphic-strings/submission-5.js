class Solution {
    /**
     * @param {string} s
     * @param {string} t
     * @return {boolean}
     */
    isIsomorphic(s, t) {
        if(s.length != t.length) {
            return false;
        }

        let mapS = new Array(256).fill(0);
        let mapT = new Array(256).fill(0);

        for(let i = 0; i < s.length; i++) {
            let c1 = s.charCodeAt(i);
            let c2 = t.charCodeAt(i);

            if (mapS[c1] != mapT[c2]) {
                return false;
            }

            mapS[c1] += i + 1;
            mapT[c2] += i + 1;
        }

        return true;

    }
}
