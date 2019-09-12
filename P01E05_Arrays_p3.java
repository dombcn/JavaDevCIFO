import java.util.Scanner;

public class P01E05_Arrays_p3 {
	
	static boolean yaExiste(String str, String[] strArr, int ns) {
		boolean existe = false;
		int i= 0;
		
		do {
			if(str.equalsIgnoreCase(strArr[i]))
				existe=true;
			i++;
		} while(!existe && i<ns);
		
		return existe;
	}

	public static void main(String[] args) {
		// Array 5 nombres

		Scanner sc = new Scanner(System.in);
		String[] productos = new String[5];
		String nombre;
		
		System.out.println("Entra cinco nombres de productos.");
		for(int i=0; i<5; i++) {
			System.out.println("Producto "+(i+1)+":");
			nombre = sc.nextLine();
			while(yaExiste(nombre,productos,i+1)) {
				System.out.println("Error: Producto repetido.");
				System.out.println("Producto "+(i+1)+":");
				nombre = sc.nextLine();
			}
			productos[i] = nombre;
		}
		
		System.out.println("Los productos introducidos son:");
		for(String prod:productos) {
			System.out.println(prod);
		}
	}

}
