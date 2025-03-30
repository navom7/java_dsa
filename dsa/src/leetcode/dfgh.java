package leetcode;

import java.util.HashSet;

public class dfgh {
    class Solution {
        final long BASE = 131;

        public int longestPalindrome(String s, String t) {
            int n = s.length(), m = t.length();

            int best = Math.max(longestPalInOne(s), longestPalInOne(t));

            int[] extS = longestPalStart(s);
            int[] extT = longestPalEnd(t);

            long[] hashS = buildHash(s);
            long[] powS = buildPow(s.length());
            String revS = new StringBuilder(s).reverse().toString();
            long[] hashRevS = buildHash(revS);

            long[] hashT = buildHash(t);
            long[] powT = buildPow(t.length());
            String revT = new StringBuilder(t).reverse().toString();
            long[] hashRevT = buildHash(revT);

            @SuppressWarnings("unchecked")
            HashSet<Long>[] tHashSets = new HashSet[m+1];
            for (int len = 0; len <= m; len++) {
                tHashSets[len] = new HashSet<>();
            }
            for (int i = 0; i < m; i++) {
                for (int len = 1; i + len <= m; len++) {
                    long h = getHash(hashT, powT, i, i+len-1);
                    tHashSets[len].add(h);
                }
            }

            @SuppressWarnings("unchecked")
            HashSet<Long>[] sHashSets = new HashSet[n+1];
            for (int len = 0; len <= n; len++) {
                sHashSets[len] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                for (int len = 1; i + len <= n; len++) {
                    long h = getHash(hashS, powS, i, i+len-1);
                    sHashSets[len].add(h);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int L = 1; i + L <= n; L++) {
                    if (L > m) break;
                    long hashA = getHash(hashS, powS, i, i+L-1);
                    long hashRevA = getHash(hashRevS, powS, n - i - L, n - i - 1);
                    if (!tHashSets[L].contains(hashRevA)) continue;
                    int extra = 0;
                    if (i + L < n) {
                        extra = extS[i+L];
                    }
                    int candidate = extra + 2 * L;
                    best = Math.max(best, candidate);
                }
            }

            for (int j = 0; j < m; j++) {
                for (int L = 1; L <= j+1; L++) {
                    if (L > n) break;
                    long hashD = getHash(hashT, powT, j - L + 1, j);
                    long hashRevD = getHash(hashRevT, powT, m - 1 - j, m - j + L - 2);
                    if (!sHashSets[L].contains(hashRevD)) continue;
                    int extra = 0;
                    if (j - L >= 0) {
                        extra = extT[j - L];
                    }
                    int candidate = extra + 2 * L;
                    best = Math.max(best, candidate);
                }
            }
            return best;
        }

        private int longestPalInOne(String s) {
            int n = s.length(), res = 0;
            boolean[][] pal = new boolean[n][n];
            for (int i = n-1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i)==s.charAt(j) && (j-i < 2 || pal[i+1][j-1])) {
                        pal[i][j] = true;
                        res = Math.max(res, j-i+1);
                    }
                }
            }
            return res;
        }

        private int[] longestPalStart(String s) {
            int n = s.length();
            int[] ext = new int[n];
            boolean[][] pal = new boolean[n][n];
            for (int i = n-1; i >= 0; i--) {
                for (int j = i; j < n; j++) {
                    if (s.charAt(i)==s.charAt(j) && (j-i < 2 || pal[i+1][j-1])) {
                        pal[i][j] = true;
                        ext[i] = Math.max(ext[i], j-i+1);
                    }
                }
            }
            return ext;
        }

        private int[] longestPalEnd(String t) {
            int m = t.length();
            int[] ext = new int[m];
            boolean[][] pal = new boolean[m][m];
            for (int i = m-1; i >= 0; i--) {
                for (int j = i; j < m; j++) {
                    if (t.charAt(i)==t.charAt(j) && (j-i < 2 || pal[i+1][j-1])) {
                        pal[i][j] = true;
                        ext[j] = Math.max(ext[j], j-i+1);
                    }
                }
            }
            return ext;
        }

        private long[] buildHash(String s) {
            int n = s.length();
            long[] hash = new long[n];
            hash[0] = s.charAt(0);
            for (int i = 1; i < n; i++) {
                hash[i] = hash[i-1]*BASE + s.charAt(i);
            }
            return hash;
        }

        private long[] buildPow(int n) {
            long[] pow = new long[n+1];
            pow[0] = 1;
            for (int i = 1; i <= n; i++) {
                pow[i] = pow[i-1]*BASE;
            }
            return pow;
        }

        private long getHash(long[] hash, long[] pow, int l, int r) {
            if(l == 0) return hash[r];
            return hash[r] - hash[l-1]*pow[r-l+1];
        }
    }
}
