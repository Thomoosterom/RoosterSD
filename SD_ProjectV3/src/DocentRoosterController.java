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
    public DatePicker datePicker;
    @FXML private Button close;
    @FXML private Button zieAbsenten;
    @FXML private Label NaamGebruiker;

    Klas k = Klas.getKlas();

    public void initialize() {
        String j = k.getDocent().getNaam();
        String[] split2 = j.split(" ");
        NaamGebruiker.setText("Welkom " + split2[0]);

        datePicker.setValue(LocalDate.now());
    }

    public void Back(ActionEvent actionEvent) {
        Stage stage = (Stage)close.getScene().getWindow();
        stage.close();
    }

    public void weekTerug(ActionEvent actionEvent) {
        LocalDate weekEerder = datePicker.getValue().minusDays(7);
        datePicker.setValue(weekEerder);
    }

    public void weekVerder(ActionEvent actionEvent) {
        LocalDate weekLater = datePicker.getValue().plusDays(7);
        datePicker.setValue(weekLater);
    }

    public void zieAbsenten(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DocentAanwezigheidOverzicht.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
    }

