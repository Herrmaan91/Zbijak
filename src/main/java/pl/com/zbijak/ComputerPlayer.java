package pl.com.zbijak;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    static int idGLOB = 1;
    int id = 1;
    ComputerPlayer() {
        this.id = idGLOB;
        idGLOB++;
    }

    @Override
    void makeMove(Player[][] plansza, ArrayList<ComputerPlayer> players) {
        Random r = new Random();
        boolean continuing = true;
        while (continuing) {
            int moveDirection = r.nextInt(4);

            //move up
            if (moveDirection == 0) {
                if (this.x - 1 < 0) continue;
                else if (plansza[this.x - 1][this.y] != null) continue;
                else {
                    plansza[this.x][this.y] = null;
                    this.x--;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                }
            }

            //move right
            if (moveDirection == 1) {
                if (this.y + 1 > 9) continue;
                else if (plansza[this.x][this.y + 1] != null) continue;
                else {
                    plansza[this.x][this.y] = null;
                    this.y++;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                }
            }
            //move left
            if (moveDirection == 2) {
                if (this.y - 1 < 0) continue;
                else if (plansza[this.x][this.y - 1] != null) continue;
                else {
                    plansza[this.x][this.y] = null;
                    this.y--;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                }
            }
            //move down
            if (moveDirection == 3) {
                if (this.x + 1 > 9) continue;
                else if (plansza[this.x + 1][this.y] != null) continue;
                else {
                    plansza[this.x][this.y] = null;
                    this.x++;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                }
            }

        }
    }

    @Override
    public String toString() {
        return "C" + id + x + y;
    }
}
