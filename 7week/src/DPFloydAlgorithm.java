

public class DPFloydAlgorithm {
	
	private static int min(int a, int b) {
		if (a>b || a==-1) return b;
		else return a;
	}
	
	public static void main(String[] args) {
		
		int i,j,k;
		int[][] D = {{0,1,-1,1,5},
				{9,0,3,2,-1},
				{-1,-1,0,4,-1},
				{-1,-1,2,0,3},
				{3,-1,-1,-1,0}};
		
		int[][] P = new int[5][5];
		
		for (k=1; k<=5; k++) {
			for (i=1; i<=5; i++) {
				for (j=1; j<=5; j++) {
					if (D[i-1][k-1]!=-1 && D[k-1][j-1]!=-1)
						P[i-1][j-1]=k;
						D[i-1][j-1]=min(D[i-1][j-1], D[i-1][k-1] + D[k-1][j-1]);
				}
			}
			System.out.println();
		}
		
		for (i=0; i<5; i++) {
			for (j=0; j<5; j++) {
				System.out.printf("%4d" ,D[i][j]);
			}
			System.out.println();
		}
	}
}
