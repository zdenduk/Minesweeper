package ui;

import com.sun.javaws.exceptions.InvalidArgumentException;
import domain.Field;
import domain.FieldType;

import java.util.Scanner;

public class GameUI {
    public static void play(Field field) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            makeGuess(field, sc);
            printField(field);
        }
    }

    private static void makeGuess(Field field, Scanner sc) {
        System.out.println("Enter coordinates:");
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x > field.getField().length || x < 0 || y > field.getField()[0].length || y < 0){
            throw new IllegalArgumentException("You entered wrong arguments.");
        }
        field.guessOn(x, y);
    }

    private static void printField(Field field) {
        for (int i = 0; i < field.getField().length; i++) {
            System.out.print("|");
            for (int j = 0; j < field.getField()[0].length; j++) {
                if (field.getField()[i][j].getFieldType().equals(FieldType.CLEARED)) {
                    System.out.print("~|");
                } else {
                    System.out.print("0|");
                }
            }
            System.out.println();
        }
    }
}
