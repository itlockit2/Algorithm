#include <iostream>
#include <vector>
using namespace std;

int gcd(int a, int b)
{
    if (b == 0)
    {
        return a;
    }
    else
    {
        return gcd(b, a % b);
    }
}

int main()
{
    int T;
    cin >> T;
    for (int i = 0; i < T; i++)
    {
        int N;
        cin >> N;
        vector<int> v;
        for (int j = 0; j < N; j++)
        {
            int number;
            cin >> number;
            v.push_back(number);
        }
        long long sum = 0;
        for (int x = 0; x < N; x++)
        {
            for (int y = x + 1; y < N; y++)
            {
                sum = sum + gcd(v[x], v[y]);
            }
        }
        cout << sum << endl;
    }
    return 0;
}