package domain;

import domain.impl.FieldTypeImpl;

public interface Field {
    void guessOn(int x, int y);

    FieldTypeImpl[][] getField();

    int getMines();

    void flag(int x, int y);

    int getFlagedMines();
}
