package com.company.Lesson19.TaskOne;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        House house = House.class.getConstructor().newInstance();
        System.out.println(house.getHouseName());
        house.printFieldsAndMethods();
        house.printFieldsValues();
        house.invokeMethods();
    }
}
