package encryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class EncryptionExtra {
private static String alfabeto = new String("abcdefghijklmnopqrstuvwxyz");
	
	public static String encrypt(String str, int shift) {
		String[] arTI = str.split(" ");
		List<String> inverseAr = new ArrayList<>();
		
		for (String parola: arTI) {
			String[] arP = parola.split("");
			Collections.reverse(Arrays.asList(arP));
			
			StringBuilder stringa = new StringBuilder(arP.length);
			for (String lettera: arP) {
				int indice = alfabeto.indexOf(lettera);
				char c = alfabeto.charAt((indice + shift) % 26);
				stringa.append(c);
			}
			
			String parolaInversa = stringa.toString();
			inverseAr.add(parolaInversa);
		}
		Collections.reverse(inverseAr);
		
		return String.join(" ", inverseAr);
	}
	
	
	public static String decrypt(String encStr, int unshift) {
		String[] arTD = encStr.split(" ");
		List<String> arrayInverso = new ArrayList<>();
		
		for (String parola: arTD) {
			String[] arD = parola.split("");
			Collections.reverse(Arrays.asList(arD));
			
			StringBuilder stringa = new StringBuilder(arD.length);
			for (String lettera: arD) {
				int indice = alfabeto.indexOf(lettera);
				char c = alfabeto.charAt(((((indice - unshift) % 26) + 26) % 26));
				stringa.append(c);
			}
			
			String parolaInversa = stringa.toString();
			arrayInverso.add(parolaInversa);
		}
		Collections.reverse(arrayInverso);
	
		return String.join(" ", arrayInverso);
	}
	
	
	public static void main(String[] args) {
		String testo = "aa le rose sono rosse zz";
		String testoCifrato = EncryptionExtra.encrypt(testo, 126);
		String testoDecifrato = EncryptionExtra.decrypt(testoCifrato, 126);
		System.out.println(testoCifrato);
		System.out.println(testoDecifrato);
		
	    if (testo.equals(testoDecifrato)) {
	      System.out.println("Good Job!");
	    } else {
	      System.out.println("Correggi il programma");
	    }

	}
}
