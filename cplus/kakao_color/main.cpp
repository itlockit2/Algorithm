#include <vector>
using namespace std;

// dfs
void dfs(int x, int y, int m, int n, int *max, vector<vector<int>> picture, int value, bool check[][101])
{
    if (x < 0 || x >= m || y < 0 || y >= n || check[x][y] || picture[x][y] != value)
    {
        return;
    }
    check[x][y] = true;
    *max = *max + 1;
    dfs(x - 1, y, m, n, max, picture, value, check);
    dfs(x + 1, y, m, n, max, picture, value, check);
    dfs(x, y - 1, m, n, max, picture, value, check);
    dfs(x, y + 1, m, n, max, picture, value, check);
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture)
{

    bool check[101][101] = {false};
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    for (int x = 0; x < m; x++)
    {
        for (int y = 0; y < n; y++)
        {
            if (!check[x][y] && picture[x][y] != 0)
            {
                number_of_area++;
                int max = 0;
                dfs(x, y, m, n, &max, picture, picture[x][y], check);
                max_size_of_one_area = max_size_of_one_area < max ? max : max_size_of_one_area;
            }
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}