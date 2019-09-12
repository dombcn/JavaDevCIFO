import java.util.Scanner;

public class P01E03_Bucles_p3 {

	public static void main(String[] args) {
		
		// Programa 3: Bucle suma
		
		Scanner sc = new Scanner(System.in);
		short n;
		int sum=0;
		
		System.out.println("\nPROGRAMA 3\n");
		System.out.println("Entra un número entero mayor de 1 y menor de 1000:");
		do {
			n = Short.parseShort(sc.nextLine());
			if (n <= 1 || n >= 1000) {
				System.out.println("Valor no válido.");
				System.out.println("Entrar número entero mayor de 1 y menor de 1000:");
			}
		} while (n <= 1 || n >= 1000);
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		System.out.println("La suma de 1.." + n + " es: " + sum);
		
	}
}
