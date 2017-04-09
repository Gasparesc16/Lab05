/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Anagramma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Anagramma model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiCorretti"
    private TextArea txtAnagrammiCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiSbagliati"
    private TextArea txtAnagrammiSbagliati; // Value injected by FXMLLoader
    
    public void setModel(Anagramma model) {
    	
		this.model = model;
		
	}

    @FXML
    void doAnagramma(ActionEvent event) {
    	
    	// Recupero i dati dalla vista
    	
    	String imput = txtParola.getText().toLowerCase();
    	
    // verifica le validità dei dati
    	
    	if(imput == null){
    		
    		txtAnagrammiCorretti.setText("Errore nell'inserimento della parola!");
    		txtAnagrammiSbagliati.setText("Errore nell'inserimento della parola!");
    		
    		return;
    	}
    	
    // Se qualcosa va male, ce lo diciamo all'utente e ci rifiutiamo di andare avanti
    	
    	if(!imput.matches("[a-zA-Z]*")){
    		
    		txtAnagrammiCorretti.setText("Errore nell'inserimento della parola!");
    		txtAnagrammiSbagliati.setText("Errore nell'inserimento della parola!");
    		
    		return;
    	}
    		
    // chiedi al Model di effettuare l'operazione
    	
    	Set<String> anagrammi =  new HashSet<String>();
    	anagrammi.addAll(model.getAnagrammi(imput));
    	
    // aggiorna la vista con il risultato dell'operazione in base all'esito delle operazioni
    	
    	for(String s: anagrammi){
    		
    		if(model.isCorrect(s))
    			txtAnagrammiCorretti.appendText(s + "\n");
    		else
    			txtAnagrammiSbagliati.appendText(s + "\n");
    	}
    	
    	
    	/*for(String s: anagrammi)
    		txtAnagrammiCorretti.appendText(s + "\n");
    		*/

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtParola.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiSbagliati.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiSbagliati != null : "fx:id=\"txtAnagrammiSbagliati\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
