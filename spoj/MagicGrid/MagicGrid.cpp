#include<stdio.h>

int Mmax(int a, int b){
	return (a>b ? a : b);
}

int Mmin(int a, int b){
	return (a<b ? a : b);
}
	
int minn(int S[500][500], int i, int j){
	int min = S[i][j];
	while(i>0 && j>0){
		if(S[i-1][j]==S[i][j-1])			return Mmin(min,Mmax(minn(S,i-1,j),minn(S,i-1,j)));
		if(S[i-1][j]>=S[i][j-1])			min = Mmin(S[--i][j],min);
		else								min = Mmin(S[i][--j],min);
	}
	if(i==0){
		while(j>=0)			min = Mmin(min,S[i][j--]);
	}else{
		while(i>=0)			min = Mmin(min,S[i--][j]);
	}
	return min;
}

int solve(int S[500][500], int R, int C){
	for(int i=1; i<R; i++)
		S[i][0] += S[i-1][0];
	for(int j=1; j<C; j++)
		S[0][j] += S[0][j-1];
	for(int i=1; i<R; i++){
		for(int j=1; j<C; j++){
			S[i][j] += Mmax(S[i-1][j],S[i][j-1]);
		}
	}
/*	int i = R-1, j=C-1;
	int min = S[i][j];
	while(i>0 && j>0){
		if(S[i-1][j]>=S[i][j-1])			min = Mmin(S[--i][j],min);
		else								min = Mmin(S[i][--j],min);
	}
	if(i==0){
		while(j>=0)			min = Mmin(min,S[i][j--]);
	}else{
		while(i>=0)			min = Mmin(min,S[i--][j]);
	}
	return (min>0 ? 1 : 1-min);
}
*/
	int min = minn(S,R-1,C-1);
	return (min>0 ? 1 : 1-min);
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