import java.util.ArrayList;
import java.util.Scanner;

public class P01E06_Arraylist_p2 {

	public static void main(String[] args) {
		// ArrayList palabras
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> palabras = new ArrayList<String>();
		String texto, pal;
		int sp;
		int maxL=0;
		
		System.out.println("Entra un texto:");
		texto = sc.nextLine();
		while(texto.length()>0) {
			sp = primerSepPalabra(texto);
			if(sp<0) {
				pal = texto;
				texto = "";
			}
			else {
				pal = texto.substring(0, sp);
				texto = texto.substring(sp+1);
			}
			if(pal.length() > 0) {
				palabras.add(pal);
			}
		}
		
		System.out.println("Palabras del texto:");
		for(String pa:palabras) {
			System.out.println(pa);
			if(pa.length()>maxL) maxL = pa.length();
		}
		System.out.println("Número de palabras: "+palabras.size());
		System.out.print("Palabra(s) más larga(s): ");
		for(String pa:palabras) {
			if(pa.length() == maxL) System.out.println(pa);
		}
	}
	
	static int primerSepPalabra(String str) {
		// primera posición de un caracter separador de palabras
		
		int p = -1;
		int i; 
		
		i = str.indexOf(" ");
		if(i>=0) p = i;
		i = str.indexOf(",");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf(";");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf(".");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("\"");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("\'");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("¿");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("?");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("¡");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("!");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("(");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf(")");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("[");
		if(i>=0 && (i<p || p<0)) p = i;
		i = str.indexOf("]");
		if(i>=0 && (i<p || p<0)) p = i;
		
		return p;
	}

}
