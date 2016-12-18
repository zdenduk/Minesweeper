package domain.impl;

import domain.Field;
import domain.FieldType;

import java.util.Random;

public class FieldImpl implements Field {
    private FieldTypeImpl[][] field;

    private final int width = 10;
    private final int height = 10;
    private final int mines = 10;

    public FieldImpl() {
        field = new FieldTypeImpl[height][width];
        createField();
    }

    private void createField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new FieldTypeImpl(FieldType.CLEAR, 0);
            }
        }
        Random r = new Random();
        int tmp = 0;
        while (tmp < mines) {
            int x = r.nextInt(height);
            int y = r.nextInt(width);
            if (!field[x][y].getFieldType().equals(FieldType.BOMB)) {
                field[x][y].setFieldType(FieldType.BOMB);
                tmp++;
            }
        }
        createNumbers();
    }


    private void createNumbers() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].getFieldType().equals(FieldType.BOMB)) {
                    int count = countMines(i, j);
                    setNumbers(i, j, count);
                }
            }
        }
    }

    private void setNumbers(int i, int j, int count) {
        field[i][j].setNumber(count);
    }

    private int countMines(int i, int j) {
        int count = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (0 <= k && k < field.length && 0 <= l && l < field[0].length) {
                    if (field[k][l].getFieldType().equals(FieldType.BOMB))
                        count++;
                }
            }
        }
        return count;
    }

    @Override
    public void guessOn(int x, int y) {
        if (field[x][y].getFieldType().equals(FieldType.BOMB)) {
            gameOver();
        } else {
            reveal(x, y);
        }
    }

    private void reveal(int x, int y) {
        System.out.println(field[x][y].getFieldType());
        System.out.println(field[x][y].getNumber());
        if (x < 0 || x > field.length || y < 0 || y > field[0].length) return;
        if (field[x][y].getNumber() == 0 && !field[x][y].equals(FieldType.CLEARED)) {
            field[x][y].setFieldType(FieldType.CLEARED);
            reveal(x + 1, y);
            reveal(x - 1, y);
            reveal(x, y - 1);
            reveal(x, y + 1);
        } else {
            return;
        }
    }

    private void gameOver() {
        System.out.println("You lost.");
    }

    @Override
    public FieldTypeImpl[][] getField() {
        return field;
    }
}
