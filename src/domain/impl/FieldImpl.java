package domain.impl;

import domain.Field;

import java.util.Random;

public class FieldImpl implements Field {
    private char[][] field;

    private final int width = 30;
    private final int height = 16;
    private final int mines = 99;

    public FieldImpl() {
        field = new char[height][width];
        createField();
    }

    private void createField() {
        Random r = new Random();
        int tmp = 0;
        while (tmp < mines) {
            int x = r.nextInt(height);
            int y = r.nextInt(width);
            if (field[x][y] != '*') {
                field[x][y] = '*';
                tmp++;
            }
        }
        createNumbers();
    }

    private void createNumbers() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] != '*') {

                    int count = 0;
                    for (int p = i - 1; p <= i + 1; p++) {
                        for (int q = j - 1; q <= j + 1; q++) {
                            if (0 <= p && p < field.length && 0 <= q && q < field[0].length) {
                                if (field[p][q] == '*')
                                    count++;
                            }
                        }
                    }
                    if (count > 0) {
                        field[i][j] = (char) (count + '0');
                    } else {
                        field[i][j] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void guessOn(int x, int y) {
        if (field[x][y] == '*') {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("You lost.");
    }

    @Override
    public char[][] getField() {
        return field;
    }
}
