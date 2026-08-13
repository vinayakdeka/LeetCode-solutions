class Solution {
public:

    struct Node {
        int mx;      // maximum repeating substring
        int lmx;     // maximum repeating prefix
        int rmx;     // maximum repeating suffix
        int len;     // length of segment
        char lc;      // left character
        char rc;      // right character
    };

    vector<Node> seg;

    Node merge(Node left, Node right) {

        Node ans;

        ans.len = left.len + right.len;
        ans.lc = left.lc;
        ans.rc = right.rc;

        // Initially, maximum is from either side
        ans.mx = max(left.mx, right.mx);

        ans.lmx = left.lmx;
        ans.rmx = right.rmx;

        // We can join the two segments
        if (left.rc == right.lc) {

            // A repeating substring crosses the boundary
            ans.mx = max(ans.mx, left.rmx + right.lmx);

            // Entire left segment is same character
            if (left.lmx == left.len) {
                ans.lmx = left.len + right.lmx;
            }

            // Entire right segment is same character
            if (right.rmx == right.len) {
                ans.rmx = right.len + left.rmx;
            }
        }

        return ans;
    }

    void build(int idx, int l, int r, string &s) {

        if (l == r) {

            seg[idx].mx = 1;
            seg[idx].lmx = 1;
            seg[idx].rmx = 1;
            seg[idx].len = 1;

            seg[idx].lc = s[l];
            seg[idx].rc = s[l];

            return;
        }

        int mid = (l + r) / 2;

        build(2 * idx, l, mid, s);
        build(2 * idx + 1, mid + 1, r, s);

        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
    }

    void update(int idx, int l, int r, int pos, char ch) {

        if (l == r) {

            seg[idx].mx = 1;
            seg[idx].lmx = 1;
            seg[idx].rmx = 1;
            seg[idx].lc = ch;
            seg[idx].rc = ch;

            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid)
            update(2 * idx, l, mid, pos, ch);
        else
            update(2 * idx + 1, mid + 1, r, pos, ch);

        seg[idx] = merge(seg[2 * idx], seg[2 * idx + 1]);
    }

    vector<int> longestRepeating(string s, string queryCharacters,
                                 vector<int>& queryIndices) {

        int n = s.size();

        seg.resize(4 * n);

        // Build segment tree
        build(1, 0, n - 1, s);

        vector<int> ans;

        for (int i = 0; i < queryIndices.size(); i++) {

            int index = queryIndices[i];
            char ch = queryCharacters[i];

            // Update the character
            update(1, 0, n - 1, index, ch);

            // Root contains answer for entire string
            ans.push_back(seg[1].mx);
        }

        return ans;
    }
};