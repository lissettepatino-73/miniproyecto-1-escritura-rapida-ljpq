package com.example.escriturarapida.controller;

import com.example.escriturarapida.model.GameModel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 * Controller for the Escritura Rapida game.
 * Manages user interaction and updates the view based on the model.
 *
 * @author Lissette Johana Patiño 2520977
 * @version 1.0
 */
public class GameController {

    /** Label that displays the current level number. */
    @FXML private Label levelLabel;

    /** Label that displays the remaining time. */
    @FXML private Label timerLabel;

    /** Label that displays the word the player must type. */
    @FXML private Label wordLabel;

    /** Label that displays feedback messages to the player. */
    @FXML private Label messageLabel;

    /** Text field where the player types their answer. */
    @FXML private TextField inputField;

    /** Button to start the game or validate the answer. */
    @FXML private Button actionButton;

    /** Game model containing data and logic. */
    private GameModel model = new GameModel();

    /** Timeline object used for the countdown timer. */
    private Timeline timer;

    /**
     * Handles the main action button click event.
     * Starts the game if not running, or validates the answer if running.
     */
    @FXML
    private void onActionButtonClick() {
        if (!model.isGameRunning()) {
            startGame();
        } else {
            validateAnswer();
        }
    }

    /**
     * Starts a new game session from level 1.
     * Resets the model and begins the first level.
     */
    private void startGame() {
        model.reset();
        model.setGameRunning(true);
        actionButton.setText("Validar");
        startLevel();
    }

    /**
     * Sets up a new level with a word from the model and resets the timer.
     */
    private void startLevel() {
        model.setTimeLeft(model.calculateTime());
        levelLabel.setText("Nivel: " + model.getLevel());
        wordLabel.setText(model.getWord());
        inputField.clear();
        inputField.setDisable(false);
        inputField.requestFocus();
        inputField.setOnKeyPressed(new KeyboardHandler());
        messageLabel.setText("");
        startTimer();
    }

    /**
     * Starts the countdown timer for the current level.
     * Automatically validates the answer when time reaches zero.
     */
    private void startTimer() {
        if (timer != null) timer.stop();
        timerLabel.setText("⏱ " + model.getTimeLeft());
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            model.setTimeLeft(model.getTimeLeft() - 1);
            timerLabel.setText("⏱ " + model.getTimeLeft());
            if (model.getTimeLeft() <= 0) {
                timer.stop();
                messageLabel.setStyle("-fx-text-fill: #ff6b6b; -fx-font-size: 16;");
                messageLabel.setText("⏱ ¡Tiempo agotado! Niveles completados: " + (model.getLevel() - 1));
                inputField.setDisable(true);
                model.setGameRunning(false);
                actionButton.setText("Iniciar juego");
                levelLabel.setText("Nivel: 1");
                wordLabel.setText("Esperando...");
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    /**
     * Validates the player's typed answer against the displayed word.
     * Advances to the next level if correct, or shows error if incorrect.
     * Comparison is case-sensitive and exact.
     */
    private void validateAnswer() {
        if (timer != null) timer.stop();
        String input = inputField.getText();
        String word = wordLabel.getText();

        if (input.equals(word)) {
            messageLabel.setStyle("-fx-text-fill: #00ff88; -fx-font-size: 16;");
            messageLabel.setText("¡Correcto! ¡Nivel superado!");
            model.setLevel(model.getLevel() + 1);
            if (model.getLevel() > 45) {
                messageLabel.setStyle("-fx-text-fill: #00ff88; -fx-font-size: 16;");
                messageLabel.setText("🏆 ¡Felicidades! ¡Completaste los 45 niveles!");
                inputField.setDisable(true);
                model.setGameRunning(false);
                actionButton.setText("Iniciar juego");
                wordLabel.setText("¡GANASTE!");
            } else {
                startLevel();
            }
        } else {
            messageLabel.setStyle("-fx-text-fill: #ff6b6b; -fx-font-size: 16;");
            messageLabel.setText("Incorrecto, intenta de nuevo.");
            inputField.clear();
            inputField.requestFocus();
            startTimer();
        }
    }

    /**
     * Inner adapter class that handles keyboard events for the input field.
     * Only responds to the ENTER key to validate the answer.
     */
    private class KeyboardHandler implements EventHandler<KeyEvent> {

        /**
         * Handles the key pressed event.
         * @param e the key event triggered by the user.
         */
        @Override
        public void handle(KeyEvent e) {
            if (e.getCode().toString().equals("ENTER")) {
                validateAnswer();
            }
        }
    }
}