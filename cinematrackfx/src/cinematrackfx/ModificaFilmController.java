package cinematrackfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class ModificaFilmController {

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

	private DBOperations jb = new DBOperations(); // Obiect pentru operațiuni cu baza de date

	private Film selectedFilm; // Filmul selectat din tabel

	/**
	 * Metoda pentru inițializarea datelor de modificat.
	 * Aceasta este apelată când fereastra este deschisă.
	 */
	public void initializeFilm(Film film) {
		this.selectedFilm = film;

		if (film != null) {
			inputtitlu.setText(film.gettitlu());
			inputgen.setText(film.getgen());
			inputan_lansare.setText(String.valueOf(film.getan_lansare()));
			inputdurata.setText(String.valueOf(film.getdurata()));
			inputdescriere.setText(film.getdescriere());
		}
	}

	/**
	 * Modifică un film existent în baza de date.
	 */
	@FXML
	private void modificaFilm(ActionEvent event) {
	    try {
	        // Verificăm dacă conexiunea este activă, dacă nu, încercăm să o stabilim
	        if (!jb.isConnected()) {
	            jb.connect();  // Conectăm la baza de date
	        }

	        // Preluăm valorile din câmpuri
	        String[] valori = {
	                inputtitlu.getText(),
	                inputgen.getText(),
	                inputan_lansare.getText(),
	                inputdurata.getText(),
	                inputdescriere.getText()
	        };
	        String[] campuri = {"titlu", "gen", "an_lansare", "durata", "descriere"};

	        // Preluăm ID-ul filmului selectat
	        if (selectedFilm != null) {
	            int idfilm = selectedFilm.getidfilm();

	            // Apelăm metoda pentru a actualiza filmul
	            jb.modificaTabela("filme", "idfilm", idfilm, campuri, valori);
	            showInfo("Filmul a fost modificat cu succes!");

	            // Închidem fereastra
	            Stage stage = (Stage) inputtitlu.getScene().getWindow();
	            stage.close();
	        } else {
	            showWarning("Te rog să selectezi un film!");
	        }
	    } catch (SQLException e) {
	        showError("Eroare la modificarea filmului: " + e.getMessage());
	    } catch (Exception e) {
	        showError("Eroare necunoscută: " + e.getMessage());
	    } finally {
	        try {
	            jb.disconnect();
	        } catch (SQLException e) {
	            showError("Eroare la deconectarea de la baza de date: " + e.getMessage());
	        }
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

	/**
	 * Afișează un mesaj de eroare.
	 */
	private void showError(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Eroare");
		alert.setHeaderText("A apărut o eroare");
		alert.setContentText(message);
		alert.showAndWait();
	}

	/**
	 * Afișează un mesaj informativ.
	 */
	private void showInfo(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Succes!");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	/**
	 * Afișează un mesaj de avertizare.
	 */
	private void showWarning(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Avertisment!");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
