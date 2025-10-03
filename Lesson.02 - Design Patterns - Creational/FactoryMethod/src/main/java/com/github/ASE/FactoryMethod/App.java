package com.github.ASE.FactoryMethod;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import one.jpro.platform.mdfx.MarkdownView;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();
        VBox.setVgrow(tabPane, Priority.ALWAYS);

        final TextArea plainArea = new TextArea();
        plainArea.setFont(new Font("Courier New", 16));
        plainArea.setEditable(false);
        plainArea.setText(new com.github.ASE.FactoryMethod.PlainText.DocumentGenerator().generateDocument().render());
        VBox plainBox = new VBox(plainArea);
        Tab plainTab = new Tab("Plain", plainBox);
        plainTab.setClosable(false);
        tabPane.getTabs().add(plainTab);

        WebView webView = new WebView();
        webView.getEngine().loadContent(
                new com.github.ASE.FactoryMethod.HTML.DocumentGenerator().generateDocument().render(), "text/html");
        VBox htmlBox = new VBox(webView);
        Tab htmlTab = new Tab("HTML", htmlBox);
        htmlTab.setClosable(false);
        tabPane.getTabs().add(htmlTab);

        MarkdownView mdfx = new MarkdownView(
                new com.github.ASE.FactoryMethod.MarkDown.DocumentGenerator().generateDocument().render());
        VBox mdBox = new VBox(mdfx);
        Tab mdTab = new Tab("MarkDown", mdBox);
        mdTab.setClosable(false);
        tabPane.getTabs().add(mdTab);

        VBox mainBox = new VBox(tabPane);
        Scene scene = new Scene(mainBox);

        stage.setScene(scene);
        stage.setTitle("FactoryMethod Demo");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}