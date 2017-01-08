import domain.Field;
import domain.impl.FieldImpl;
import ui.GameUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Field playingField = new FieldImpl();
        GameUI gameUI = new GameUI();
        gameUI.play(playingField);
    }
}
