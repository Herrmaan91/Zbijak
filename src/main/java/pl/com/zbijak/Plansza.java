package pl.com.zbijak;

import java.util.Arrays;
import java.util.Random;

public class Plansza {
    Player[][] tablica = new Player[10][10];
    static int totalCount = 0;

    Player[][] drawPositionToStart(Player[][] plansza, Player player) {
        Random r = new Random();
        boolean continuing = true;
        while (continuing) {
            int randomX = r.nextInt(plansza.length);
            int randomY = r.nextInt(plansza[randomX].length);
            if (plansza[randomX][randomY] == null) {
                plansza[randomX][randomY] = player;
                continuing = false;
                player.x = randomX;
                player.y = randomY;
            }
        }
        return plansza;
    }

    void showPlasza(Player[][] plansza){
        for (int i = 0; i < plansza.length; i++) {
            for (int j = 0; j < plansza[i].length; j++) {
                System.out.print(" " + plansza[i][j] + " ");
            }
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "Plansza{" +
                "tablica=" + Arrays.toString(tablica) +
                '}';
    }
}

