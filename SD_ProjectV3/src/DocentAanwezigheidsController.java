import Klasse.Klas;
import Klasse.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DocentAanwezigheidsController {
    @FXML private ListView ListView;
    @FXML private Button close;

    Klas k = Klas.getKlas();

    public void initialize() {
        for(Student s: k.getStudenten()) {
            System.out.println(s.getStatus());
        }
        toonLeerlingen();

    }

    public void Close(ActionEvent actionEvent) {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
    public void toonLeerlingen() {
        ObservableList<String> Leerlingen = FXCollections.observableArrayList();
        Klas k = Klas.getKlas();
        for(Student s: k.getStudenten()) {
            System.out.println(s.getStatus());
            Leerlingen.add(String.valueOf(s.getNaam()));
            Leerlingen.add(String.valueOf(s.getStatus()));
        }
        ListView.setItems(Leerlingen);

    }
}
