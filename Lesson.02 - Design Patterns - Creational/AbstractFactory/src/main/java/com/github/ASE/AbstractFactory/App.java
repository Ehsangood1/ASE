package com.github.ASE.AbstractFactory;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();
        VBox.setVgrow(tabPane, Priority.ALWAYS);

        VBox winBox = new VBox();
        UIComponentFactory winFactory = new com.github.ASE.AbstractFactory.Windows.Factory();
        winBox.getChildren().add(createSpacer());
        winBox.getChildren().add(winFactory.createButton().render());
        winBox.getChildren().add(createSpacer());
        winBox.getChildren().add(winFactory.createCheckBox().render());
        winBox.getChildren().add(createSpacer());
        winBox.setAlignment(Pos.CENTER);
        Tab winTab = new Tab("Windows", winBox);
        winTab.setClosable(false);
        tabPane.getTabs().add(winTab);

        VBox macBox = new VBox();
        UIComponentFactory macFactory = new com.github.ASE.AbstractFactory.MacOs.Factory();
        macBox.getChildren().add(createSpacer());
        macBox.getChildren().add(macFactory.createButton().render());
        macBox.getChildren().add(createSpacer());
        macBox.getChildren().add(macFactory.createCheckBox().render());
        macBox.getChildren().add(createSpacer());
        macBox.setAlignment(Pos.CENTER);
        Tab macTab = new Tab("MacOs", macBox);
        macTab.setClosable(false);
        tabPane.getTabs().add(macTab);

        VBox mainBox = new VBox(tabPane);
        Scene scene = new Scene(mainBox);

        stage.setScene(scene);
        stage.setTitle("AbstractFactory Demo");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private static Node createSpacer() {
        final Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
}