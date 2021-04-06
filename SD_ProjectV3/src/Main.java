import Klasse.Docent;
import Klasse.Klas;
import Klasse.Student;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) throws Exception {
        Klas k = new Klas("V1A");

        Student k1 = new Student("1", "Cara van straten","cara.vanstraten@student.hu.nl", "aanwezig");
        k.voegStudentToe(k1);

        Student k2 = new Student("2","Selcuk canak","selcuk.canak@student.hu.nl","aanwezig");
        k.voegStudentToe(k2);

        Student k3 = new Student("3","Thom oosterom","thom.oosterom@student.hu.nl","aanwezig");
        k.voegStudentToe(k3);

        Student k4 = new Student("4","Yair westmaas","yair.westmaas@student.hu.nl","aanwezig");
        k.voegStudentToe(k4);

        Student k5 = new Student("5","Yassir yagou","yassir.yagou@student.hu.nl","aanwezig");
        k.voegStudentToe(k5);

        Docent d = new Docent("6","Peter van rooijen","peter.vanrooijen@docent.hu.nl");
        k.voegDocentToe(d);

        Docent d1 = new Docent("7","Leo pruijt","leo.pruijt@docent.hu.nl");
        k.voegDocentToe(d1);

        Docent d2 = new Docent("8","Bart van ijekelenburg","bart.vaneijkelenburg@docent.hu.nl");
        k.voegDocentToe(d2);

        Klas.setKlas(k);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPagina = "loginUI/Login.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
        Parent root = loader.load();

        stage.setTitle("LoginScherm");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
