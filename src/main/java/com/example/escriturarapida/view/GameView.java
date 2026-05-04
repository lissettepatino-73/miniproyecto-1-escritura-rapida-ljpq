package com.example.escriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * View class for the Escritura Rapida game.
 * Loads the FXML file and sets up the main stage.
 *
 * @author Lissette Johana Patiño 2520977
 * @version 1.0
 */
public class GameView {

    /**
     * Creates and displays the main game window.
     * @param stage the primary stage provided by JavaFX.
     * @throws IOException if the FXML file cannot be loaded.
     */
    public GameView(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("/com/example/escriturarapida/game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Escritura Rápida");
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.show();
    }
}