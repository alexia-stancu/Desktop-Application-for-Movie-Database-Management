package cinematrackfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Film {
	private final IntegerProperty idfilm;
	private final StringProperty titlu;
	private final StringProperty gen;
	private final IntegerProperty an_lansare;
	private final StringProperty durata;
	private final StringProperty descriere;
	
	public Film(int idfilm, String titlu, String gen, int an_lansare, String durata, String descriere) {
		this.idfilm = new SimpleIntegerProperty(idfilm);
		this.titlu = new SimpleStringProperty(titlu);
		this.gen = new SimpleStringProperty(gen);
		this.an_lansare = new SimpleIntegerProperty(an_lansare);
		this.durata = new SimpleStringProperty(durata);
		this.descriere = new SimpleStringProperty(descriere);
	}
	
	public Integer getidfilm() {
		return idfilm.get();
	}

	public String gettitlu() {
		return titlu.get();
	}
	
	public String getgen() {
		return gen.get();
	}
	
	public Integer getan_lansare() {
		return an_lansare.get();
	}
	
	public String getdurata() {
		return durata.get();
	}
	
	public String getdescriere() {
		return descriere.get();
	}

	public void setidfilm(Integer valoare) {
		idfilm.set(valoare);
	}

	public void settitlu(String valoare) {
		titlu.set(valoare);
	}
	
	public void setgen(String valoare) {
		gen.set(valoare);
	}
	
	public void setan_lansare(int valoare) {
		an_lansare.set(valoare);
	}
	
	public void setdurata(String valoare) {
		durata.set(valoare);
	}
	
	public void setdescriere(String valoare) {
		descriere.set(valoare);
	}

	public IntegerProperty idfilmProperty() {
	    return idfilm;
	}

	public StringProperty titluProperty() {
	    return titlu;
	}

	public StringProperty genProperty() {
	    return gen;
	}

	public IntegerProperty an_lansareProperty() {
	    return an_lansare;
	}

	public StringProperty durataProperty() {
	    return durata;
	}

	public StringProperty descriereProperty() {
	    return descriere;
	}

}
