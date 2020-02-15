package me.buck.bigbrother;

import io.objectbox.converter.PropertyConverter;

public class EnumConverter implements PropertyConverter<EmLock, String> {


    @Override
    public EmLock convertToEntityProperty(String databaseValue) {
        return EmLock.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(EmLock entityProperty) {
        return entityProperty.name();
    }
}
