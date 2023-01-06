module com.example.pathofoil {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.drzed.pathofoil to javafx.fxml;
    exports com.drzed.pathofoil;
    exports com.drzed.pathofoil.objects;
    opens com.drzed.pathofoil.objects to javafx.fxml;
}