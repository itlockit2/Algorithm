#include <iostream>

int mat[501][501] = {0};

int block[4][3][2] = {
	{{-1,0},{0,1},{1,0}},
	{{0,-1},{0,1},{1,0}},
	{{-1,0},{1,0},{0,-1}},
	{{-1,0},{0,-1},{0,1}}
};
void specialBlock(int x,int y, int N, int M, int* max){
	for(int i = 0; i < 4; i++){
		int sum = mat[x][y];
		for(int j = 0 ; j < 3; j++){
			int moveX = x + block[i][j][0];
			int moveY = y + block[i][j][1];
		    if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M )
		    {
		    	break;
		    }
		    sum = sum + mat[moveX][moveY];
		}
        *max = *max < sum ? sum : *max;
	}
    
}

void dfs(int x, int y, int N, int M, int level, int sum, int* max, int prevX, int prevY)
{
    if (x < 0 || x >= N || y < 0 || y >= M )
    {
        return;
    }
    sum = sum + mat[x][y];
	//printf("x = %d y = %d level = %d sum = %d max = %d\n", x,y,level,sum,*max);
    if (level == 4)
    {
        *max = *max < sum ? sum : *max;
        return;
    }
    if(x+1 != prevX|| y != prevY){
    dfs(x+1,y,N,M,level+1,sum,max,x,y);
    }
    if(x != prevX||y+1 != prevY){
    dfs(x,y+1,N,M,level+1,sum,max,x,y);
    }
    if(x-1 != prevX||y != prevY){
    dfs(x-1,y,N,M,level+1,sum,max,x,y);
    }
    if(x != prevX||y-1 != prevY){
    dfs(x,y-1,N,M,level+1,sum,max,x,y);
    }
}

int main()
{
    int result = 0;
    int N, M;
    scanf("%d %d", &N, &M);
    for (int x = 0; x < N; x++)
    {
        for (int y = 0; y < M; y++)
        {
            int number;
            scanf("%d", &number);
            mat[x][y] = number;
        }
    }
    for(int x = 0; x < N ; x++){
        for(int y = 0 ; y < M ; y++){
            dfs(x,y,N,M,1,0,&result,x,y);
            specialBlock(x,y,N,M,&result);
        }
    }
    printf("%d", result);
}