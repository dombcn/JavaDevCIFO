import java.util.Scanner;

public class P01E01_Variables {

	public static void main(String[] args) {
		// Leer 2 números, guardar, calcular suma y producto
		
		int n1;
		double n2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe un número entero positivo:");
		do {
			n1 = sc.nextInt();
			if (n1 < 0) {
				System.out.println("Número no válido.");
				System.out.println("Escribe un número entero positivo:");
			}
		} while (n1 < 0);
		
		System.out.println("Escribe un número decimal positivo:");
		do {
			n2 = sc.nextDouble();
			if (n2 < 0) {
				System.out.println("Número no válido.");
				System.out.println("Escribe un número decimal positivo:");
			}
		} while (n2 < 0);
		
		System.out.println("La suma de "+n1+" y "+n2+" es: "+(n1+n2));
		System.out.println("El producto de "+n1+" y "+n2+" es: "+(n1*n2));
	}

}
