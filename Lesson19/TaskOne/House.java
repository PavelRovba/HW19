package com.company.Lesson19.TaskOne;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class House {
    public int houseNumber = 2;
    public int countRooms = 4;
    private int numberOfResidents = 10;
    private String houseName = "Hotel-motel";

    @Override
    public String toString() {
        return "House{" +
                "houseNumber=" + houseNumber +
                ", countRooms=" + countRooms +
                ", numberOfResidents=" + numberOfResidents +
                ", houseName='" + houseName + '\'' +
                '}';
    }

    public String getHouseName() {
        return "House name is " + houseName;
    }

    private void addNewResident() {
        this.numberOfResidents++;
    }

    private void setCountRoomsAndNumberOfResidents(int countRooms, int numberOfResidents) {
        this.countRooms = countRooms;
        this.numberOfResidents = numberOfResidents;
    }

    public void printFieldsAndMethods() {
        Field[] fields = House.class.getDeclaredFields();
        Method[] methods = House.class.getDeclaredMethods();
        System.out.println("Fields: " + Arrays.toString(fields) + "\nMethods: " + Arrays.toString(methods));
    }

    public void printFieldsValues() throws IllegalAccessException {
        Field[] fields = House.class.getDeclaredFields();
        System.out.println("Field values :");
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.get(this));
        }
    }

    public void invokeMethods() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = House.class.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.getName().equals("setCountRoomsAndNumberOfResidents")) {
                System.out.println(method.getName());
                method.invoke(this, 6, 12);
            } else if (method.getName().equals("invokeMethods")) {
                System.out.println(method.getName());
                System.out.println("Can't run this method again");

            } else {
                System.out.println(method.getName());
                method.invoke(this);
            }

        }

    }
}
