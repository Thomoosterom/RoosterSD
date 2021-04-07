import Klasse.Klas;
import Klasse.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import jdk.dynalink.beans.StaticClass;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DocentAanwezigheidsController {
    public DatePicker datePicker;
    public ListView ListView;
    public Button close;
    public Button afwezig;
    public Button aanwezig;
    public Label dagLabel;

    Klas k = Klas.getKlas();

    public void initialize() {
        datePicker.setValue(LocalDate.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        String dag = simpleDateFormat.format(java.sql.Date.valueOf(datePicker.getValue()));
        String Dag = dag.substring(0,1).toUpperCase() + dag.substring(1).toLowerCase();
        dagLabel.setText(Dag);

        if (Dag.equals("Maandag") || Dag.equals("Dinsdag") || Dag.equals("Donderdag")) {
            toonLeerlingen();

        } else{
            ListView.getItems().clear();
            ListView.getItems().add("Er is geen les vandaag");
        }
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
        if (Student.getDeStudent() != null && Student.getDeStudent().getStatus().equals("afwezig")) {
            if (datePicker.getValue().isAfter(Student.getDeStudent().getAfwezigDatumBegin().minusDays(1)) &&
                    datePicker.getValue().isBefore(Student.getDeStudent().getAfwezigDatumEinde().plusDays(1)) ||
                    datePicker.getValue().isAfter(Student.getDeStudent().getZiekDatum().minusDays(1)) &&
                    datePicker.getValue().isBefore(Student.getDeStudent().getBeterDatum()) ) {

                Leerlingen.remove(Student.getDeStudent().getNaam());
                Leerlingen.remove(Student.getDeStudent().getStatus());
                Leerlingen.remove("aanwezig");
                Leerlingen.remove("");

                Leerlingen.add(String.valueOf(Student.getDeStudent().getNaam()));
                Leerlingen.add(String.valueOf(Student.getDeStudent().getStatus()));
                Leerlingen.add(String.valueOf(Student.getDeStudent().getReden()));
                Leerlingen.add("");

            }
        }
        ListView.setItems(Leerlingen);

    }

    public void setAanwezig(ActionEvent actionEvent) {
        ObservableList leerling = ListView.getSelectionModel().getSelectedIndices();

        for (Object o : leerling){
            String i = String.valueOf(o);
            int index = Integer.parseInt(i) + 1;
            Object aanwezig = "aanwezig";
            if (ListView.getItems().get(index).equals("afwezig")) {
                ListView.getItems().set(index, aanwezig);
                ListView.getItems().remove(index + 1);
            }
        }
    }

    public void setAfwezig(ActionEvent actionEvent) {
        ObservableList leerling = ListView.getSelectionModel().getSelectedIndices();
        for (Object o : leerling){
            String i = String.valueOf(o);
            int index = Integer.parseInt(i) + 1;
            Object afwezig = "afwezig";
            if (ListView.getItems().get(index).equals("aanwezig")) {
                ListView.getItems().set(index, afwezig);
                ListView.getItems().add(index + 1, "afwezig door docent");
            }
        }

    }

    public void dagTerug(ActionEvent actionEvent) {
        LocalDate dagEerder = datePicker.getValue().minusDays(1);
        datePicker.setValue(dagEerder);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        String dag = simpleDateFormat.format(java.sql.Date.valueOf(datePicker.getValue()));
        String Dag = dag.substring(0,1).toUpperCase() + dag.substring(1).toLowerCase();
        dagLabel.setText(Dag);

        if (Dag.equals("Maandag") || Dag.equals("Dinsdag") || Dag.equals("Donderdag")) {
            toonLeerlingen();
        } else{
            ListView.getItems().clear();
            ListView.getItems().add("Er is geen les vandaag");
        }
    }

    public void dagVerder(ActionEvent actionEvent) {
        LocalDate dagLater = datePicker.getValue().plusDays(1);
        datePicker.setValue(dagLater);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        String dag = simpleDateFormat.format(java.sql.Date.valueOf(datePicker.getValue()));
        String Dag = dag.substring(0,1).toUpperCase() + dag.substring(1).toLowerCase();
        dagLabel.setText(Dag);

        if (Dag.equals("Maandag") || Dag.equals("Dinsdag") || Dag.equals("Donderdag")) {
            toonLeerlingen();
        } else{
            ListView.getItems().clear();
            ListView.getItems().add("Er is geen les vandaag");
        }
    }
}
