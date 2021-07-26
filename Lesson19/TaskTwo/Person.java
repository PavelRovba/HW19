package com.company.Lesson19.TaskTwo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;

@SignCode(type = TYPE, id = 1)
public class Person {
    @SignCode(type = FIELD, id = 2)
    private String surname;
    @SignCode(type = FIELD, id = 3)
    private String name;
    @SignCode(type = FIELD, id = 4)
    private int yearOfBirth;

    @SignCode(type = CONSTRUCTOR, id = 5)
    public Person(@SignCode(type = PARAMETER, id = 6) String surname,@SignCode(type = PARAMETER, id = 7) String name,@SignCode(type = PARAMETER, id = 8) int yearOfBirth) {
        this.surname = surname;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    @SignCode(type = METHOD, id = 9)
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @SignCode(type = METHOD, id = 10)
    public void getAnnotationValues() {
        try {
            Class person = this.getClass();
            Class<SignCode> annotationClass = SignCode.class;
            Method[] method = person.getDeclaredMethods();
            SignCode methodAnnotation;
            for (int i = 0; i < method.length; i++) {
                methodAnnotation = method[i].getAnnotation(annotationClass);
                System.out.printf("Method annotation: %s, annotation id = %d%n", method[i].getName(), methodAnnotation.id());
            }
            Field[] field = person.getDeclaredFields();
            SignCode fieldAnnotation;
            for (int i = 0; i < field.length; i++) {
                fieldAnnotation = field[i].getAnnotation(annotationClass);
                System.out.printf("Field annotation: %s, annotation id = %d%n", field[i].getName(), fieldAnnotation.id());
            }
            SignCode packageAnnotation = person.getPackage().getAnnotation(annotationClass);
            System.out.println("Package annotation: " + person.getPackage() + "annotation id = " + packageAnnotation.id());
            Constructor<?> constructor = person.getConstructor(String.class, String.class, int.class);
            SignCode constructorAnnotation = constructor.getAnnotation(annotationClass);
            System.out.println("Constructor annotation: " + constructor.getName() + "annotation id = " + constructorAnnotation.id());
            Annotation[][] constructorParameterAnnotations = constructor.getParameterAnnotations();
            for (Annotation[] annotations : constructorParameterAnnotations) {
                for (Annotation constructorParameterAnnotation : annotations) {
                    if (constructorParameterAnnotation instanceof SignCode) {
                        SignCode parameterAnnotation = (SignCode) constructorParameterAnnotation;
                        System.out.println("Parameter from constructor "+constructor.getName()+ ", annotation id: "+ parameterAnnotation.id());
                    }
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
