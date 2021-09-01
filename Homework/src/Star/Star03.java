package Star;

public class Star03 {

	public static void main(String[] args) {
		
		int leng = 3;
		for(int i = 1; i<=leng; i++) {
			for(int j = i; j<=leng-1; j++)
				System.out.printf(" ");
					for(int k = 0; k<i*2-1; k++) {
						System.out.printf("*");
					}
			System.out.println();
		}
	}
}