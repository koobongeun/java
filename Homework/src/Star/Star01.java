package Star;

public class Star01 {

	public static void main(String[] args) {
		int leng = 3;
		for(int i = 1; i<=leng; i++) {
			for(int j = i; j<=leng-1; j++)
				System.out.printf(" ");
					for(int k = 1; k<=i*2-1; k++) {
						System.out.printf("*");
					}
			System.out.println();
		}
		for(int i = leng-1; i>=1; i--) {
			for(int j = 0; j<leng-i; j++)
				System.out.printf(" ");
					for(int k = 1; k<=i*2-1; k++) {
						System.out.printf("*");
					}
			System.out.println();
		}
	}

}
