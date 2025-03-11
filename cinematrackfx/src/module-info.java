module cinematrackfx {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens cinematrackfx to javafx.graphics, javafx.fxml, javafx.base;
}
