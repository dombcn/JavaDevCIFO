import java.util.Scanner;

public class P01E04_Metodos_p1 {
	
	static String masLarga(String str1, String str2) {
		if(str1.length() > str2.length())
			return str1;
		else if(str1.length() < str2.length())
			return str2;
		else
			return "";
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String cad1, cad2, cadML;
		
		System.out.println("Entra un texto:");
		cad1 = sc.nextLine();
		System.out.println("Entra otro texto:");
		cad2 = sc.nextLine();
		
		cadML = masLarga(cad1,cad2);
		if(cadML.length() == 0) {
			System.out.println("Ambas textos son igual de largos.");
		}
		else {
			System.out.println("El texto más largo es: "+cadML);
		}
	}

}
