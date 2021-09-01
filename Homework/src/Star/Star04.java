package Star;

public class Star04 {

	public static void main(String[] args) {
		
		int leng = 7;
		for(int i = 1; i<=leng; i++) {
			for(int j = i; j<=leng-1; j++) 
				System.out.printf(" ");
				for(int k = 0; k<i; k++) {
					System.out.printf("*");
				}
			System.out.println();
	}

	}

}
