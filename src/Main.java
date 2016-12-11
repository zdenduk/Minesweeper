import domain.Field;
import domain.impl.FieldImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter difficulty:");
        Field playingField = new FieldImpl();
        /*for (int i = 0; i < playingField.getField().length; i++) {
            for (int j = 0; j < playingField.getField()[0].length; j++) {
                System.out.print(playingField.getField()[i][j]);
            }
            System.out.println();
        }*/
    }
}
