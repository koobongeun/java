package Star;

public class Star02 {
	public static void main(String[] args) {
		int leng = 3;
		for(int i = 1; i<=leng; i++) {
			for(int j = i; j<=0; j++)
				System.out.printf(" ");
					for(int k = 1; k<=i; k++) {
						System.out.printf("*");
					}
			System.out.println();
		}
		for(int i = leng-1; i>=1; i--) {
			for(int j = 0; j<0; j++)
				System.out.printf(" ");
					for(int k = 1; k<=i; k++) {
						System.out.printf("*");
					}
			System.out.println();
		}
	}
}
