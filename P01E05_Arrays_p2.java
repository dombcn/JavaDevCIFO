import java.util.Arrays;
import java.util.Scanner;

public class P01E05_Arrays_p2 {

	public static void main(String[] args) {
		// Array 10 números ordenado
		
		Scanner sc = new Scanner(System.in);
		int[] numArray = new int[10];
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
		}
		System.out.println();
		
		// ordenar array
		Arrays.sort(numArray);
		for(int i=0; i<5; i++) {
			num = numArray[i];
			numArray[i] = numArray[9-i];
			numArray[9-i] = num;
		}
		System.out.println("\nLos números ordenados son:");
		for(int n:numArray) {
			System.out.print(n+" ");
		}
		System.out.println();
	}

}
