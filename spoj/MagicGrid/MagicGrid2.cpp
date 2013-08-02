#include<stdio.h>

int Mmax(int a, int b){
	return (a>b ? a : b);
}

int Mmin(int a, int b){
	return (a<b ? a : b);
}

int solve(int S[500][500], int R, int C){
	int sol[R][C];
	sol[R-1][C-1] = 0;
	for(int i=R-2; i>=0; i--)
		sol[i][C-1] = sol[i+1][C-1]-S[i][C-1];
	for(int j=C-2; j>=0; j--)
		sol[R-1][j] = sol[R-1][j+1]-S[R-1][j];
	for(int i=R-2; i>=0; i--){
		for(int j=C-2; j>=0; j--){
			sol[i][j] = Mmin(sol[i+1][j],sol[i][j+1]) - S[i][j];
			if(sol[i][j]<1)		sol[i][j] = 0;
		}
	}
	return sol[0][0]+1;
}

int main(){
	int T,R,C,S[500][500];
	scanf("%d",&T);
	for(int t=0; t<T; t++){
		scanf("%d %d",&R,&C);
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				scanf("%d",&S[i][j]);
			}
		}
		printf("%d\n",solve(S,R,C));
	}
	return 0;
}