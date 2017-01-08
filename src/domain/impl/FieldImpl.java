package domain.impl;

import domain.Field;
import domain.FieldType;

import java.util.Random;

public class FieldImpl implements Field {
    private FieldTypeImpl[][] field;

    private final int width = 10;
    private final int height = 10;
    private final int mines = 10;
    private int flagedMines = 0;

    public FieldImpl() {
        field = new FieldTypeImpl[height][width];
        createField();
    }

    private void createField() {
        fillWithClear();
        Random r = new Random();
        int tmp = 0;
        createMines(r, tmp);
        createNumbers();
    }

    private void fillWithClear() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = new FieldTypeImpl(FieldType.CLEAR, 0);
            }
        }
    }

    private void createMines(Random r, int tmp) {
        while (tmp < mines) {
            int x = r.nextInt(height);
            int y = r.nextInt(width);
            if (!field[x][y].getFieldType().equals(FieldType.BOMB)) {
                field[x][y].setFieldType(FieldType.BOMB);
                tmp++;
            }
        }
    }


    private void createNumbers() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].getFieldType().equals(FieldType.BOMB)) {
                    setNumbers(i, j, countMines(i, j));
                }
            }
        }
    }

    private void setNumbers(int i, int j, int count) {
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (0 <= k && k < field.length && 0 <= l && l < field[0].length) {
                    field[k][l].setNumber(count);
                }
            }
        }
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
        if (x < 0 || x > field.length - 1 || y < 0 || y > field.length - 1) return;
        if (field[x][y].getNumber() == 0 && !field[x][y].getFieldType().equals(FieldType.CLEARED)) {
            field[x][y].setFieldType(FieldType.CLEARED);
            revealAll(x, y);
        } else if (field[x][y].getNumber() != 0) {
            field[x][y].setFieldType(FieldType.CLEARED);
        } else {
            return;
        }
    }

    private void revealAll(int x, int y) {
        reveal(x + 1, y);
        reveal(x - 1, y);
        reveal(x, y - 1);
        reveal(x, y + 1);
    }

    private void gameOver() {
        System.out.println("You lost.");
        System.exit(0);
    }

    @Override
    public FieldTypeImpl[][] getField() {
        return field;
    }

    @Override
    public int getMines() {
        return mines;
    }

    @Override
    public void flag(int x, int y) {
        field[x][y].setFieldType(FieldType.FLAGED);
        flagedMines++;
    }

    @Override
    public int getFlagedMines() {
        return flagedMines;
    }
}
