import java.util.Scanner;

public class P01E04_Metodos_p2 {

	static int veces(char letra, String str) {
		
		short n=0;
		int i = str.indexOf(letra);
		
		while(i>=0) {
			n++;
			str = str.substring(i+1);
			i = str.indexOf(letra);
		}
		
		return n;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char let;
		String cad;
		
		System.out.println("Entra una letra:");
		cad = sc.nextLine();
		while(cad.length() != 1) {
			if(cad.length() == 0)
				System.out.println("Error: texto vacío.\nEntra una letra:");
			else
				System.out.println("Error: varios caracteres.\nEntra SÓLO una letra:");
			cad = sc.nextLine();
		}
		let = cad.charAt(0);
		System.out.println("Entra un texto:");
		cad = sc.nextLine();
		
		System.out.println("El texto contiene "+veces(let,cad)+" veces la letra "+let+".");
		
	}

}
