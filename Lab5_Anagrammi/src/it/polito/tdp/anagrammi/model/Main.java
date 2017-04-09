package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class Main {

	public static void main(String[] args) {
	Anagramma a = new Anagramma();
		
		Set<String> soluzione = a.getAnagrammi("eat");
		
		for(String s: soluzione)
			System.out.println(s);

	}

}
