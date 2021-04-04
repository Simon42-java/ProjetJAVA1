package javafxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class remboursementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane maintab;

    @FXML
    private TableView<?> tabsupp;

    @FXML
    private Label visiteurbdd;

    @FXML
    private Label date;

    @FXML
    private Label prenomnom;

    @FXML
    void initialize() {
        assert maintab != null : "fx:id=\"maintab\" was not injected: check your FXML file 'remboursementtab.fxml'.";
        assert tabsupp != null : "fx:id=\"tabsupp\" was not injected: check your FXML file 'remboursementtab.fxml'.";
        assert visiteurbdd != null : "fx:id=\"visiteurbdd\" was not injected: check your FXML file 'remboursementtab.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'remboursementtab.fxml'.";
        assert prenomnom != null : "fx:id=\"prenomnom\" was not injected: check your FXML file 'remboursementtab.fxml'.";

    }
}
