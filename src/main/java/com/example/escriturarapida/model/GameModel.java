package com.example.escriturarapida.model;

/**
 * Model class for the Escritura Rapida game.
 * Contains game data such as words, level, and time.
 *
 * @author Lissette Johana Patiño 2520977
 * @version 1.0
 */
public class GameModel {

    /** Words for levels 1 to 15 (easy). */
    private final String[] easyWords = {
            "Casa", "Perro", "Gato", "Mesa", "Libro",
            "Agua", "Sol", "Luna", "Árbol", "Flor",
            "Mar", "Pan", "Luz", "Voz", "Pie","Corazón",
            "Niño", "Puerta", "Piedra", "Noche", "Tierra",
            "Fuego", "Viento", "Cielo", "Río", "Pájaro", "Estrella",
            "Silla", "Cama", "Pez", "Ojo", "Clase"
    };

    /** Words for levels 16 to 30 (medium). */
    private final String[] mediumWords = {
            "Teclado", "Pantalla", "Computador", "Programar", "Interfaz",
            "Variable", "Método", "Proyecto", "Algoritmo", "Función",
            "Biblioteca", "Compilador", "Depurador", "Estructura", "Herencia",
            "Polimorfismo", "Encapsulación", "Abstracción", "Recursión", "Iteración",
            "Mariposa", "Montaña", "Calendario", "Diccionario", "Fotografía",
            "Electricidad", "Temperatura", "Geografía", "Matemática", "Filosofía"
    };

    /** Words for levels 31 to 45 (hard). */
    private final String[] hardWords = {
            "Murciélago", "Ferrocarril", "Hipopótamo", "Electrodoméstico", "Trigonometría",
            "Microorganismo", "Biodiversidad", "Extraordinario", "Incomprensible", "Anticuado",
            "Desenvolvimiento", "Escrupulosamente", "Contemporáneo", "Reminiscencia", "Circunferencia",
            "Onomatopeya", "Perpendicular", "Cinematografía", "Privilegiado", "Amalgama",
            "Esternocleidomastoideo", "Otorrinolaringólogo", "Electroencefalograma",
            "Psicopedagogía", "Descapotable", "Hipotenusa", "Fisioterapéutica",
            "Quirúrgicamente", "Desafortunadamente", "Incuestionable"
    };

    /** Current level. */
    private int level = 1;

    /** Remaining time in seconds. */
    private int timeLeft = 20;

    /** Indicates if the game is running. */
    private boolean gameRunning = false;

    /**
     * Returns a word based on the current level.
     * @return a word appropriate for the current level.
     */
    public String getWord() {
        if (level <= 15) {
            return easyWords[(int)(Math.random() * easyWords.length)];
        } else if (level <= 30) {
            return mediumWords[(int)(Math.random() * mediumWords.length)];
        } else {
            return hardWords[(int)(Math.random() * hardWords.length)];
        }
    }

    /**
     * Calculates time for the current level.
     * @return time in seconds.
     */
    public int calculateTime() {
        return Math.max(2, 20 - ((level - 1) / 5) * 2);
    }

    /** @return current level. */
    public int getLevel() { return level; }

    /** @param level the level to set. */
    public void setLevel(int level) { this.level = level; }

    /** @return remaining time. */
    public int getTimeLeft() { return timeLeft; }

    /** @param timeLeft the time to set. */
    public void setTimeLeft(int timeLeft) { this.timeLeft = timeLeft; }

    /** @return true if game is running. */
    public boolean isGameRunning() { return gameRunning; }

    /** @param gameRunning the state to set. */
    public void setGameRunning(boolean gameRunning) { this.gameRunning = gameRunning; }

    /** Resets the game to initial state. */
    public void reset() {
        level = 1;
        timeLeft = 20;
        gameRunning = false;
    }
}