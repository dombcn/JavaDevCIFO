import java.util.ArrayList;
import java.util.Scanner;

public class P01E06_Arraylist_p1 {

	public static void main(String[] args) {
		// ArrayList números
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		String pares="";
		int num;
		int suma=0;
		
		// Leer números y guardar
		System.out.println("Escribe varios números enteros del 1 al 10");
		System.out.println("(uno en cada línea, puedes repetir, acaba entrando un 0):");
		do {
			do {
				num = Integer.parseInt(sc.nextLine());
				if (num < 0 || num > 10) {
					System.out.println("Valor no válido.");
					System.out.println("Entrar número entero entre 1 y 10 (o 0 para finalizar):");
				}
			} while (num < 0 || num > 10);
			if(num > 0) numeros.add(num);
		} while(num > 0);
		
		// Mostrar resultados
		System.out.println("Se han escrito "+numeros.size()+" números.");
		if(numeros.size() > 0) {
			for(int n:numeros) {
				// System.out.println(n);
				suma += n;
				if(n%2 == 0)
					pares = pares.concat(Integer.toString(n)+" ");
			}
			System.out.println("que suman "+suma);
			System.out.println("incluyendo los siguientes números pares: "+pares);
		}
	}

}
