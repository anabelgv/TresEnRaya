import motor3R.TresEnRaya;

import java.util.Scanner;

public class IntConsola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TresEnRaya tresEnRaya = new TresEnRaya();
        char jugadorActual = 'X';

        while (true) {
            imprimirTablero(tresEnRaya);

            // Turno del jugador
            if (jugadorActual == 'X') {
                System.out.println("Turno del jugador " + jugadorActual);
                System.out.println("Inserta las coordenadas");
                System.out.print("Eje x: ");
                int x = scanner.nextInt();
                System.out.print("Eje y: ");
                int y = scanner.nextInt();

                boolean movimientoValido = tresEnRaya.realizarMovimiento(x, y, String.valueOf(jugadorActual));
                if (!movimientoValido) {
                    System.out.println("Movimiento inválido, elige otra casilla.");
                    continue;
                }
            } else { // Turno  máquina
                System.out.println("Turno de la máquina:");
                tresEnRaya.realizarMovimientoMaquina(String.valueOf(jugadorActual));
            }

            // Verificar si hay un empate
            String resultado = tresEnRaya.hayGanador();
            if (resultado != null) {
                System.out.println(resultado);
                break;
            }

            // Cambiar jugador
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }

        // Mostrar tablero final
        imprimirTablero(tresEnRaya);
        System.out.println("Juego terminado.");
    }

    private static void imprimirTablero(TresEnRaya tresEnRaya) {
        String[][] tablero = tresEnRaya.getTablero();
        for (String[] fila : tablero) {
            for (String casilla : fila) {
                System.out.print(casilla);
            }
            System.out.println();
        }
    }
}
