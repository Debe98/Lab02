package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Vocabolario voc;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserimento;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtInserimento.clear();
    	txtRisultato.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String Testo = txtInserimento.getText();
    	try {
    		txtRisultato.setText(voc.traduci(Testo));
    	}
    	catch (ParoleException pe) {
			txtRisultato.setText(pe.toString());
		}
    }

    @FXML
    void initialize() {
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Vocabolario model) {
    	this.voc = model;
    }
}