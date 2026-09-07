class Solution {
public:
    int distinctSubseqII(string s) {

        long long MOD = 1e9 + 7;
        std::vector<long long> last(26, 0);
        long long total_subseq = 0;

        for (char c : s) {
            int idx = c - 'a';
            
            long long added = (total_subseq + 1 - last[idx] + MOD) % MOD;
            total_subseq = (total_subseq + added) % MOD;
            last[idx] = (last[idx] + added) % MOD;
        }

        return total_subseq;
        
    }
};