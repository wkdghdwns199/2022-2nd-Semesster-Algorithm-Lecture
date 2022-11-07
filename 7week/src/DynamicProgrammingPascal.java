import java.util.Scanner;

public class DynamicProgrammingPascal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] b = new int[200][200];
		b[0][0]=1;
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		
		for (int i=1; i<=n; i++) {
			for (int j=0; j<=k; j++) {
				if (j==0) b[i][j]=1;
				else b[i][j] = b[i-1][j-1]+b[i-1][j]; 
				 
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(b[n][k-1]);
	}
}
