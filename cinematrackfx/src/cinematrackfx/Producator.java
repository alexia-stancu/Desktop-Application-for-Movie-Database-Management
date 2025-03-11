package cinematrackfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Producator {
	private final IntegerProperty idproducator;
	private final StringProperty nume;
	private final StringProperty prenume;
	private final StringProperty adresa;
	private final StringProperty nationalitate;
	private final IntegerProperty venit;

	public Producator(int idproducator, String nume, String prenume, String adresa, String nationalitate, int venit) {
		this.idproducator = new SimpleIntegerProperty(idproducator);
		this.nume = new SimpleStringProperty(nume);
		this.prenume = new SimpleStringProperty(prenume);
		this.adresa = new SimpleStringProperty(adresa);
		this.nationalitate = new SimpleStringProperty(nationalitate);
		this.venit = new SimpleIntegerProperty(venit);
	}

	public Integer getidproducator() {
		return idproducator.get();
	}

	public String getnume() {
		return nume.get();
	}

	public String getprenume() {
		return prenume.get();
	}
	
	public String getadresa() {
		return adresa.get();
	}

	public String getnationalitate() {
		return nationalitate.get();
	}

	public Integer getvenit() {
		return venit.get();
	}

	public void setidproducator(Integer valoare) {
		idproducator.set(valoare);
	}

	public void setnume(String valoare) {
		nume.set(valoare);
	}

	public void setprenume(String valoare) {
		prenume.set(valoare);
	}
	
	public void setadresa(String valoare) {
		adresa.set(valoare);
	}

	public void setnationalitate(String valoare) {
		nationalitate.set(valoare);
	}

	public void setvenit(Integer valoare) {
		venit.set(valoare);
	}

	public IntegerProperty idproducatorProperty() {
		return idproducator;
	}

	public StringProperty numeProperty() {
		return nume;
	}

	public StringProperty prenumeProperty() {
		return prenume;
	}
	
	public StringProperty adresaProperty() {
		return adresa;
	}

	public StringProperty nationalitateProperty() {
		return nationalitate;
	}

	public IntegerProperty venitProperty() {
		return venit;
	}
}
