class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int happyChildren = 0;
        int childrenIdx = 0;

        for (int i = 0; i < s.length && happyChildren < g.length; i++) {
            int cookieSize = s[i];
            if (g[childrenIdx] <= cookieSize) {
                happyChildren++;
                childrenIdx++;
            }
        }

        return happyChildren;
    }
}