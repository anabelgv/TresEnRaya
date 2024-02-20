package motor3R;

import java.util.Random;

public class TresEnRaya {
    private String[][] tablero = {
            {"|_", "|_", "|_"},
            {"|_", "|_", "|_"},
            {"|_", "|_", "|_"}
    };

    public String[][] getTablero() {
        return tablero;
    }

    /** 
     * Método  movimiento del jugador*/
    public boolean realizarMovimiento(int fila, int columna, String jugador) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna].equals("|_")) {
            tablero[fila][columna] = "|" + jugador;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método máquina realice un movimiento*/
    public void realizarMovimientoMaquina(String jugadorMaquina) {
        Random random = new Random();
        int fila, columna;

        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!tablero[fila][columna].equals("|_"));

        tablero[fila][columna] = "|" + jugadorMaquina;
    }
    /** 
     *  Método para verificar empate*/
    public String hayGanador() {
        /** 
         *  Verificar filas y columnas */
        for (int i = 0; i < 3; i++) {
            /**
             *  Filas*/
            if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]) && !tablero[i][0].equals("|_")) {
                return "¡El jugador " + tablero[i][0].charAt(1) + " ha ganado!";
            }
            /** 
             *  Columnas */
            if (tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i]) && !tablero[0][i].equals("|_")) {
                return "¡El jugador " + tablero[0][i].charAt(1) + " ha ganado!";
            }
        }
        /** 
         * Verificar diagonales*/
        if ((tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2])) ||
                (tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]))) {
            if (!tablero[1][1].equals("|_")) {
                return "¡El jugador " + tablero[1][1].charAt(1) + " ha ganado!";
            }
        }
        /**
         *   Verificar  tablero  lleno (empate)*/
        boolean tableroLleno = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("|_")) {
                    tableroLleno = false;
                    break;
                }
            }
            if (!tableroLleno) {
                break;
            }
        }
        if (tableroLleno) {
            return "¡El juego ha terminado en empate!";
        }
        /** 
         *  no hay ganador ni empate */
        return null;
    }
}

