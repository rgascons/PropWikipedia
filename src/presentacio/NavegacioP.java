package presentacio;

import domini.controladors.CtrlCatPag;
import domini.controladors.CtrlWikipedia;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import presentacio.autocompletat.AutoCompleteComboBoxListener;

/**
 * Grup 3: Wikipedia
 * Usuari: aleix.paris
 * Data: 29/05/15
 */

public class NavegacioP {

    private final double SPACE = 10;
    private String nomP;
    private final NavegacioVista navegacioVista;
    private Stage stagePropi;

    private ListView<String> llista;

    public NavegacioP(String nomPagina, NavegacioVista nav, Stage stage){
        nomP = nomPagina;
        navegacioVista = nav;
        stagePropi = stage;
    }

    public Scene getScene(){
        VBox parent = new VBox(SPACE);
        parent.setPadding(new Insets(20));
        parent.setAlignment(Pos.CENTER);
        Scene scene = new Scene(parent);

        Label titol = new Label(nomP);
        titol.setFont(new Font(30));
        Separator separator1 = new Separator(); separator1.setVisible(false);
        Label cats = new Label("Categories a les quals pertany");
        llista = new ListView<>();
        llista.getItems().addAll("CAT1"); // TODO: necessaria funcio de CtrlWikipedia
        Button accedir = new Button("Accedir a la categoria");
        Button eliminarCat = new Button("Eliminar categoria de la pàgina");
        Separator separator2 = new Separator(); separator2.setVisible(false);
        Button afegirCat = new Button("Afegir categoria a la pàgina");
        Button eliminarPag = new Button("Eliminar la pàgina");
        accedir.setMaxWidth(Double.MAX_VALUE);
        eliminarCat.setMaxWidth(Double.MAX_VALUE);
        afegirCat.setMaxWidth(Double.MAX_VALUE);
        eliminarPag.setMaxWidth(Double.MAX_VALUE);

        parent.getChildren().addAll(titol, separator1, cats, llista,
                accedir, eliminarCat, separator2, afegirCat, eliminarPag);

        // OnMouseClicked Listeners:
        accedir.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!llista.getSelectionModel().isEmpty()) {
                    Stage stage = new Stage();
                    stagePropi.close();
                    NavegacioC navegacioC = new NavegacioC(llista.getSelectionModel().getSelectedItem(),
                            navegacioVista, stage);
                    Scene scene = navegacioC.getScene();
                    stage.setResizable(false);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setTitle("Categoria");
                    stage.show();
                } else System.out.println("No hi ha cat seleccionada");
            }
        });
        eliminarCat.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) { // TODO: comprobar funcionament
                if(!llista.getSelectionModel().isEmpty())
                    dialogEliminarCatDeLaPagina();
                else System.out.println("No hi ha cat seleccionada");
            }
        });
        afegirCat.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) { // TODO: comprobar funcionament
                dialogAfegirCat();
            }
        });
        eliminarPag.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dialogEliminarPagina();
            }
        });

        // finalment
        return scene;
    }

    private void dialogEliminarPagina(){
        final Stage dialog = new Stage();
        VBox parent = new VBox(SPACE);
        parent.setPadding(new Insets(20));
        Label confirmation = new Label("Estàs segur de que vols eliminar la pàgina " + nomP + "?");
        Separator separator = new Separator(); separator.setVisible(false);
        HBox botons = new HBox(SPACE);
        Button ok = new Button("D'acord");
        ok.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CtrlWikipedia.getInstance().elimPag(nomP);
                navegacioVista.carregarPagines();
                dialog.close();
                stagePropi.close();
            }
        });
        Button cancel = new Button("Cancel·lar");
        cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dialog.close();
            }
        });
        botons.getChildren().addAll(ok, cancel);
        botons.setAlignment(Pos.CENTER);
        parent.getChildren().addAll(confirmation, separator, botons);

        Scene dialogScene = new Scene(parent);
        dialog.setTitle("Eliminar pàgina");
        dialog.setResizable(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void dialogEliminarCatDeLaPagina(){
        final String nomC = llista.getSelectionModel().getSelectedItem();
        final Stage dialog = new Stage();
        VBox parent = new VBox(SPACE);
        parent.setPadding(new Insets(20));
        Label confirmation = new Label("Estàs segur de que vols eliminar la categoria " + nomC + " de la pàgina?");
        Separator separator = new Separator(); separator.setVisible(false);
        HBox botons = new HBox(SPACE);
        Button ok = new Button("D'acord");
        ok.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                CtrlCatPag.getInstance().esborrarArcPC(nomC, nomP);
                carregarCategories();
                dialog.close();
            }
        });
        Button cancel = new Button("Cancel·lar");
        cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dialog.close();
            }
        });
        botons.getChildren().addAll(ok, cancel);
        botons.setAlignment(Pos.CENTER);
        parent.getChildren().addAll(confirmation, separator, botons);

        Scene dialogScene = new Scene(parent);
        dialog.setTitle("Eliminar categoria de la pàgina");
        dialog.setResizable(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    private void carregarCategories(){   // TODO: recarregar llista
        //llista.setItems(data);
        llista.getSelectionModel().clearSelection(); // per evitar problemes de quin esta seleccionat si borrem dades
    }

    private void dialogAfegirCat(){
        final Stage dialog = new Stage();
        VBox parent = new VBox(SPACE);
        parent.setPadding(new Insets(20));
        Label confirmation = new Label("Escriu el nom de la categoria a afegir a la pàgina");
        ComboBox<String> nomCatAfegir = new ComboBox<>();
        nomCatAfegir.setPrefSize(300, 20);
        //nomCatAfegir.setItems();
        new AutoCompleteComboBoxListener(nomCatAfegir);
        HBox botons = new HBox(SPACE);
        Button ok = new Button("D'acord");
        ok.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //CtrlCatPag.getInstance().esborrarArcPC(nomC, nomP);
                carregarCategories();
                dialog.close();
            }
        });
        Button cancel = new Button("Cancel·lar");
        cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                dialog.close();
            }
        });
        botons.getChildren().addAll(ok, cancel);
        botons.setAlignment(Pos.CENTER);
        parent.getChildren().addAll(confirmation, nomCatAfegir, botons);

        Scene dialogScene = new Scene(parent);
        dialog.setTitle("Afegir categoria a la pàgina");
        dialog.setResizable(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setScene(dialogScene);
        dialog.show();
    }

}
