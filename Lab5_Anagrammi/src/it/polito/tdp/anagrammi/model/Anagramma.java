package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Anagramma {
	
	private Set<String> risultato;
	
	private AnagrammaDAO anagrammaDao = new AnagrammaDAO();

	
	/**
	 * 
	 * Funzione ricorsiva per il calcolo degli anagrammi che riceve 2 parametri:
	 * 1)  La stringa che corrisponde al pezzo di parola già costruito
	 * 2) Elenco delle lettere ancora da considerare
	 * 
	 * Prende una per una tali lettere, le aggiunge alla parola e lancia la ricorsione.
	 * 
	 * Quando non ci sono più lettere da inserire l'anagramma é completo e.......
	 * 
	 * 
	 * Essenzialmente questa funzione esplora la soluzione del mezzo e quella finale;
	 * la fase iniziale la impostiamo nel metodo publico getAnagrammi
	 * 
	 * @param parziale ---> prefisso di parola già definito
	 * @param lettere ---> lettere ancora da inserire
	 * @param livello
	 */

	private void combina(String parziale, List<String> lettere, int livello) {
		
		if(lettere.size() == 0){ // caso terminale: anagramma completo
		
			risultato.add(parziale);
			
			return;
		}
		
		// Prendo una ad una la lettera
		for(String l: lettere){
			
			List<String> subset = new LinkedList<String>(lettere);
			subset.remove(l);
			
			combina(parziale + l, subset, livello+1 );
		}
	
	}
	
	
	
	/**
	 * 
	 * Questa funzione deve preparare la prima chiamata ricorsiva, dopo di che la ricorsione va avanti da sola e raccogliere i risultati restituendoli al chiamante
	 * @param imput
	 * @return
	 */


	public Set<String> getAnagrammi(String imput) {
		
		String parziale = "";
		
		risultato = new HashSet<String>();
		
		List<String> lettere = new LinkedList<String>();
		
		for(int i= 0; i<imput.length();i++){
			
			lettere.add(imput.substring(i, i+1));
			
		}
		
		combina(parziale,lettere,0);
		
		
		
		return risultato;
		
		
	}



	public boolean isCorrect(String anagramma){
		
		if(anagrammaDao.isCorrect(anagramma))
			return true;
		else
			return false;
		
	}
	

}
