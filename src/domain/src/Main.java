import domain.Field;
import domain.impl.FieldImpl;
import ui.GameUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Field playingField = new FieldImpl();
        GameUI gameUI = new GameUI();
        gameUI.play(playingField);
    }
}
