import java.util.*;

public class Pabonazzi {
	
	public static int p(int n) {
		if (n==2 || n==3) {
			return 1;
		}
		else if (n<=1) {
			return 0;
		}
		return p(n-1)+p(n-2);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		System.out.println(p(n-1)+p(n-2));
	}
}
