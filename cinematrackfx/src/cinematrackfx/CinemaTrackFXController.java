package cinematrackfx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CinemaTrackFXController implements Initializable {

	@FXML
	private TableView<Film> tabela_filme;
	@FXML
	private Tab tab_filme;
	@FXML
	private Button buton_incarcarefilme;
	@FXML
	private TableColumn<Film, Integer> atribut_idfilm;
	@FXML
	private TableColumn<Film, String> atribut_titlu;
	@FXML
	private TableColumn<Film, String> atribut_gen;
	@FXML
	private TableColumn<Film, Integer> atribut_an_lansare;
	@FXML
	private TableColumn<Film, String> atribut_durata;
	@FXML
	private TableColumn<Film, String> atribut_descriere;
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
	@FXML
	private TableView<Producator> tabela_producatori;
	@FXML
	private Tab tab_producatori;
	@FXML
	private Button buton_incarcareproducatori;
	@FXML
	private TableColumn<Producator, Integer> atribut_idproducator;
	@FXML
	private TableColumn<Producator, String> atribut_numep;
	@FXML
	private TableColumn<Producator, String> atribut_prenumep;
	@FXML
	private TableColumn<Producator, String> atribut_adresap;
	@FXML
	private TableColumn<Producator, String> atribut_nationalitatep;
	@FXML
	private TableColumn<Producator, Integer> atribut_venitp;
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
	@FXML
	private TableView<Actor> tabela_actori;
	@FXML
	private Tab tab_actori;
	@FXML
	private Button buton_incarcareactori;
	@FXML
	private TableColumn<Actor, Integer> atribut_idactor;
	@FXML
	private TableColumn<Actor, Integer> atribut_idfilm_a;
	@FXML
	private TableColumn<Actor, Integer> atribut_idproducator_a;
	@FXML
	private TableColumn<Actor, String> atribut_nume_a;
	@FXML
	private TableColumn<Actor, String> atribut_prenume_a;
	@FXML
	private TableColumn<Actor, String> atribut_rol_a;
	@FXML
	private TableColumn<Actor, String> atribut_titlufilm_a;
	@FXML
	private TableColumn<Actor, String> atribut_genfilm_a;
	@FXML
	private TableColumn<Actor, Integer> atribut_an_lansarefilm_a;
	@FXML
	private TableColumn<Actor, String> atribut_duratafilm_a;
	@FXML
	private TableColumn<Actor, String> atribut_descrierefilm_a;
	@FXML
	private TableColumn<Actor, String> atribut_numep_a;
	@FXML
	private TableColumn<Actor, String> atribut_prenumep_a;
	@FXML
	private TableColumn<Actor, String> atribut_adresap_a;
	@FXML
	private TableColumn<Actor, String> atribut_nationalitatep_a;
	@FXML
	private TableColumn<Actor, Integer> atribut_venitp_a;
	@FXML
	private ComboBox combobox_film;
	@FXML
	private ComboBox combobox_producator;
	@FXML
	private TextField inputnume_a;
	@FXML
	private TextField inputprenume_a;
	@FXML
	private TextField inputrol_a;

	private ObservableList<Film> dateFilme;
	private ObservableList<Producator> dateProducatori;
	private ObservableList<Actor> dateActori;
	private DBOperations jb;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		jb = new DBOperations();
		if (combobox_film != null) {
			ObservableList<Integer> dateidfilm = FXCollections.observableArrayList();
			try {
				jb.connect();
				ResultSet rs = jb.vedeTabela("filme");
				while (rs.next()) {
					dateidfilm.add(rs.getInt("idfilm"));
				}
				jb.disconnect();
				combobox_film.setItems(dateidfilm);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}
		if (combobox_producator != null) {
			ObservableList<Integer> dateidproducator = FXCollections.observableArrayList();
			try {
				jb.connect();
				ResultSet rs = jb.vedeTabela("producatori");
				while (rs.next()) {
					dateidproducator.add(rs.getInt("idproducator"));
				}
				jb.disconnect();
				combobox_producator.setItems(dateidproducator);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}
		
	}


	@FXML
	private void incarcaFilme(ActionEvent event) throws SQLException, Exception {
		jb.connect();
		dateFilme = FXCollections.observableArrayList();

		ResultSet rs = jb.vedeTabela("filme");
		while (rs.next()) {
			dateFilme.add(new Film(rs.getInt("idfilm"), rs.getString("titlu"), rs.getString("gen"), rs.getInt("an_lansare"), rs.getString("durata"), rs.getString("descriere")));
		}

		atribut_idfilm.setCellValueFactory(new PropertyValueFactory<>("idfilm"));
		atribut_titlu.setCellValueFactory(new PropertyValueFactory<>("titlu"));
		atribut_gen.setCellValueFactory(new PropertyValueFactory<>("gen"));
		atribut_an_lansare.setCellValueFactory(new PropertyValueFactory<>("an_lansare"));
		atribut_durata.setCellValueFactory(new PropertyValueFactory<>("durata"));
		atribut_descriere.setCellValueFactory(new PropertyValueFactory<>("descriere"));
		
		tabela_filme.setItems(null);
		tabela_filme.setItems(dateFilme);
		jb.disconnect();
	}  


	@FXML
	private void startAdaugaFilm() throws IOException {
		Stage stage = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaFilm.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void adaugaFilm() throws SQLException, Exception {
		String titlu = inputtitlu.getText();
		String gen = inputgen.getText();
		String an_lansare = inputan_lansare.getText();
		String durata = inputdurata.getText();
		String descriere = inputdescriere.getText();

		jb.connect();
		jb.adaugaFilm(titlu, gen, an_lansare, durata, descriere);
		jb.disconnect();
		incarcaFilme(null);
	}

	@FXML
	private void stergeFilm(ActionEvent event) throws SQLException, Exception {
		Film filmSelectat = tabela_filme.getSelectionModel().getSelectedItem();
		if (filmSelectat != null) {
			String[] primaryKeys = {String.valueOf(filmSelectat.getidfilm())};
			jb.connect();
			jb.stergeDateTabela(primaryKeys, "filme", "idfilm");  // Folosește funcția generala pentru ștergere
			jb.disconnect();

			// Elimină filmul din lista afișată
			dateFilme.remove(filmSelectat);
		} else {
			System.out.println("Nu a fost selectat niciun film pentru ștergere.");
		}
	}

	@FXML
	private void modificaFilm(ActionEvent event) throws SQLException, Exception {
		try {
			jb.connect();

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
			Film selectedFilm = tabela_filme.getSelectionModel().getSelectedItem();
			if (selectedFilm != null) {
				int idfilm = selectedFilm.getidfilm();
				// Apelăm metoda pentru a actualiza filmul
				jb.modificaTabela("filme", "idfilm", idfilm, campuri, valori);
				System.out.println("Filmul a fost actualizat cu succes!");
			} else {
				System.out.println("Te rog să selectezi un film!");
			}

			jb.disconnect();
		} catch (Exception e) {
			System.out.println("Eroare la modificarea filmului: " + e.getMessage());
		} finally {
			jb.disconnect();
			incarcaFilme(null);
		}
	}
	
	private void showWarning(String message) {
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setTitle("Avertisment!");
	    alert.setHeaderText(null); // Fără header, doar mesajul
	    alert.setContentText(message); // Setează mesajul transmis
	    alert.showAndWait(); // Afișează alerta și așteaptă ca utilizatorul să o închidă
	}

	
	@FXML
	private void onModificaFilmClick(ActionEvent event) throws IOException {
	    // Obținem filmul selectat din tabel
	    Film selectedFilm = tabela_filme.getSelectionModel().getSelectedItem();

	    // Verificăm dacă un film a fost selectat
	    if (selectedFilm == null) {
	        showWarning("Selectați un film din tabel pentru a-l modifica!");
	        return;
	    }

	    // Încarcă fereastra de modificare
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaFilm.fxml"));
	    AnchorPane root = loader.load();
	    
	    // Obține controller-ul ferestrei de modificare
	    ModificaFilmController modificaFilmController = loader.getController();
	    
	    // Transmite filmul selectat către controller-ul de modificare
	    modificaFilmController.initializeFilm(selectedFilm);
	    
	    // Crează un stage pentru fereastra de modificare
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();
	}


	
	@FXML
	private void startModificaFilm() throws IOException {
	    Stage stage = new Stage();
	    AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("ModificaFilm.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}

	@FXML
	private void incarcaProducatori(ActionEvent event) throws SQLException, Exception {
		jb.connect();
		dateProducatori = FXCollections.observableArrayList();

		ResultSet rs = jb.vedeTabela("producatori");
		while (rs.next()) {
			dateProducatori.add(new Producator(rs.getInt("idproducator"), rs.getString("nume"), rs.getString("prenume"), rs.getString("adresa"), rs.getString("nationalitate"), rs.getInt("venit")));
		}

		atribut_idproducator.setCellValueFactory(new PropertyValueFactory<>("idproducator"));
		atribut_numep.setCellValueFactory(new PropertyValueFactory<>("nume"));
		atribut_prenumep.setCellValueFactory(new PropertyValueFactory<>("prenume"));
		atribut_adresap.setCellValueFactory(new PropertyValueFactory<>("adresa"));
		atribut_nationalitatep.setCellValueFactory(new PropertyValueFactory<>("nationalitate"));
		atribut_venitp.setCellValueFactory(new PropertyValueFactory<>("venit"));

		tabela_producatori.setItems(null);
		tabela_producatori.setItems(dateProducatori);
		jb.disconnect();
	}  

	@FXML
	private void startAdaugaProducator() throws IOException {
		Stage stage = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaProducator.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void adaugaProducator() throws SQLException, Exception {
		String nume = inputnumep.getText();
		String prenume = inputprenumep.getText();
		String adresa = inputadresap.getText();
		String nationalitate = inputnationalitatep.getText();
		String venit = inputvenitp.getText();

		jb.connect();
		jb.adaugaProducator(nume, prenume, adresa, nationalitate, venit);
		jb.disconnect();
		incarcaProducatori(null);
	}

	@FXML
	private void stergeProducator(ActionEvent event) throws SQLException, Exception {
		Producator producatorSelectat = tabela_producatori.getSelectionModel().getSelectedItem();
		if (producatorSelectat != null) {
			String[] primaryKeys = {String.valueOf(producatorSelectat.getidproducator())};
			jb.connect();
			jb.stergeDateTabela(primaryKeys, "producatori", "idproducator");  // Folosește funcția generala pentru ștergere
			jb.disconnect();

			// Elimină producătorul din lista afișată
			dateProducatori.remove(producatorSelectat);
		} else {
			System.out.println("Nu a fost selectat niciun producător pentru ștergere.");
		}
	}

	@FXML
	private void onModificaProducatorClick(ActionEvent event) throws IOException {
	    // Obținem producătorul selectat din tabel
	    Producator selectedProducator = tabela_producatori.getSelectionModel().getSelectedItem();

	    // Verificăm dacă un producător a fost selectat
	    if (selectedProducator == null) {
	        showWarning("Selectați un producător din tabel pentru a-l modifica!");
	        return;
	    }

	    // Încarcă fereastra de modificare
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModificaProducator.fxml"));
	    AnchorPane root = loader.load();
	    
	    // Obține controller-ul ferestrei de modificare
	    ModificaProducatorController modificaProducatorController = loader.getController();
	    
	    // Transmite producătorul selectat către controller-ul de modificare
	    modificaProducatorController.initializeProducator(selectedProducator);
	    
	    // Crează un stage pentru fereastra de modificare
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.show();
	}

	@FXML
	private void startModificaProducator() throws IOException {
	    Stage stage = new Stage();
	    AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("ModificaProducator.fxml"));
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}


	@FXML
	private void incarcaActori(ActionEvent event) throws SQLException, Exception {
		jb.connect();
		dateActori = FXCollections.observableArrayList();

		// Apelăm metoda care returnează rezultatele combinate
		ResultSet rs = jb.vedeActor(); 

		// Parcurgem rezultatele și le adăugăm în lista de actori
		while (rs.next()) {
			dateActori.add(new Actor(rs.getInt("idactor"), rs.getString("NumeActor"), rs.getString("PrenumeActor"), rs.getString("RolActor"), rs.getString("TitluFilm"), rs.getString("GenFilm"), rs.getInt("AnLansareFilm"), rs.getString("DurataFilm"), 
					rs.getString("DescriereFilm"), rs.getString("NumeProducator"), rs.getString("PrenumeProducator"), rs.getString("AdresaProducator"), rs.getString("NationalitateProducator"), rs.getInt("VenitProducator")));
		}

		// Setăm valorile în TableView
		atribut_idactor.setCellValueFactory(new PropertyValueFactory<>("idactor"));
		/*atribut_idfilm_a.setCellValueFactory(new PropertyValueFactory<>("idfilm_actor"));
		atribut_idproducator_a.setCellValueFactory(new PropertyValueFactory<>("idproducator_actor"));*/
		atribut_nume_a.setCellValueFactory(new PropertyValueFactory<>("NumeActor"));
		atribut_prenume_a.setCellValueFactory(new PropertyValueFactory<>("PrenumeActor"));
		atribut_rol_a.setCellValueFactory(new PropertyValueFactory<>("RolActor"));

		atribut_titlufilm_a.setCellValueFactory(new PropertyValueFactory<>("TitluFilm"));
		atribut_genfilm_a.setCellValueFactory(new PropertyValueFactory<>("GenFilm"));
		atribut_an_lansarefilm_a.setCellValueFactory(new PropertyValueFactory<>("AnLansareFilm"));
		atribut_duratafilm_a.setCellValueFactory(new PropertyValueFactory<>("DurataFilm"));
		atribut_descrierefilm_a.setCellValueFactory(new PropertyValueFactory<>("DescriereFilm"));

		atribut_numep_a.setCellValueFactory(new PropertyValueFactory<>("NumeProducator"));
		atribut_prenumep_a.setCellValueFactory(new PropertyValueFactory<>("PrenumeProducator"));
		atribut_adresap_a.setCellValueFactory(new PropertyValueFactory<>("AdresaProducator"));
		atribut_nationalitatep_a.setCellValueFactory(new PropertyValueFactory<>("NationalitateProducator"));
		atribut_venitp_a.setCellValueFactory(new PropertyValueFactory<>("VenitProducator"));

		tabela_actori.setItems(null); // Resetează datele tabelului
		tabela_actori.setItems(dateActori); // Încarcă datele noi

		jb.disconnect();
	}


	@FXML
	private void startAdaugaActor() throws IOException {
		Stage stage = new Stage();
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("AdaugaActor.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void adaugaActor() throws SQLException, Exception {
		String nume = inputnume_a.getText();
		String prenume = inputprenume_a.getText();
		String rol = inputrol_a.getText();
		Integer idfilm = (Integer) combobox_film.getValue();
		Integer idproducator = (Integer) combobox_producator.getValue();

		jb.connect();
		jb.adaugaActor(idfilm, idproducator, nume, prenume, rol);
		jb.disconnect();
		incarcaActori(null);
	}

	@FXML
	private void stergeActor(ActionEvent event) throws SQLException, Exception {
		Actor actorSelectat = tabela_actori.getSelectionModel().getSelectedItem();
		if (actorSelectat != null) {
			String[] primaryKeys = {String.valueOf(actorSelectat.getidactor())};
			jb.connect();
			jb.stergeDateTabela(primaryKeys, "actori", "idactor");  // Folosește funcția generala pentru ștergere
			jb.disconnect();

			// Elimină actorul din lista afișată
			dateActori.remove(actorSelectat);
		} else {
			System.out.println("Nu a fost selectat niciun actor pentru ștergere.");
		}
	}

	@FXML
	private void modificaActor(ActionEvent event) throws SQLException, Exception {
		try {
			jb.connect();

			// Preluăm valorile din câmpuri
			String[] valori = {
					combobox_film.getValue().toString(),
					combobox_producator.getValue().toString(),
					inputnume_a.getText(),
					inputprenume_a.getText(),
					inputrol_a.getText()
			};
			String[] campuri = {"idfilm", "idproducator", "nume", "prenume", "rol"};

			// Preluăm ID-ul actorului selectat
			Actor selectedActor = tabela_actori.getSelectionModel().getSelectedItem();
			if (selectedActor != null) {
				int idActor = selectedActor.getidactor();
				// Apelăm metoda pentru a actualiza actorul
				jb.modificaTabela("actori", "idactor", idActor, campuri, valori);
				System.out.println("Actorul a fost actualizat cu succes!");
			} else {
				System.out.println("Te rog să selectezi un actor!");
			}

			jb.disconnect();

		} catch (Exception e) {
			System.out.println("Eroare la modificarea actorului: " + e.getMessage());
		} finally {
			jb.disconnect();
			incarcaActori(null);
		}
	}
}
