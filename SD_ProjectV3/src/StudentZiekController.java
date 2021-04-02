import Klasse.Klas;
import Klasse.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class StudentZiekController {
    @FXML private TextField redenField;
    @FXML private CheckBox afwezigBox;
    @FXML private Button close;
    @FXML private Button ok;
    @FXML private Label meldingLabel;
    @FXML private DatePicker datumvanPicker;
    @FXML private DatePicker datumtotPicker;

    public void initialize() {
        datumvanPicker.setValue(LocalDate.of(2021, 4, 5));
        datumtotPicker.setValue(LocalDate.of(2021, 4, 5));
    }

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void ok() {
        if (datumvanPicker.getValue()==null || datumtotPicker.getValue()==null) {
            meldingLabel.setText("De datum is niet ingevoerd!");
        }
        else if (datumvanPicker.getValue().isAfter(datumtotPicker.getValue()) || datumvanPicker.getValue().isBefore(LocalDate.now()) || datumtotPicker.getValue().isBefore(LocalDate.now()) ){
            meldingLabel.setText("De datum is fout ingevoerd!");
        }
        else {
            if (!afwezigBox.isSelected()) {
                meldingLabel.setText("Vink het afwezig box aan of cancel!");
            } else if (afwezigBox.isSelected() && !redenField.getText().isEmpty()) {
                String tekst = String.valueOf(redenField.getText());
                Student.getDeStudent().setStatus("afwezig");
                Stage stage = (Stage) ok.getScene().getWindow();
                stage.close();
            } else if (afwezigBox.isSelected() && redenField.getText().isEmpty()){
                meldingLabel.setText("Vul een reden in!");
            }
            else {
                meldingLabel.setText("Er is iets fout gegaan, probeer het opnieuw.");
            }
        }
        initialize();
    }
}

