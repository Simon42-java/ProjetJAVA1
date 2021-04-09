package javafxml;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class authentificationController {

    static String url = "jdbc:mysql://127.0.0.1:3306/ap2_gsb ?useUnicode=true"
    + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    static String utilisateur = "root";
    static String motDePasse = "Simon59300sql";
    static Connection connexion = null;
    static ResultSet rs = null;

    
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
            try {
                connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
                String sql = "SELECT ag_nom_utilisateur, ag_password FROM agents where ag_nom_utilisateur LIKE'" + loginfield
                        + "'and ag_password like'" + pwdfield + "';";
                PreparedStatement statement = connexion.prepareStatement(sql);
                rs = statement.executeQuery(sql);
                System.out.println("A user was authentification successfully!" + sql);
                if(loginfield == rs){
                    if(pwdfield == rs){
                    App.setRoot("remboursement");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
    
            }
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
    