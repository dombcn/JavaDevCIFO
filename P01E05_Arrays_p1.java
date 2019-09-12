import java.util.Scanner;

public class P01E05_Arrays_p1 {

	public static void main(String[] args) {
		// Array 10 números
		
		Scanner sc = new Scanner(System.in);
		int[] numArray = new int[10];
		int suma=0;
		int num;
		
		System.out.println("Escribe 10 números enteros entre 1 y 10 (uno en cada línea):");
		for(int i=0; i<10; i++) {
			do {
				num = Integer.parseInt(sc.nextLine());
				if (num < 1 || num > 10) {
					System.out.println("Valor no válido.");
					System.out.println("Entrar número entero entre 1 y 10:");
				}
			} while (num < 1 || num > 10);
			numArray[i] = num;
		}
		
		System.out.println("\nLos números introducidos son:");
		for(int n:numArray) {
			System.out.print(n+" ");
			suma = suma +  n;
		}
		System.out.println();
		System.out.println("y su suma es: "+suma);
	}

}
