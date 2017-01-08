package ui;

import domain.Field;
import domain.FieldType;

import java.util.Scanner;

public class GameUI {
    public static void play(Field field) {
        Scanner sc = new Scanner(System.in);
        turn(field, sc);
        gameWon();
    }

    private static void turn(Field field, Scanner sc) {
        System.out.println("Guess - 1 | Flag - 2");
        int tmp = sc.nextInt();
        if (tmp == 1) {
            makeGuess(field, sc);
            printField(field);
        } else {
            flagBomb(field, sc);
        }
        if (field.getMines() == field.getFlagedMines()) {
            return;
        }
        turn(field, sc);
    }

    private static void flagBomb(Field field, Scanner sc) {
        System.out.println("Enter coordinates:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        field.flag(x,y);
    }

    private static void makeGuess(Field field, Scanner sc) {
        System.out.println("Enter coordinates:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x > field.getField().length || x < 0 || y > field.getField()[0].length || y < 0) {
            throw new IllegalArgumentException("You entered wrong arguments.");
        }
        field.guessOn(x, y);
    }

    private static void printField(Field field) {
        for (int i = 0; i < field.getField().length; i++) {
            System.out.print("|");
            for (int j = 0; j < field.getField()[0].length; j++) {
                if (field.getField()[i][j].getFieldType().equals(FieldType.CLEARED)) {
                    System.out.print(field.getField()[i][j].getNumber() + "|");
                } else {
                    System.out.print("X|");
                }
            }
            System.out.println();
        }
    }

    private static void gameWon() {
        System.out.println("You win!");
    }
}
