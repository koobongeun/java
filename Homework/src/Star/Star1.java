package Star;

public class Star1 {

	public static void main(String[] args) {
	for(int i = 1; i<=5; i++) {
		for(int j = 1; j<=5; j++) {
		if(i==1) {	
			if(j==1 || j==2 || j==4 || j==5) {
				System.out.print(" ");
			}
			else {
				System.out.print("*");
				}
			}
		if(i==2) {	
			if(j==1 || j==5) {
				System.out.print(" ");
			}
			else {
				System.out.print("*");
				}
			}
		if(i==3) {
				System.out.print("*");
				}
		if(i==4) {	
			if(j==1 || j==5) {
				System.out.print(" ");
			}
			else {
				System.out.print("*");
				}
			}
		if(i==5) {	
			if(j==1 || j==2 || j==4 || j==5) {
				System.out.print(" ");
			}
			else {
				System.out.print("*");
				}
			}
			
		}
		System.out.println();
	}

	}

}