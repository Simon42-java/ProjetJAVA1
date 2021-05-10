package javafxml;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class authentificationController {

    
        @FXML
        private TextField loginfield;
    
        @FXML
        private PasswordField pwdfield;
    
        @FXML
        private Button btauthentification;
    
        @FXML
        private CheckBox choixmed;
    
        @FXML
        void confirmform(ActionEvent event)   throws IOException {
            App.setRoot("changementvehicule");
        }
    
        @FXML
        void takechoixmed(ActionEvent event) {
    
        }
    
        @FXML
        void takeloginfield(ActionEvent event) {
    
        }
    
        @FXML
        void takepwdfield(ActionEvent event) {
    
        }
    
    }
    