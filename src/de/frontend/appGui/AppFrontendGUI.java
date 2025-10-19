/*
package de.appGui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import de.datenbank.BewerberJsonDatenbankUndService;
import de.bewerber.CharakterBewerberpool;

import java.util.List;

public class AppFrontendGUI {

    public void showBewerberFenster() {
        Stage stage = new Stage();
        stage.setTitle("Alle Bewerber aus JSON");

        // 🔁 JSON laden
        BewerberJsonDatenbankUndService service = new BewerberJsonDatenbankUndService();
        service.laden();
        List<CharakterBewerberpool> bewerber = service.getAlleBewerber();

        // 📦 VBox mit Labels füllen
        VBox vbox = new VBox(10);
        for (CharakterBewerberpool b : bewerber) {
            Label label = new Label("👤 " + b.getClass().getSimpleName() +
                    " | ID: " + b.getBewerberId() +
                    " | Erfahrung: " + b.getJahreBerufserfahrung() +
                    " Jahre | Note: " + b.getEndbewerbernoten());
            label.setStyle("-fx-padding: 5; -fx-background-color: #e0e0e0;");
            vbox.getChildren().add(label);
        }

        // 🖱️ In ScrollPane packen
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefViewportHeight(400);
        scrollPane.setPrefViewportWidth(500);

        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();


    }


}
*/
