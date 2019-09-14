import java.util.Scanner;

public class P01A02_Codifcicacion_de_numeros {
	
	static final String LETRAS_CODIGO = "ABCDEFGHIJKLMNOPRSTUVWXY";

	public static void main(String[] args) {
		// PLA 1 - Actividad 2
		// Codificación de números

		Scanner sc = new Scanner(System.in);
		String opc = "";
		boolean opcOK = false;
		String str = "";
		int num = 0;
		boolean chOK = false;
		String[] decodedArr;
		
		do {
			System.out.println("Elige opción (C - Codificar, D - Descodificar, S - Salir):");
			opc = sc.nextLine();
			if(opc.equalsIgnoreCase("C")) {
				// CODIFICAR
				opcOK = true;
				System.out.println("Entra palabra a codificar: ");
				do {
					str = sc.nextLine();
					str = str.toUpperCase();
					chOK = checkStrToCode(str);
					if(!chOK) {
						System.out.println("Error: letras no válidas.");
						System.out.print("Entra palabra a codificar ");
						System.out.println("(sólo se admiten las letras "+LETRAS_CODIGO+") :");
					}
				} while (!chOK);
				num = codifica(str);
				// mostrar codificación
				System.out.println("La palabra ha sido codificada con el número: "+num);
			}
			else if(opc.equalsIgnoreCase("D")) {
				// DESCODIFICAR
				opcOK = true;
				System.out.println("Entra número a descodificar: ");
				do {
					num = Integer.parseInt(sc.nextLine());
					chOK = checkNumToDecode(num);
					if(!chOK) {
						System.out.println("Error: no se puede descodificar el número "+num+".");
						System.out.print("Entra número a descodificar ");
						System.out.println("(entero positivo sin 0s ni 1s) :");
					}
				} while (!chOK);
				decodedArr = descodifica(num);
				// mostrar descodificación
				System.out.println("Las posibles palabras codificadas con este número son:");
				for(int i=0; i<decodedArr.length; i++) {
					System.out.println(decodedArr[i]);
				}
			}
			else if(opc.equalsIgnoreCase("S")) {
				// SALIR
				opcOK = true;
			}
		} while (!opcOK);
	}
	
	// Método para chequear la palabra a codificar
	static boolean checkStrToCode(String strToCode) {
		boolean res=true;
		char c;
		
		for(int i=0; i<strToCode.length(); i++) {
			c = strToCode.charAt(i);
			if(LETRAS_CODIGO.indexOf(c) < 0) {
				res = false;
				break;
			}
		}
		return res;
	}

	// Método para chequear el número a descodificar
	static boolean checkNumToDecode(int numToDecode) {
		boolean res=true;
		String s="";
		
		if (numToDecode <= 0) {
			res = false;
		}
		else {
			s = Integer.toString(numToDecode);
			if(s.indexOf('0') >= 0) res = false;
			else if(s.indexOf('1') >= 0) res = false;
		}
		return res;
	}
	
	// Método para codificar
	static int codifica(String strToCode) {
		String tmpStr="";
		char c;
		int pos, dig;
		int res;
		
		for(int i=0; i<strToCode.length(); i++) {
			c = strToCode.charAt(i);
			pos = LETRAS_CODIGO.indexOf(c);
			dig = (pos/3) + 2;
			tmpStr = tmpStr.concat(Integer.toString(dig));
		}
		res = Integer.parseInt(tmpStr);
		
		return res;
	}
	
	// Método para descodificar
	static String[] descodifica(int numToDecode) {
		String sTmp = Integer.toString(numToDecode);
		int lsTmp = sTmp.length();
		int nResArr = (int) Math.pow(3,lsTmp);
		String[] resArr = new String[nResArr];
		String[] tmp3cArr = new String[lsTmp];
		int nTmp = numToDecode;
		int pos, dig;
		String tmpStr;
		int nd = 0;
		int nFrag;
		int sFrag;
		
		// descodificar cada digito
		while(nTmp>0) {
			dig = nTmp%10;
			nTmp = nTmp/10;
			pos = dig - 2;
			tmpStr = LETRAS_CODIGO.substring(pos*3,pos*3+3);
			nd++;
			tmp3cArr[lsTmp-nd] = tmpStr;
		}
		
		// iniciar array combinaciones
		for(int i=0; i<nResArr; i++) {
			resArr[i] = "";
		}
		
		// guardar todas las combinaciones en el array
		for(int i=0; i<nd; i++) {
			// System.out.println(tmp3cArr[i]);
			// 1r digito >>>  1 fragmento (todo el array)
			// 2o digito >>>  3 fragmentos
			// 3r digito >>>  9 fragmentos
			// 4o digito >>> 27 fragmentos
			nFrag = (int) Math.pow(3, i);
			sFrag = nResArr/nFrag; // tamaño del fragmento
			for(int j=0; j<nFrag; j++) {
				setFragArr(resArr, j*sFrag, (j+1)*sFrag, tmp3cArr[i]);
			}
		}
		
		return resArr;
	}
	
	// Método para establecer las 3 opciones (3 letras) para un dígito
	// en un fragmento del array de combinaciones
	static void setFragArr(String[] sa, int ini, int fin, String sd) {
		int sf = fin-ini;
		
		for(int j=ini; j<fin; j++) {
			if(j < (sf/3)+ini) {
				// primera letra
				sa[j] = sa[j].concat(sd.substring(0,1));
			}
			else {
				if(j < (sf/3)*2+ini) {
					// segunda letra
					sa[j] = sa[j].concat(sd.substring(1,2));
				}
				else {
					// j < (sf/3)*3+ini
					// tercera letra
					sa[j] = sa[j].concat(sd.substring(2));
				}
			}
		}
	}
	
}
