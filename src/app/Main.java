package app;

import java.util.ArrayList;
import java.util.List;

import entities.Caesar;
import interfaces.Encryptable;

public class Main {

	public static void main(String[] args) {
		List<Encryptable> methods = new ArrayList<>();
		methods.add(new Caesar(1));

		Encryptable method = methods.get(0);
		String source = "abc xyz 012 789";
		String encrypted = method.encrypt(source);
		String decrypted = method.decrypt(encrypted);
		
		System.out.printf("\t - [%s] method: -\n", method.getMethodName());
		System.out.printf("Original:....[%s]\n", source);
		System.out.printf("Encrypted:...[%s]\n", encrypted);
		System.out.printf("Decrypted:...[%s]\n", decrypted);
		
	}
	
}
