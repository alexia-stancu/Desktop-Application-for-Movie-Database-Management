package cinematrackfx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Actor {
	private final IntegerProperty idactor;
	/*private final IntegerProperty idfilm_actor;
	private final IntegerProperty idproducator_actor;*/
	private final StringProperty NumeActor;
	private final StringProperty PrenumeActor;
	private final StringProperty RolActor;
	private final StringProperty TitluFilm;
	private final StringProperty GenFilm;
	private final IntegerProperty AnLansareFilm;
	private final StringProperty DurataFilm;
	private final StringProperty DescriereFilm;
	private final StringProperty NumeProducator;
	private final StringProperty PrenumeProducator;
	private final StringProperty AdresaProducator;
	private final StringProperty NationalitateProducator;
	private final IntegerProperty VenitProducator;

	public Actor(int idactor, String NumeActor, String PrenumeActor, String RolActor, String TitluFilm, String GenFilm, int AnLansareFilm, String DurataFilm, String DescriereFilm, String NumeProducator, String PrenumeProducator, String AdresaProducator, String NationalitateProducator, int VenitProducator) {
		this.idactor = new SimpleIntegerProperty(idactor);
		/*this.idfilm_actor = new SimpleIntegerProperty(idfilm_actor);
		this.idproducator_actor = new SimpleIntegerProperty(idproducator_actor);*/
		this.NumeActor = new SimpleStringProperty(NumeActor);
		this.PrenumeActor = new SimpleStringProperty(PrenumeActor);
		this.RolActor = new SimpleStringProperty(RolActor);
		this.TitluFilm = new SimpleStringProperty(TitluFilm);
		this.GenFilm = new SimpleStringProperty(GenFilm);
		this.AnLansareFilm = new SimpleIntegerProperty(AnLansareFilm);
		this.DurataFilm = new SimpleStringProperty(DurataFilm);
		this.DescriereFilm = new SimpleStringProperty(DescriereFilm);
		this.NumeProducator = new SimpleStringProperty(NumeProducator);
		this.PrenumeProducator = new SimpleStringProperty(PrenumeProducator);
		this.AdresaProducator = new SimpleStringProperty(AdresaProducator);
		this.NationalitateProducator = new SimpleStringProperty(NationalitateProducator);
		this.VenitProducator = new SimpleIntegerProperty(VenitProducator);
	}

	public Integer getidactor() {
		return idactor.get();
	}


	/*public Integer getidfilm_actor() {
		return idfilm_actor.get();
	}

	public Integer getidproducator_actor() {
		return idproducator_actor.get();
	}*/

	public String getNumeActor() {
		return NumeActor.get();
	}

	public String getPrenumeActor() {
		return PrenumeActor.get();
	}

	public String getRolActor() {
		return RolActor.get();
	}

	public String getTitluFilm() {
		return TitluFilm.get();
	}

	public String getGenFilm() {
		return GenFilm.get();
	}

	public Integer getAnLansareFilm() {
		return AnLansareFilm.get();
	}

	public String getDurataFilm() {
		return DurataFilm.get();
	}

	public String getDescriereFilm() {
		return DescriereFilm.get();
	}

	public String getNumeProducator() {
		return NumeProducator.get();
	}

	public String getPrenumeProducator() {
		return PrenumeProducator.get();
	}

	public String getAdresaProducator() {
		return AdresaProducator.get();
	}

	public String getNationalitateProducator() {
		return NationalitateProducator.get();
	}

	public Integer getVenitProducator() {
		return VenitProducator.get();
	}

	public void setidactor(Integer valoare) {
		idactor.set(valoare);
	}

	/*public void setidproducator_actor(Integer valoare) {
		idproducator_actor.set(valoare);
	}

	public void setidfilm_actor(Integer valoare) {
		idfilm_actor.set(valoare);
	}*/

	public void setTitluFilm(String valoare) {
		TitluFilm.set(valoare);
	}

	public void setGenFilm(String valoare) {
		GenFilm.set(valoare);
	}

	public void setAnLansareFilm(int valoare) {
		AnLansareFilm.set(valoare);
	}

	public void setDurataFilm(String valoare) {
		DurataFilm.set(valoare);
	}

	public void setDescriereFilm(String valoare) {
		DescriereFilm.set(valoare);
	}

	public void setNumeActor(String valoare) {
		NumeActor.set(valoare);
	}

	public void setPrenumeActor(String valoare) {
		PrenumeActor.set(valoare);
	}

	public void setRolActor(String valoare) {
		RolActor.set(valoare);
	}

	public void setNumeProducator(String valoare) {
		NumeProducator.set(valoare);
	}

	public void setPrenumeProducator(String valoare) {
		PrenumeProducator.set(valoare);
	}

	public void setAdresaProducator(String valoare) {
		AdresaProducator.set(valoare);
	}

	public void setNationalitateProducator(String valoare) {
		NationalitateProducator.set(valoare);
	}

	public void setVenitProducator(Integer valoare) {
		VenitProducator.set(valoare);
	}

	public IntegerProperty idactorProperty() {
		return idactor;
	}

	/*public IntegerProperty idproducator_actorProperty() {
		return idproducator_actor;
	}

	public IntegerProperty idfilm_actorProperty() {
		return idfilm_actor;
	}*/

	public StringProperty NumeActorProperty() {
		return NumeActor;
	}

	public StringProperty PrenumeActorProperty() {
		return PrenumeActor;
	}

	public StringProperty RolActorProperty() {
		return RolActor;
	}

	public StringProperty TitluFilmProperty() {
		return TitluFilm;
	}

	public StringProperty GenFilmProperty() {
		return GenFilm;
	}

	public IntegerProperty AnLansareFilmProperty() {
		return AnLansareFilm;
	}

	public StringProperty DurataFilmProperty() {
		return DurataFilm;
	}

	public StringProperty DescriereFilmProperty() {
		return DescriereFilm;
	}

	public StringProperty NumeProducatorProperty() {
		return NumeProducator;
	}

	public StringProperty PrenumeProducatorProperty() {
		return PrenumeProducator;
	}

	public StringProperty AdresaProducatorProperty() {
		return AdresaProducator;
	}

	public StringProperty NationalitateProducatorProperty() {
		return NationalitateProducator;
	}

	public IntegerProperty VenitProducatorProperty() {
		return VenitProducator;
	}
}

