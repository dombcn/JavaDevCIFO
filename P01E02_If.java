import java.util.Scanner;

public class P01E02_If {

	public static void main(String[] args) {
		// Control entrada parque de actracciones
		
		short edad, altura;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CONTROL ENTRADA\n");
		
		System.out.println("Edad:");
		do {
			edad = sc.nextShort();
			if (edad < 0 || edad > 150) {
				System.out.println("Valor no válido.");
				System.out.println("Edad:");
			}
		} while (edad < 0 || edad > 150);
		
		System.out.println("Altura (cm):");
		do {
			altura = sc.nextShort();
			if (altura <= 0) {
				System.out.println("Valor no válido.");
				System.out.println("Altura (cm):");
			}
		} while (altura <= 0);
		
		if(edad > 16 || altura > 140)
			System.out.println("\nEntrada PERMITIDA.");
		else
			System.out.println("\nEntrada DENEGADA.");
		
	}

}
