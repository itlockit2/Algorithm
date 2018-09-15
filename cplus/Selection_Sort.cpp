#include<iostream>
#include <limits.h>

using namespace std;

int main(){
    int min, index, temp;
    int array[10] = {1,10,5,8,7,6,4,3,2,9};
    for(int i = 0; i < 10; i++){
        min = INT_MAX;
        for(int j = i ; j < 10 ; j++){
            if(array[j] < min){
                min = array[j];
                index = j;
            }
        }
        temp = array[i];
        array[i] = array[index];
        array[index] = temp;
    }
    for(int i = 0 ; i < 10 ; i++){
        cout << array[i] << " ";
    }
}