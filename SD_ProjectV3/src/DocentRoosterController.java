import Klasse.Klas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class DocentRoosterController {
    @FXML private DatePicker datePicker;
    @FXML private Button close;
    @FXML private Button zieAbsenten;
    @FXML private Label NaamGebruiker;


    Klas k = Klas.getKlas();

    public void initialize() {
        String j = k.getDocent().getNaam();
        String[] split2 = j.split(" ");
        NaamGebruiker.setText("Welkom " + split2[0]);
    }

    public void Back(ActionEvent actionEvent) {
        Stage stage = (Stage)close.getScene().getWindow();
        stage.close();
    }
    public void dagTerug(ActionEvent actionEvent) {
        LocalDate dagEerder = datePicker.getValue().minusDays(1);
        datePicker.setValue(dagEerder);
    }

    public void dagVerder(ActionEvent actionEvent) {
        LocalDate dagLater = datePicker.getValue().plusDays(1);
        datePicker.setValue(dagLater);
    }

    public void zieAbsenten(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DocentAanwezigheidOverzicht.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    }

