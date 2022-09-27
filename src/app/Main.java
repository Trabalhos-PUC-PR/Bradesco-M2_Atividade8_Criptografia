package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cyphers.Caesar;
import cyphers.Swapper;
import interfaces.Cypherable;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Cypherable> cyphers = new ArrayList<>();
		cyphers.add(new Caesar(5));
		cyphers.add(new Swapper());

		System.out.println("Cyphers!");
		System.out.println("Please type a string that will be cyphered: ");
		System.out.print("String: ");
		String source = sc.nextLine();

		System.out.println("\nSelect your cypher method: ");
		int count = 1;
		for (Cypherable e : cyphers) {
			System.out.printf("%d. %s\n", count, e.getCypherName());
			count++;
		}
		System.out.print("Your option: ");
		int selection = Integer.parseInt(sc.nextLine())-1;
		sc.close();
		
		if(selection < 0 || selection >= cyphers.size()) {
			throw new RuntimeException("Invalid cypher selection!");
		}
		
		Cypherable cypher = cyphers.get(selection);

		String encrypted = cypher.encrypt(source);
		String decrypted = cypher.decrypt(encrypted);

		System.out.printf("\n\t - [%s] cypher: -\n", cypher.getCypherName());
		System.out.printf("Original:....[%s]\n", source);
		System.out.printf("Encrypted:...[%s]\n", encrypted);
		System.out.printf("Decrypted:...[%s]\n", decrypted);

	}

}
