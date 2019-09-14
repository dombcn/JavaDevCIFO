import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P01A01_Analisis_de_un_texto {

	public static void main(String[] args) {
		// PLA 1 - Actividad 1
		// Análisis de un texto
		
		Scanner sc = new Scanner(System.in);
		String texto = "";
		String inStr;
		String[] frases;
		
		// todas las palabras del texto (con repeticiones)
		ArrayList<String> palabras = new ArrayList<String>(); 
		
		// entrar texto
		System.out.print("Entra un texto largo con una o varias frases");
		System.out.println(" (finaliza con una línea vacía):");
		do {
			inStr = sc.nextLine();
			texto = texto.concat(inStr);
		} while (inStr.length() > 0);
		
		// separar frases y mostrarlas en orden ascendente de longitud
		frases = texto.split("\\.\\s*");
		Arrays.parallelSort(frases, (a,b)->a.length()-b.length());
		System.out.println("Frases del texto:");
		for(String f:frases) {
			if(f.length()>0) { 
				System.out.println(f+".");
				extraerPalabras(f,palabras);
			}
		}
		
		// mostrar las palabras
		mostrarPalabras(palabras);		
	}
	
	
	static void extraerPalabras (String fra, ArrayList<String> palArrList) {
		// extraer palabras de una frase añadirlas 
		String[] palFrase; // palabras de una frase
		
		palFrase = fra.split("\\s+");
		for(String p:palFrase) {
			palArrList.add(p.toLowerCase());
		}
	}
	
	static void mostrarPalabras (ArrayList<String> palArrList) {
		// Ordena las palabras (1) por frecuencia y (2) alfabéticamente
		String[] palUnicas = new String[palArrList.size()];
		int[] palNumVeces = new int[palArrList.size()];
		String pTmp = ""; // palabra temporal
		int nVeces = 0; // frecuencia de cada palabra
		int np=0; // número de palabras únicas
		
		Collections.sort(palArrList);
		for(String p:palArrList) {
			if(p.equals(pTmp)) nVeces++;
			else {
				// guardar palabra y numero de veces que aparece
				if(pTmp.length() > 0) {
					palUnicas[np] = pTmp;
					palNumVeces[np] = nVeces;
					np++;
				}
				// reset para siguiente palabra
				pTmp = p;
				nVeces = 1;
			}
		}
		// guardar ultima palabra de la lista
		palUnicas[np] = pTmp;
		palNumVeces[np] = nVeces;
		np++;
		
		// ordenar por frecuencia (mayor a menor) usando el algoritmo de la burbuja
		// (el orden alfabético ya está garantizado por el sort del arrayList)
		for(int i=0; i<np-1; i++ ) {
			for(int j=np-1; j>i; j--) {
				if(palNumVeces[j-1]<palNumVeces[j]) {
					nVeces = palNumVeces[j-1];
					palNumVeces[j-1] = palNumVeces[j];
					palNumVeces[j] = nVeces;
					pTmp = palUnicas[j-1];
					palUnicas[j-1] = palUnicas[j];
					palUnicas[j] = pTmp;
				}
			}
		}
		
		// mostrar las palabras y frecuencias
		System.out.println("\nPalabras del texto (palabra : frecuencia):");
		for(int i=0; i<np; i++) {
			System.out.println(palUnicas[i]+" : "+palNumVeces[i]);
		}
	}

}
