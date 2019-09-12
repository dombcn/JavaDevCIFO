import java.util.Scanner;

public class P01E03_Bucles_p2 {

	public static void main(String[] args) {
		
		// Programa 2: Bucle while, string indexof
		
		Scanner sc = new Scanner(System.in);
		short n=0;
		String str;
		
		System.out.println("\nPROGRAMA 2\n");
		System.out.println("Entra un texto:");
		str = sc.nextLine();
		int i = str.indexOf('a');
		while(i>=0) {
			n++;
			str = str.substring(i+1);
			i = str.indexOf('a');
		}
		System.out.println("El texto contiene "+n+" as.");
			
	}
}
