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

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class DocentAanwezigheidsController {
    public DatePicker datePicker;
    public ListView ListView;
    public Button close;
    public Button afwezig;
    public Button aanwezig;
    public Label dagLabel;
    private double afwezigPercent;


    Klas k = Klas.getKlas();

    public void initialize() {
        afwezigPercent = afwezigPercentage();
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

                int index = Leerlingen.indexOf(Student.getDeStudent().getNaam());
                Leerlingen.remove(index);
                Leerlingen.remove(index);
                Leerlingen.remove(index);

                Student.getDeStudent().setStatus("afwezig");
                Leerlingen.add(String.valueOf(Student.getDeStudent().getNaam()));
                Leerlingen.add(String.valueOf(Student.getDeStudent().getStatus()));
                Leerlingen.add(String.valueOf(Student.getDeStudent().getReden()));
                Leerlingen.add("");

            }
        }
        Leerlingen.add("Percentage afwezig: " + afwezigPercentage());

        ListView.setItems(Leerlingen);

    }

    public void setAanwezig(ActionEvent actionEvent) {
        ObservableList leerling = ListView.getSelectionModel().getSelectedIndices();

        for (Object o : leerling){
            String i = String.valueOf(o);
            int index = Integer.parseInt(i) + 1;
            Object aanwezig = "aanwezig";
            if (ListView.getItems().get(index).equals("afwezig")) {
                if (Student.getDeStudent()==null || datePicker.getValue().isAfter(Student.getDeStudent().getAfwezigDatumBegin().minusDays(1)) &&
                        datePicker.getValue().isBefore(Student.getDeStudent().getAfwezigDatumEinde().plusDays(1)) ||
                        datePicker.getValue().isAfter(Student.getDeStudent().getZiekDatum().minusDays(1)) &&
                                datePicker.getValue().isBefore(Student.getDeStudent().getBeterDatum())) {
                    ListView.getItems().set(index, aanwezig);
                    ListView.getItems().remove(index + 1);
                    ListView.getItems().remove("Percentage afwezig: " + afwezigPercentage());
                    ListView.getItems().remove("Percentage afwezig:  " + afwezigPercent);
                    afwezigPercent = afwezigPercent - 20;
                    ListView.getItems().add("Percentage afwezig:  " + afwezigPercent);
                }
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
                        ListView.getItems().remove("Percentage afwezig: " + afwezigPercentage());
                        ListView.getItems().remove("Percentage afwezig:  " + afwezigPercent);
                        afwezigPercent = afwezigPercent + 20;
                        ListView.getItems().add("Percentage afwezig:  " + afwezigPercent);
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
            afwezigPercent = afwezigPercentage();
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
            afwezigPercent = afwezigPercentage();
        } else{
            ListView.getItems().clear();
            ListView.getItems().add("Er is geen les vandaag");
        }
    }

    public double afwezigPercentage() {
        double aantalAfwezig = 0;
        if (Student.getDeStudent() != null &&
                Student.getDeStudent().getStatus().equals("afwezig") &&
                datePicker.getValue() != null) {
            if (datePicker.getValue().isAfter(Student.getDeStudent().getAfwezigDatumBegin().minusDays(1)) &&
                    datePicker.getValue().isBefore(Student.getDeStudent().getAfwezigDatumEinde().plusDays(1)) ||
                    datePicker.getValue().isAfter(Student.getDeStudent().getZiekDatum().minusDays(1)) &&
                            datePicker.getValue().isBefore(Student.getDeStudent().getBeterDatum())) {
                aantalAfwezig++;
            }
        }
        double percentage = (aantalAfwezig/5) * 100;
        return percentage;
    }

}
