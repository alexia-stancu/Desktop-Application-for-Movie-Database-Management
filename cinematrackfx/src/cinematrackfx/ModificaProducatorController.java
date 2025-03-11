package cinematrackfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class ModificaProducatorController {

	@FXML
	private TextField inputnume;

	@FXML
	private TextField inputprenume;

	@FXML
	private TextField inputadresa;

	@FXML
	private TextField inputnationalitate;

	@FXML
	private TextField inputvenit;

	private DBOperations jb = new DBOperations(); // Obiect pentru operațiuni cu baza de date

	private Producator selectedProducator; // Producătorul selectat din tabel

	/**
	 * Metoda pentru inițializarea datelor de modificat.
	 * Aceasta este apelată când fereastra este deschisă.
	 */
	public void initializeProducator(Producator producator) {
		this.selectedProducator = producator;

		if (producator != null) {
			inputnume.setText(producator.getnume());
			inputprenume.setText(producator.getprenume());
			inputadresa.setText(producator.getadresa());
			inputnationalitate.setText(producator.getnationalitate());
			inputvenit.setText(String.valueOf(producator.getvenit()));
		}
	}

	/**
	 * Modifică un producător existent în baza de date.
	 */
	@FXML
	private void modificaProducator(ActionEvent event) {
		try {
			// Verificăm dacă conexiunea este activă, dacă nu, încercăm să o stabilim
			if (!jb.isConnected()) {
				jb.connect();  // Conectăm la baza de date
			}

			// Preluăm valorile din câmpuri
			String[] valori = {
					inputnume.getText(),
					inputprenume.getText(),
					inputadresa.getText(),
					inputnationalitate.getText(),
					inputvenit.getText()
			};
			String[] campuri = {"nume", "prenume", "adresa", "nationalitate", "venit"};

			// Preluăm ID-ul producătorului selectat
			if (selectedProducator != null) {
				int idproducator = selectedProducator.getidproducator();

				// Apelăm metoda pentru a actualiza producătorul
				jb.modificaTabela("producatori", "idproducator", idproducator, campuri, valori);
				showInfo("Producătorul a fost modificat cu succes!");

				// Închidem fereastra
				Stage stage = (Stage) inputnume.getScene().getWindow();
				stage.close();
			} else {
				showWarning("Te rog să selectezi un producător!");
			}
		} catch (SQLException e) {
			showError("Eroare la modificarea producătorului: " + e.getMessage());
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
		Stage stage = (Stage) inputnume.getScene().getWindow();
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
