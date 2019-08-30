#include <iostream>
#include <algorithm>
using namespace std;

int primeCount = 0;
int primeNumberArray[1000000];
bool check[10000001];
int MAX_NUMBER = 1000000;

int main()
{
    check[0] = true;
    check[1] = true;
    // find primeNumber;
    for (int i = 2; i <= MAX_NUMBER; i++)
    {
        if (check[i] == false)
        {
            primeNumberArray[primeCount++] = i;
            for (int j = i + i; j <= MAX_NUMBER; j = j + i)
            {
                check[j] = true;
            }
        }
    }
    int n;
    scanf("%d", &n);
    while (n != 0)
    {
        // code here
        for (int i = 0; i < MAX_NUMBER; i++)
        {
            int number = primeNumberArray[i];
            if (number > n)
            {
                printf("Goldbach's conjecture is wrong.\n");
                break;
            }
            int anotherNumber = n - number;
            if (check[anotherNumber] == false)
            {
                printf("%d = %d + %d\n", n, number, anotherNumber);
                break;
            }
        }
        scanf("%d", &n);
    }
    return 0;
}