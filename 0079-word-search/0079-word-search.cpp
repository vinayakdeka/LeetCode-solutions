class Solution {
public:

    int m, n;

    vector<vector<int>> dir{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    bool find(int i, int j,
              vector<vector<char>>& board,
              int indx,
              string& word)
    {
        if(indx == word.size())
            return true;

        if(i < 0 || j < 0 || i >= m || j >= n ||
           board[i][j] == '$')
        {
            return false;
        }

        if(board[i][j] != word[indx])
            return false;

        char temp = board[i][j];
        board[i][j] = '$';

        for(auto &d : dir)
        {
            int new_i = i + d[0];
            int new_j = j + d[1];

            if(find(new_i, new_j, board, indx + 1, word))
                return true;
        }

        board[i][j] = temp;

        return false;
    }

    bool exist(vector<vector<char>>& board, string word)
    {
        m = board.size();
        n = board[0].size();

        // Count characters in board
        vector<int> freq(128, 0);

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                freq[board[i][j]]++;
            }
        }

        // If word needs more of a character than board has
        vector<int> need(128, 0);

        for(char c : word)
        {
            need[c]++;

            if(need[c] > freq[c])
                return false;
        }

        // Start from the rarer end of the word
        if(freq[word.front()] > freq[word.back()])
        {
            reverse(word.begin(), word.end());
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word[0])
                {
                    if(find(i, j, board, 0, word))
                        return true;
                }
            }
        }

        return false;
    }
};