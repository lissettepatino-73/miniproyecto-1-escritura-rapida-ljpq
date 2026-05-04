package com.example.escriturarapida;

import com.example.escriturarapida.view.GameView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Main entry point for the Escritura Rapida application.
 *
 * @author Lissette Johana Patiño 2520977
 * @version 1.0
 */
public class Main extends Application {

    /**
     * Launches the JavaFX application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates and displays the main game view.
     * @param stage the primary stage provided by JavaFX.
     * @throws IOException if the FXML file cannot be loaded.
     */
    @Override
    public void start(Stage stage) throws IOException {
        new GameView(stage);
    }
}