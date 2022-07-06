package pl.com.zbijak;

import java.util.ArrayList;

public class ZbijakGame {
    public static void main(String[] args) {
        //tworzymy planszę, użytkowników oraz wrogów - Komputer
        Plansza plansza = new Plansza();
        User user = new User();
        ArrayList<ComputerPlayer> players = new ArrayList<>();
        players.add(new ComputerPlayer());
        players.add(new ComputerPlayer());
        players.add(new ComputerPlayer());

        //dodajemy wszystkich do jednego wora żeby wylosować pozycje początkowe
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.add(user);
        for (Player player :
                players) {
            allPlayers.add(player);
        }

        //losujemy pozycje
        ZbijakGame.drawStartPositions(plansza, allPlayers);

        //gramy
        while (players.size() != 0) {
            System.out.println("------------------------------------------");
            plansza.showPlasza(plansza.tablica);
            ZbijakGame.makeUserMove(user, plansza.tablica, players);
            if (players.size() == 0) continue;
            plansza.showPlasza(plansza.tablica);
            ZbijakGame.makeUserMove(user, plansza.tablica, players);
            ZbijakGame.makeMoves(players, plansza.tablica, players);
        }
        System.out.println("Udało się!! Zrobiłeś " + Plansza.totalCount +
                " posunięć i zabiłeś " + User.countKills + " wrogów!");
    }

    static void makeMoves(ArrayList<ComputerPlayer> players, Player[][] tablica, ArrayList<ComputerPlayer> players2) {
        for (Player player : players) {
            player.makeMove(tablica, players2);
        }
    }

    static void makeUserMove(User user, Player[][] tablica, ArrayList<ComputerPlayer> players) {
        user.makeMove(tablica, players);
    }

    static void drawStartPositions(Plansza plansza, ArrayList<Player> players) {
        for (Player player : players) {
            plansza.tablica = plansza.drawPositionToStart(plansza.tablica, player);
        }

    }

}