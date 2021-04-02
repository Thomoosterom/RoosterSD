import Klasse.Klas;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;


public class LeerlingRoosterController {
    public Button close;
    public Label naamGebruiker;
    public CheckBox ziekmelden;
    public DatePicker datePicker;

    Klas k = Klas.getKlas();

    public void initialize() {
        String j = k.getStudent().getNaam();
        String[] split2 = j.split(" ");
        naamGebruiker.setText("Welkom " + split2[0]);
        datePicker.setValue(LocalDate.of(2021, 4, 5));
    }
    public void cancel() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void afwezigheid(MouseEvent mouseEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ZiekmeldenLeerling.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void afwezigheidButton(javafx.event.ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ZiekmeldenLeerling.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void ziekMelden() {
        if (ziekmelden.isSelected()) {
            k.getStudent().setStatus("ziek");
            String i = k.getStudent().getStatus();
            System.out.println(i);
        }

    }

    public void ButtonWeekTerug(ActionEvent actionEvent) {
        LocalDate dagEerder = datePicker.getValue().minusDays(7);
        datePicker.setValue(dagEerder);
    }

    public void ButtonWeekVerder(ActionEvent actionEvent) {
        LocalDate dagLater = datePicker.getValue().plusDays(7);
        datePicker.setValue(dagLater);
    }
}
