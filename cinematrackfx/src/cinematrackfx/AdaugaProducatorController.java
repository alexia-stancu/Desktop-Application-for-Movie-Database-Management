package cinematrackfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AdaugaProducatorController {

	@FXML
	private TextField inputnumep;

	@FXML
	private TextField inputprenumep;

	@FXML
	private TextField inputadresap;

	@FXML
	private TextField inputnationalitatep;

	@FXML
	private TextField inputvenitp;

	private DBOperations jb = new DBOperations(); // Conexiunea cu baza de date

	/**
	 * Adaugă un producător nou în baza de date.
	 */
	@FXML
	private void adaugaProducator() {
		try {
			// Preluăm valorile din câmpurile de introducere
			String nume = inputnumep.getText();
			String prenume = inputprenumep.getText();
			String adresa = inputadresap.getText();
			String nationalitate = inputnationalitatep.getText();
			String venit = inputvenitp.getText();

			// Validare simplă a câmpurilor
			if (nume.isEmpty() || prenume.isEmpty() || adresa.isEmpty() || nationalitate.isEmpty() || venit.isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Eroare!");
				alert.setHeaderText("Toate câmpurile trebuie completate pentru a putea efectua adăugarea!");
				alert.showAndWait();
				return;
			}

			// Conectare la baza de date și adăugarea producătorului
			jb.connect();
			jb.adaugaProducator(nume, prenume, adresa, nationalitate, venit);
			jb.disconnect();

			// Afișare mesaj de succes
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Adăugare cu succes!");
			alert.setHeaderText("Producătorul a fost adăugat cu succes!");
			alert.showAndWait();

			// Închidem fereastra curentă
			Stage stage = (Stage) inputnumep.getScene().getWindow();
			stage.close();

		} catch (Exception e) {
			e.printStackTrace();

			// Afișare alertă în caz de eroare
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Eroare!");
			alert.setHeaderText("A apărut o eroare la adăugarea producătorului!");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	/**
	 * Închide fereastra curentă.
	 */
	@FXML
	private void inapoiLaPaginaPrincipala() {
		Stage stage = (Stage) inputnumep.getScene().getWindow();
		stage.close();
	}
}
