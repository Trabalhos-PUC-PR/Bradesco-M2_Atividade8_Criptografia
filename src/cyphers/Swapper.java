package cyphers;

import interfaces.Cypherable;

public class Swapper implements Cypherable {

	public Swapper() {

	}

	@Override
	public String getCypherName() {
		return "Swapper";
	}

	@Override
	public String encrypt(String source) {
		return swap(source);
	}

	private String swap(String source) {
		source.toLowerCase();
		char[] chars = source.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i < chars.length-1) {
				char aux = chars[i];
				chars[i] = chars[i + 1];
				chars[i + 1] = aux;
				i++;
			}
		}
		return new String(chars);
	}

	@Override
	public String decrypt(String source) {
		return swap(source);
	}

}
