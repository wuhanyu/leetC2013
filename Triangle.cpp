class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
        if (triangle.size() == 0) return 0;
        for (int i = 1; i < triangle.size(); i++){
            triangle[i][0] += triangle[i-1][0];
            for (int j = 1; j < i; j++){
                triangle[i][j] += min(triangle[i-1][j-1], triangle[i-1][j]);
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        int min = 100000;
        for (int i = 0; i < triangle.size(); i++){
            if (triangle[triangle.size() - 1][i] < min) min = triangle[triangle.size() - 1][i];
        }
        return min;
    }
};
