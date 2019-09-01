#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int M;
    vector<int> v;
    scanf("%d", &M);
    for (int i = 0; i < M; i++)
    {
        int number;
        scanf("%d", &number);
        v.push_back(number);
    }
    int Q;
    scanf("%d", &Q);
    for (int i = 0; i < Q; i++)
    {
        int N, X;
        scanf("%d %d", &N, &X);
        bool check[200000] = {false};
        check[X - 1] = true;
        int result = v[X - 1];
        bool isLoop = false;
        for (int j = 1; j < N; j++)
        {
            // if already check
            if (check[result] == true)
            {
                isLoop = true;
                N = N - j - 1;
                break;
            }
            check[result] = true;
            result = v[result - 1];
        }
        vector<int> loopArray;
        if (isLoop)
        {
            for (int j = 0; j < N; j++)
            {
                if (check[result] == false)
                {
                    break;
                }
                loopArray.push_back(result);
                check[result] = false;
            }
        }
        for (int j = 0; j < loopArray.size(); j++)
        {
            cout << loopArray[j] << " ";
        }
        cout << endl;
        printf("%d\n", result);
    }
    return 0;
}