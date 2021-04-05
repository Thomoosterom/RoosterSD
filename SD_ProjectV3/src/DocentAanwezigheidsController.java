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
    public Button afwezig;
    public Button aanwezig;

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

    public void setAanwezig(ActionEvent actionEvent) {

        ObservableList leerling = ListView.getSelectionModel().getSelectedIndices();
        for (Object o : leerling){
            String i = String.valueOf(o);
            int index = Integer.parseInt(i) + 1;
            Object aanwezig = "aanwezig";
            ListView.getItems().set(index, aanwezig);
            ListView.getItems().remove(index+1);
        }
    }

    public void setAfwezig(ActionEvent actionEvent) {
        ObservableList leerling = ListView.getSelectionModel().getSelectedIndices();
        for (Object o : leerling){
            String i = String.valueOf(o);
            int index = Integer.parseInt(i) + 1;
            Object afwezig = "afwezig";
            ListView.getItems().set(index, afwezig);
            ListView.getItems().add(index+1, "afwezig door docent");
        }

    }
}
