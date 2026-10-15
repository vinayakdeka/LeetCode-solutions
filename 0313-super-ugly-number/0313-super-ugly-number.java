
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] ugly = new int[n];
        int[] pointers = new int[k];

        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            // Find the smallest next candidate
            for (int j = 0; j < k; j++) {
                long candidate = (long) primes[j] * ugly[pointers[j]];
                min = Math.min(min, candidate);
            }

            ugly[i] = (int) min;

            // Advance every pointer that generated this minimum
            for (int j = 0; j < k; j++) {
                long candidate = (long) primes[j] * ugly[pointers[j]];

                if (candidate == min) {
                    pointers[j]++;
                }
            }
        }

        return ugly[n - 1];
    }
}
