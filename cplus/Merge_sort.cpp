#include <iostream>

using namespace std;

int sorted[8];

void merge(int data[], int start, int middle, int end)
{
    int i = start;
    int j = middle + 1;
    int k = start;
    //작은 순서대로 배열에 삽입
    while (i <= middle && j <= end)
    {
        if (data[i] <= data[j])
        {
            sorted[k] = data[i];
            i++;
        }
        else
        {
            sorted[k] = data[j];
            j++;
        }
        k++;
    }
    // 남은 데이터 삽입
    if (i > middle)
    {
        for (int x = j; x <= end; x++)
        {
            sorted[k] = data[x];
            k++;
        }
    }
    else 
    {
        for (int x = i; x <= middle; x++)
        {
            sorted[k] = data[x];
            k++;
        }
    }

    // 정렬된 값 삽입
    for (int x = start; x <= end; x++)
    {
        data[x] = sorted[x];
    }
}

void mergeSort(int data[], int m, int n)
{
    // 크기가 1보다 큰경우
    if (m < n)
    {
        int middle = (m + n) / 2;
        mergeSort(data, m, middle);
        mergeSort(data, middle + 1, n);
        merge(data, m, middle, n);
    }
}

int main(int argc, char const *argv[])
{
    /* code */
    int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    mergeSort(array, 0, 9);
    for (int i = 0; i < 10; i++)
    {
        cout << array[i] << " ";
    }
    return 0;
}
