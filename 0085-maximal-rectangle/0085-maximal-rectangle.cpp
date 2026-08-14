class Solution {
public:
    stack <int> st;
    int largestRectangleArea(vector<int> &height)
    {
        int n = height.size();
        int maxarea = 0;
        for(int i = 0; i<=n; i++)
        {
       while(!st.empty() && (i == n || height[st.top()] >= height[i]))
        {
            int heightt = height[st.top()];
            st.pop();
            int width;
            if(st.empty())
            width = i;
            else
            {
                width = i - st.top() - 1;
            }
             maxarea = max(maxarea,heightt * width);
            }
                if(i < n)
                st.push(i);
        }
        return maxarea;
       
    }
    int maximalRectangle(vector<vector<char>>& matrix) {
        int maxarea = 0;
        int n = matrix.size();
        int m = matrix[0].size();
        vector<int> height(m,0);
        for(int i = 0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
           int area = largestRectangleArea(height);
            maxarea = max(maxarea,area);
        }

        return maxarea;    
    }
};