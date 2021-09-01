package Star;

public class Star5 {

	public static void main(String[] args) {
	for(int i = 1; i<= 3; i++) {
		for (int j = 1; j<=3; j++) {
			if(i==1) {
				if(j==3)
				{
					System.out.printf("*");
				}
				else {
					System.out.printf(" ");
				}
			}
			else if(i==2) {
				if(j==1)
				{
					System.out.printf(" ");
				}
				else {
					System.out.printf("*");
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