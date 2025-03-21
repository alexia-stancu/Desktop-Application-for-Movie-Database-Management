package cinematrackfx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 


public class DBOperations {

	String error;
	Connection con;

	public void connect() throws ClassNotFoundException, SQLException, Exception { 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinematrack?useSSL=false", "webapp_user", "ParolaDeNedescifrat18;"); 
		} catch (ClassNotFoundException cnfe) { 
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date."; 
			throw new ClassNotFoundException(error); 
		} catch (SQLException cnfe) { 
			error = "SQLException: Nu se poate conecta la baza de date."; 
			throw new SQLException(error); 
		} catch (Exception e) { 
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date."; 
			throw new Exception(error); 
		} 
	} // connect() 

	public void connect(String bd) throws ClassNotFoundException, SQLException, Exception { 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd, "webapp_user", "ParolaDeNedescifrat18;"); 
		} catch (ClassNotFoundException cnfe) { 
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date."; 
			throw new ClassNotFoundException(error); 
		} catch (SQLException cnfe) { 
			error = "SQLException: Nu se poate conecta la baza de date."; 
			throw new SQLException(error); 
		} catch (Exception e) { 
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date."; 
			throw new Exception(error); 
		} 
	} // connect(String bd) 

	public void connect(String bd, String ip) throws ClassNotFoundException, SQLException, 
	Exception { 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306/" + bd, "webapp_user", "ParolaDeNedescifrat18;"); 
		} catch (ClassNotFoundException cnfe) { 
			error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date."; 
			throw new ClassNotFoundException(error); 
		} catch (SQLException cnfe) { 
			error = "SQLException: Nu se poate conecta la baza de date."; 
			throw new SQLException(error); 


		} catch (Exception e) { 
			error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date."; 
			throw new Exception(error); 
		} 
	} // connect(String bd, String ip) 
	
	public boolean isConnected() {
	    try {
	        // Verificăm dacă conexiunea este nulă sau închisă
	        return con != null && !con.isClosed();
	    } catch (SQLException e) {
	        // Dacă apare o excepție la verificare, înseamnă că conexiunea nu este validă
	        return false;
	    }
	}

	    private static final String DB_URL = "jdbc:mysql://localhost:3306/cinematrack";
	    private static final String DB_USER = "webapp_user";
	    private static final String DB_PASSWORD = "ParolaDeNedescifrat18;";

	    // Metoda pentru a stabili conexiunea
	    public Connection connects() throws SQLException {
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    }

	    // Metoda pentru obținerea listei de filme
	    public List<Integer> getListaFilme() throws SQLException {
	        List<Integer> filme = new ArrayList<>();
	        String query = "SELECT idfilm FROM filme"; // Interogare pentru titluri din tabelul filme

	        try (Connection con = connects(); // Obținem conexiunea de la metoda connect()
	             PreparedStatement stmt = con.prepareStatement(query); 
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                filme.add(rs.getInt("idfilm"));
	            }
	        }

	        return filme;
	    }

	    // Metoda pentru obținerea listei de producători
	    public List<Integer> getListaProducatori() throws SQLException {
	        List<Integer> producatori = new ArrayList<>();
	        String query = "SELECT idproducator FROM producatori"; // Interogare pentru titluri din tabelul filme

	        try (Connection con = connects(); // Obținem conexiunea de la metoda connect()
	             PreparedStatement stmt = con.prepareStatement(query); 
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                producatori.add(rs.getInt("idproducator"));
	            }
	        }

	        return producatori;
	    }




	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	} // disconnect()

	public void adaugaFilm(String titlu, String gen, String an_lansare, String durata, String descriere) 
			throws SQLException, Exception { 
		if (con != null) { 
			try { 
				// creeaza un "prepared SQL statement" 
				Statement stmt; 
				stmt = con.createStatement(); 
				stmt.executeUpdate("insert into filme(titlu, gen, an_lansare, durata, descriere) values('" + titlu + "'  , '" + gen + "', '" + an_lansare + "',  '" + durata + "',  '" + descriere + "');"); 

			} catch (SQLException sqle) { 
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate."; 
				throw new SQLException(error); 
			} 
		} else { 
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta."; 
			throw new Exception(error); 
		} 
	} // end of adaugaFilm()


	public void adaugaProducator(String nume, String prenume, String adresa, String nationalitate, String venit) 
			throws SQLException, Exception { 
		if (con != null) { 
			try { 
				// creaza un "prepared SQL statement" 
				Statement stmt; 


				stmt = con.createStatement(); 
				stmt.executeUpdate("insert into producatori(nume, prenume, adresa, nationalitate, venit) values('" + nume + "'  , '" + prenume + "', '" + adresa + "', '" + nationalitate + "', '" + venit + "');"); 

			} catch (SQLException sqle) { 
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate."; 
				throw new SQLException(error); 
			} 
		} else { 
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta."; 
			throw new Exception(error); 
		} 
	} // end of adaugaProducator()

	public void adaugaActor(int idfilm, int idproducator, String nume, String prenume, String rol) 
			throws SQLException, Exception { 
		if (con != null) { 
			try { 
				// creaza un "prepared SQL statement" 
				Statement stmt; 
				stmt = con.createStatement(); 
				stmt.executeUpdate("insert into actori(idfilm, idproducator, nume, prenume, rol) values('" + idfilm + "'  , '" + idproducator + "', '" + nume + "', '" + prenume + "', '" + rol + "');"); 
				// se poate modifica valoarea datei astfel incat sa se ia data curenta a sistemului: 
				// stmt.executeUpdate("insert into consultatie(idfilm, idproducator, nume, prenume, rol) values('" + idfilm + "'  , '" + idproducator + "', CURDATE(), '" + prenume + "', '" + rol + "');"); 

			} catch (SQLException sqle) { 
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate."; 
				throw new SQLException(error); 
			} 
		} else { 
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta."; 
			throw new Exception(error); 
		} 
	} // end of adaugaActor() 

	public ResultSet vedeTabela(String tabel) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select * from `cinematrack`.`" + tabel + "`;");
			Statement stmt = con.createStatement(/* ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY */);
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // vedeTabela()

	public ResultSet vedeActor() throws SQLException, Exception { 
		ResultSet rs = null; 
		try { 
			String queryString = ("select f.titlu TitluFilm, f.gen GenFilm, f.an_lansare AnLansareFilm, f.durata DurataFilm, f.descriere DescriereFilm, p.nume NumeProducator, p.prenume PrenumeProducator, p.adresa AdresaProducator, p.nationalitate NationalitateProducator, p.venit VenitProducator, a.idactor, a.idproducator idproducator_actor, a.idfilm idfilm_actor, a.nume NumeActor, a.prenume PrenumeActor, a.rol RolActor from filme f, producatori p, actori a where f.idfilm = a.idfilm and p.idproducator = a.idproducator;"); 
			Statement stmt = con.createStatement(/*ResultSet.TYPE_SCROLL_INSENSITIVE, 
ResultSet.CONCUR_READ_ONLY*/); 
			rs = stmt.executeQuery(queryString); 
		} catch (SQLException sqle) { 
			error = "SQLException: Interogarea nu a fost posibila."; 
			throw new SQLException(error); 
		} catch (Exception e) { 
			error = "A aparut o exceptie in timp ce se extrageau datele."; 
			throw new Exception(error); 
		} 
		return rs; 
	} // vedeConsultatie() 

	public void stergeDateTabela(String[] primaryKeys, String tabela, String dupaID) throws SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				long aux;
				PreparedStatement delete;
				delete = con.prepareStatement("DELETE FROM " + tabela + " WHERE " + dupaID + "=?;");
				for (int i = 0; i < primaryKeys.length; i++) {
					aux = java.lang.Long.parseLong(primaryKeys[i]);
					delete.setLong(1, aux);
					delete.execute();
				}
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			} catch (Exception e) {
				error = "A aparut o exceptie in timp ce erau sterse inregistrarile.";
				throw new Exception(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeDateTabela()

	public void stergeTabela(String tabela) throws SQLException, Exception {
		if (con != null) {
			try {
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate("delete from " + tabela + ";");
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Stergere nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of stergeTabela()

	public void modificaTabela(String tabela, String IDTabela, int ID, String[] campuri, String[] valori)
			throws SQLException, Exception {
		String update = "update " + tabela + " set ";
		String temp = "";
		if (con != null) {
			try {
				for (int i = 0; i < campuri.length; i++) {
					if (i != (campuri.length - 1)) {
						temp = temp + campuri[i] + "='" + valori[i] + "', ";
					} else {
						temp = temp + campuri[i] + "='" + valori[i] + "' where " + IDTabela + " = '" + ID + "';";
					}
				}
				update = update + temp;
				// creaza un "prepared SQL statement"
				Statement stmt;
				stmt = con.createStatement();
				stmt.executeUpdate(update);
			} catch (SQLException sqle) {
				error = "ExceptieSQL: Reactualizare nereusita; este posibil sa existe duplicate.";
				throw new SQLException(error);
			}
		} else {
			error = "Exceptie: Conexiunea cu baza de date a fost pierduta.";
			throw new Exception(error);
		}
	} // end of modificaTabela()

	public ResultSet intoarceLinie(String tabela, int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			// Executa interogarea
			String queryString = ("SELECT * FROM " + tabela + " where idprodus=" + ID + ";");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); // sql exception
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // end of intoarceLinie()

	public ResultSet intoarceLinieDupaId(String tabela, String denumireId, int ID) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			// Executa interogarea
			String queryString = ("SELECT * FROM " + tabela + " where " + denumireId + "=" + ID + ";");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(queryString); // sql exception
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	} // end of intoarceLinieDupaId()

	public ResultSet intoarceActorId(int ID) throws SQLException, Exception { 
		ResultSet rs = null; 
		try { 
			// Executa interogarea 
			String queryString = ("SELECT f.titlu TitluFilm, f.gen GenFilm, f.an_lansare AnLansareFilm, f.durata DurataFilm, f.descriere DescriereFilm, p.nume NumeProducator, p.prenume PrenumeProducator, p.adresa AdresaProducator, p.nationalitate NationalitateProducator, p.venit VenitProducator, a.idactor, a.idproducator idproducator_actor, a.idfilm idfilm_actor, a.nume NumeActor, a.prenume PrenumeActor, a.rol RolActor FROM filme f, producatori p, actori a WHERE f.idfilm = a.idfilm and p.idproducator = a.idproducator AND idactor = '" + ID + "';"); 
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY); 
			rs = stmt.executeQuery(queryString); //sql exception 
		} catch (SQLException sqle) { 
			error = "SQLException: Interogarea nu a fost posibila."; 
			throw new SQLException(error); 
		} catch (Exception e) { 
			error = "A aparut o exceptie in timp ce se extrageau datele."; 
			throw new Exception(error); 
		} 
		return rs; 
	} // end of intoarceLinieDupaId() 
}

