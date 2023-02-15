package encryption;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Encryption {
	private static String alfabeto = new String("abcdefghijklmnopqrstuvwxyz");
	
	public static String encrypt(String str) {
		String[] arTI = str.split(" ");
		List<String> inverseAr = new ArrayList<>();
		
		for (String parola: arTI) {
			String[] arP = parola.split("");
			Collections.reverse(Arrays.asList(arP));
			
			StringBuilder stringa = new StringBuilder(arP.length);
			for (String lettera: arP) {
				int indice = alfabeto.indexOf(lettera);
				char c = alfabeto.charAt(indice + 3);
				stringa.append(c);
			}
			
			String parolaInversa = stringa.toString();
			inverseAr.add(parolaInversa);
		}
		Collections.reverse(inverseAr);
		
		return String.join(" ", inverseAr);
	}
	
	
	public static String decrypt(String encStr) {
		String[] arTD = encStr.split(" ");
		List<String> arrayInverso = new ArrayList<>();
		
		for (String parola: arTD) {
			String[] arD = parola.split("");
			Collections.reverse(Arrays.asList(arD));
			
			StringBuilder stringa = new StringBuilder(arD.length);
			for (String lettera: arD) {
				int indice = alfabeto.indexOf(lettera);
				char c = alfabeto.charAt(indice - 3);
				stringa.append(c);
			}
			
			String parolaInversa = stringa.toString();
			arrayInverso.add(parolaInversa);
		}
		
		Collections.reverse(arrayInverso);
		
		return String.join(" ", arrayInverso);
	}
	
	
	public static void main(String[] args) {
		String testo = "le rose sono rosse";
		String testoCifrato = Encryption.encrypt(testo);
		String testoDecifrato = Encryption.decrypt(testoCifrato);
		
	    if (testo.equals(testoDecifrato)) {
	      System.out.println("Good Job!");
	    } else {
	      System.out.println("Correggi il programma");
	    }
		    
	}

}
