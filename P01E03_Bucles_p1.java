import java.util.Scanner;

public class P01E03_Bucles_p1 {

	public static void main(String[] args) {
		
		// Programa 1: Bucle do while
		
		Scanner sc = new Scanner(System.in);
		short n;
		
		System.out.println("PROGRAMA 1\n");
		System.out.println("Entrar número entero entre 1 y 10:");
		do {
			n = Short.parseShort(sc.nextLine());
			if (n < 1 || n > 10) {
				System.out.println("Valor no válido.");
				System.out.println("Entrar número entero entre 1 y 10:");
			}
		} while (n < 1 || n > 10);
				
	}
}
