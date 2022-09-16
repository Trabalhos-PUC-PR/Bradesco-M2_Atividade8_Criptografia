package cyphers;

import interfaces.Cypherable;

public class Caesar implements Cypherable {

	private int shift;

	public Caesar(int shift) {
		this.shift = shift;
	}

	@Override
	public String getCypherName() {
		return "Caesar";
	}

	@Override
	public String encrypt(String source) {
		return shifter(source, this.shift);
	}

	@Override
	public String decrypt(String source) {
		return shifter(source, -this.shift);
	}
	
	private String shifter(String source, int shift) {
		StringBuilder sb = new StringBuilder();
		for (char caracter : source.toCharArray()) {
			if (caracter != ' ') {
				char base = 'a';
				int overFlow = 26;
				boolean isUpperCase = Character.isUpperCase(caracter);
				if (Character.isDigit(caracter)) {
					base = '0';
					overFlow = 10;
				} else if (isUpperCase)
					base = 'A';
				int newPosition = (caracter - base) + shift;
				if (newPosition < 0) {
					newPosition += overFlow;
				}
				char shifted = (char) ((newPosition % overFlow) + base);
				sb.append(isUpperCase ? Character.toUpperCase(shifted) : shifted);
			} else {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

}
