package javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class creationdecompteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cobt;

    @FXML
    private TextField NOM;

    @FXML
    private TextField matricule;

    @FXML
    private Button btcréation;

    @FXML
    private PasswordField Mdp;

    @FXML
    void connexiontrans(ActionEvent event) throws IOException {
        App.setRoot("authentification1");

    }

    @FXML
    void lancementbt(ActionEvent event) {

    }

    @FXML
    void takematricule(ActionEvent event) {

    }

    @FXML
    void takemdp(ActionEvent event) {

    }

    @FXML
    void takenom(ActionEvent event) {

    }

}
