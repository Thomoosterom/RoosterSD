import Klasse.Klas;
import Klasse.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import jdk.dynalink.beans.StaticClass;

public class DocentAanwezigheidsController {
    @FXML private ListView ListView;
    @FXML private Button close;

    Klas k = Klas.getKlas();

    public void initialize() {
        toonLeerlingen();
    }

    public void Close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
    public void toonLeerlingen() {
        ObservableList<String> Leerlingen = FXCollections.observableArrayList();

        for(Student s : k.getStudenten()) {
            Leerlingen.add(String.valueOf(s.getNaam()));
            Leerlingen.add(String.valueOf(s.getStatus()));
            Leerlingen.add("");
        }

        if (Student.getDeStudent() != null) {
            Leerlingen.remove(Student.getDeStudent().getNaam());
            Leerlingen.remove(Student.getDeStudent().getStatus());
            Leerlingen.remove("aanwezig");
            Leerlingen.remove("");

            Leerlingen.add(String.valueOf(Student.getDeStudent().getNaam()));
            Leerlingen.add(String.valueOf(Student.getDeStudent().getStatus()));
            Leerlingen.add(String.valueOf(Student.getDeStudent().getReden()));
            Leerlingen.add("");
        }

        ListView.setItems(Leerlingen);

    }
}
