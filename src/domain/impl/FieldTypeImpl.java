package domain.impl;

import domain.Field;
import domain.FieldType;

public class FieldTypeImpl {
    FieldType fieldType;
    private int number;

    public FieldTypeImpl(FieldType fieldType, int number) {
        this.fieldType = fieldType;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
