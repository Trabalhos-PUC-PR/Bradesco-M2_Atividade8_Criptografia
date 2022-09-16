package entities;

import interfaces.Encryptable;

public class Caesar implements Encryptable {

	private int shift;

	public Caesar(int shift) {
		this.shift = shift;
	}

	@Override
	public String getMethodName() {
		return "Caesar";
	}

	@Override
	public String encrypt(String source) {
		return shifter(source, this.shift);
	}

	private String shifter(String source, int shift) {
		StringBuilder sb = new StringBuilder();
		source.toLowerCase();
		for (char caracter : source.toCharArray()) {
			if (caracter != ' ') {
				char base = 'a';
				int overFlow = 26;
				if(Character.isDigit(caracter)) {
					base = '0';
					overFlow = 10;
				}
				int newPosition = (caracter - base) + shift;
				if (newPosition < 0) {
					newPosition += overFlow;
				}
				char shifted = (char) ((newPosition % overFlow) + base);
				sb.append(shifted);
			} else {
				sb.append(' ');
			}
		}
		return sb.toString();
	}

	@Override
	public String decrypt(String source) {
		return shifter(source, -this.shift);
	}

}
