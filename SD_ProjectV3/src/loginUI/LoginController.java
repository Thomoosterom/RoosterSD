package loginUI;

import Klasse.Docent;
import Klasse.Klas;
import Klasse.Student;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
//        try {
        String[] split = gebruikersnaam.getText().split("@");
        if (split[1].equals("student.hu.nl")) {
            for (Student c : k.getStudenten()) {
                String t = c.getEmail();
                String nm = c.getNaam();
                String[] split2 = nm.split(" ");
                if (gebruikersnaam.getText().equals(t)) {
                    if (wachtwoord.getText().equals(split2[0])) {

                        Student st = new Student(nm, t, "aanwezig");
                        k.setStudent(st);
                        String fxmlPagina = "/LeerlingRooster.fxml";
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
                        Parent root = loader.load();

                        Stage newStage = new Stage();
                        newStage.setScene(new Scene(root));
                        newStage.initModality(Modality.APPLICATION_MODAL);
                        newStage.showAndWait();
                    }
                }
            }
        }

        if (split[1].equals("docent.hu.nl")) {
            for (Docent g : (k.getDocenten())) {
                String t = g.getMailadres();
                String nm = g.getNaam();
                System.out.println(nm);
                String[] split2 = nm.split(" ");
                if (gebruikersnaam.getText().equals(t)) {
                    if (wachtwoord.getText().equals(split2[0])) {

                        Docent d = new Docent(nm, t);
                        k.setDocent(d);
                        String fxmlPagina = "/DocentRooster.fxml";
                        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
                        Parent root = loader.load();

                        Stage newStage = new Stage();
                        newStage.setScene(new Scene(root));
                        newStage.initModality(Modality.APPLICATION_MODAL);
                        newStage.showAndWait();
                    }
                }
            }

        }
    }


//            }catch(Exception exception){
//                alertTonen(exception.getMessage());
//            }
//
//        }
//
//        private void alertTonen(String alertText) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setContentText(alertText);
//        alert.showAndWait();
//    }

//    public void reset(ActionEvent actionEvent){
//        gebruikersnaam.clear();
//        wachtwoord.clear();
//    }
}
