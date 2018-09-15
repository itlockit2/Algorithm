#include <iostream>

using namespace std;

void quickSort(int *data, int start , int end){
    // start가 end보다 크다는것은 원소가 1개인 경우이다.
    if(start >= end){
        return;
    }
    int key = start;
    // 왼쪽 출발지점
    int i = start + 1;
    // 오른쪽 출발지점
    int j = end;
    // 엇 갈릴때 까지 반복
    while(i <= j){
        /// 키값보다 큰값을 찾는다.
        while(data[i] <= data[key]){
            i++;
        }
        // 키값보다 작은값을 찾는다.
        while(data[j] >= data[key] && j > start){
            j--;
        }
        // 엇갈렷다면 키값 작은값을 바꿔준다.
        if( i > j){
            int temp = data[key];
            data[key] = data[j];
            data[j] = temp;
        } else {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
    // j에 Pivot값이 들어가게 되고 
    // Pivot값 기준으로 왼쪽은 작게, 오른쪽은 크게 정렬이 되었다.
    quickSort(data, start, j-1);
    quickSort(data,j+1 , end);
}

int main(){
    int array[10] = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
    quickSort(array,0,9);
    for(int i = 0 ; i < 10 ; i++){
        cout << array[i] << " " ;
    }
    
}