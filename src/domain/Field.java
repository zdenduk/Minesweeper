package domain;

public interface Field {
    void guessOn(int x, int y);

    FieldType[][] getField();
}
