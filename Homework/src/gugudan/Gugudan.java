package gugudan;

public class Gugudan {

	public static void main(String[] args) {
		int i,j;
		int a =9;
		for(i = 1; i<=a; i++) {
		for(j = 1; j<=a; j++) {
			if(i==1 && j==1)
			{
				System.out.printf(" \t");
			}
			else
			System.out.print(i*j+"\t");
		
		}
		System.out.println();
	}
	}

}
