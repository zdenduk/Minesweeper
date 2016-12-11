package domain.impl;

import domain.Field;
import domain.FieldType;

import java.util.Random;

public class FieldImpl implements Field {
    private FieldType[][] field;

    public FieldImpl(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be bigger than 0.");
        }
        field = new FieldType[size][size];
        createField();
    }

    private void createField() {
        Random r = new Random();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                boolean bomb = r.nextBoolean();
                if (bomb) {
                    field[i][j] = FieldType.BOMB;
                } else {
                    field[i][j] = FieldType.CLEAR;
                }
            }
        }
    }

    @Override
    public void guessOn(int x, int y) {
        if (field[x][y] == FieldType.BOMB) {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("You lost.");
    }

    @Override
    public FieldType[][] getField() {
        return field;
    }
}
