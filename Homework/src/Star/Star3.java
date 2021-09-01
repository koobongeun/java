package Star;

public class Star3 {

	public static void main(String[] args) {
	for(int i = 1; i<=5; i++) {
		for(int j = 1; j<=3; j++) {
			if(i==1||i==5) {
				if(j==1) {
					System.out.printf("*");
				}
				System.out.print(" ");
			}
			else if(i==2||i==4) {
				if(j==3) {
					System.out.printf(" ");
				}
				else {
					System.out.print("*");
				}
			}
			else {
				System.out.printf("*");
				}
		}
		System.out.println();
	}
	}
}