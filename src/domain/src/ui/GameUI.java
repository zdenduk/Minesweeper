package ui;

import domain.Field;

public class GameUI {
    public static void play(Field field){
        printField(field);
    }

    private static void printField(Field field){
        for (int i = 0; i < field.getField().length; i++) {
            System.out.print("|");
            for (int j = 0; j < field.getField()[0].length; j++) {
                System.out.print("0|");
                /*System.out.print(field.getField()[i][j]+"|");*/
            }
            System.out.println();
        }
    }
}
