package cinematrackfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdaugaFilmController {

    @FXML
    private TextField inputtitlu;

    @FXML
    private TextField inputgen;

    @FXML
    private TextField inputan_lansare;

    @FXML
    private TextField inputdurata;

    @FXML
    private TextField inputdescriere;
    
    private DBOperations jb= new DBOperations(); // Conexiunea cu baza de date

    /**
     * Adaugă un film nou în baza de date.
     */
    @FXML
    private void adaugaFilm() {
        try {
            // Preluăm valorile din câmpurile de introducere
            String titlu = inputtitlu.getText();
            String gen = inputgen.getText();
            String an_lansare = inputan_lansare.getText();
            String durata = inputdurata.getText();
            String descriere = inputdescriere.getText();

            // Validare simplă a câmpurilor
            if (titlu.isEmpty() || gen.isEmpty() || an_lansare.isEmpty() || durata.isEmpty() || descriere.isEmpty()) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Eroare!");
                alert.setHeaderText("Toate câmpurile trebuie completate pentru a putea efectua adaugarea!");
                alert.showAndWait();
                return;
            }

            // Conectare la baza de date și adăugarea filmului
            jb.connect();
            jb.adaugaFilm(titlu, gen, an_lansare, durata, descriere);
            jb.disconnect();

            // Afișare mesaj de succes
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Adăugare cu succes!");
            alert.setHeaderText("Filmul a fost adăugat cu succes!");
            alert.showAndWait();

            // Închidem fereastra curentă
            Stage stage = (Stage) inputtitlu.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();

            // Afișare alertă în caz de eroare
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Eroare!");
            alert.setHeaderText("A apărut o eroare la adăugarea filmului!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Închide fereastra curentă.
     */
    @FXML
    private void inapoiLaPaginaPrincipala() {
        Stage stage = (Stage) inputtitlu.getScene().getWindow();
        stage.close();
    }
}
