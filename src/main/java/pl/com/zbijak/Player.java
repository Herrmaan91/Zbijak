package pl.com.zbijak;

import java.util.ArrayList;

public abstract class Player {

    int x;
    int y;

    abstract void makeMove(Player[][] plansza, ArrayList<ComputerPlayer> players);
}
