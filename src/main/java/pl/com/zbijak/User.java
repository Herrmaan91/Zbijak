package pl.com.zbijak;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends Player {
    static int countKills = 0;
    User(){

    }
    @Override
    void makeMove(Player[][] plansza, ArrayList<ComputerPlayer> players) {
        Scanner s = new Scanner(System.in);
        boolean continuing = true;
        while (continuing) {
            System.out.println("Podaj kierunek w którym chcesz się poruszyć: \n" +
                    "w - do góry \n" +
                    "s - w dół \n" +
                    "a - w lewo \n" +
                    "d - w prawo");
            String moveDirection = s.nextLine();

            //move up
            if (moveDirection.toLowerCase().equals("w")) {
                if (this.x - 1 < 0) {
                    System.out.println("Wyjście poza zakres...");
                    continue;
                }
                else if (plansza[this.x - 1][this.y] instanceof ComputerPlayer) {
                    players.remove(plansza[this.x - 1][this.y]);
                    plansza[this.x][this.y] = null;
                    countKills++;
                    this.x--;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
                else {
                    plansza[this.x][this.y] = null;
                    this.x--;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
            }

            //move right
            else if (moveDirection.toLowerCase().equals("d")) {
                if (this.y + 1 > 9) {
                    System.out.println("Wyjście poza zakres...");
                    continue;
                }
                else if (plansza[this.x][this.y + 1] instanceof ComputerPlayer) {
                    players.remove(plansza[this.x][this.y + 1]);
                    plansza[this.x][this.y] = null;
                    countKills++;
                    this.y++;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
                else {
                    plansza[this.x][this.y] = null;
                    this.y++;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
            }
            //move left
            else if (moveDirection.toLowerCase().equals("a")) {
                if (this.y - 1 < 0) {
                    System.out.println("Wyjście poza zakres...");
                    continue;
                }
                else if (plansza[this.x][this.y - 1] instanceof ComputerPlayer) {
                    players.remove(plansza[this.x][this.y - 1]);
                    plansza[this.x][this.y] = null;
                    countKills++;
                    this.y--;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
                else {
                    plansza[this.x][this.y] = null;
                    this.y--;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
            }
            //move down
            else if (moveDirection.toLowerCase().equals("s")) {
                if (this.x + 1 > 9) {
                    System.out.println("Wyjście poza zakres...");
                    continue;
                }
                else if (plansza[this.x + 1][this.y] instanceof ComputerPlayer) {
                    players.remove(plansza[this.x + 1][this.y]);
                    plansza[this.x][this.y] = null;
                    countKills++;
                    this.x++;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
                else {
                    plansza[this.x][this.y] = null;
                    this.x++;
                    plansza[this.x][this.y] = this;
                    continuing = false;
                    Plansza.totalCount++;
                }
            }
            else System.out.println("Błędny wybór! Spróbuj jeszcze raz... ");

        }
    }

    @Override
    public String toString() {
        return "U " + x + y;
    }
}
