package br.com.fesa.rotadagasosa.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
	
	private final static String EMAIL_REGEX_PATTERN = "^(.+)@(\\S+)$";
	
	public static List<String> stringToStringList(String stringList){
		List<String> list = new ArrayList<String>();
		
		if(stringList == null || stringList.trim().isEmpty()) { return list; }
		
		String listWithOnlyComma = stringList.replaceAll("[", "").replaceAll("]", "");
		
		return Arrays.asList(listWithOnlyComma.split("\\s*,\\s*"));
		
	}
	
	public static boolean isEmail(String email) {
		if(email == null || email.trim().isEmpty()) { return false; }
				
		return email.matches(EMAIL_REGEX_PATTERN);
	}
	
	public static String sanitizerInput(String value) {
		if(value == null) { return null; }
		
		return value.trim();
	}
	
	public static boolean isCPF(String cpf) {
		
		cpf = removeCaracteresEspeciais(cpf);
		
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || 
				cpf.equals("22222222222") || cpf.equals("33333333333") || 
					cpf.equals("44444444444") || cpf.equals("55555555555") || 
						cpf.equals("66666666666") || cpf.equals("77777777777") || 
							cpf.equals("88888888888") || cpf.equals("99999999999") || 
								(cpf.length() != 11)) {
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {     
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);


			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return true;
			else
				return false;
		} catch (Exception erro) {
			return false;
		}
	}

	public static boolean isCNPJ(String cnpj) {
		
		cnpj = removeCaracteresEspeciais(cnpj);
		
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || 
				cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || 
					cnpj.equals("44444444444444") || cnpj.equals("55555555555555") || 
						cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || 
							cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || 
								(cnpj.length() != 14)) {
			return false;
		}

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
		
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (cnpj.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13)))
				return true;
			else
				return false;
		} catch (Exception erro) {
			return false;
		}
	}
	
	private static String removeCaracteresEspeciais(String doc) {
		if (doc.contains(".")) {
			doc = doc.replace(".", "");
		}
		if (doc.contains("-")) {
			doc = doc.replace("-", "");
		}
		if (doc.contains("/")) {
			doc = doc.replace("/", "");
		}
		return doc;
	}
	
}