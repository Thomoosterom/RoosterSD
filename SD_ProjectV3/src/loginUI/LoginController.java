package loginUI;

import Klasse.Docent;
import Klasse.Klas;
import Klasse.Student;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {
    @FXML
    private TextField gebruikersnaam;
    @FXML
    private TextField wachtwoord;


    Klas k = Klas.getKlas();

    public void inloggen() throws IOException {
        try {
            String[] split = gebruikersnaam.getText().split("@");

            if (split[1].equals("student.hu.nl")) {
                for (Student c : k.getStudenten()) {
                    String t = c.getEmail();
                    String ww = c.getWachtwoord();
                    String nm = c.getNaam();
               //     String[] split2 = nm.split(" ");
                    if (gebruikersnaam.getText().equals(t)) {
                        if (wachtwoord.getText().equals(ww)) {

                            Student st = new Student(ww,nm, t, "aanwezig");
                            Student.setDeStudent(st);
                            String fxmlPagina = "/LeerlingRooster.fxml";
                            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
                            Parent root = loader.load();

                            Stage newStage = new Stage();
                            newStage.setScene(new Scene(root));
                            newStage.initModality(Modality.APPLICATION_MODAL);
                            newStage.showAndWait();
                            return;
                        }
                    }
                }
            }

            if (split[1].equals("docent.hu.nl")) {
                for (Docent g : (k.getDocenten())) {
                    String t = g.getMailadres();
                    String ww = g.getWachtwoord();
                    String nm = g.getNaam();
                //    String[] split2 = nm.split(" ");
                    if (gebruikersnaam.getText().equals(t)) {
                        if (wachtwoord.getText().equals(ww)) {

                            Docent d = new Docent(ww,nm, t);
                            k.setDocent(d);
                            String fxmlPagina = "/DocentRooster.fxml";
                            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
                            Parent root = loader.load();

                            Stage newStage = new Stage();
                            newStage.setScene(new Scene(root));
                            newStage.initModality(Modality.APPLICATION_MODAL);
                            newStage.showAndWait();
                            return;
                        }
                    }
                }

            } throw new Exception ();


        }catch(Exception exception){
            alertTonen("Voer een geldige emailadres en wachtwoord in!");
            }
        }

    private void alertTonen(String alertText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(alertText);
        alert.showAndWait();
    }
}
