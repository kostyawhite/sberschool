package ru.sber.e3;

import java.io.*;

public class Clone {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person(23, "John");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(person);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Person clonePerson = (Person) ois.readObject();
        System.out.println(person);
        System.out.println(clonePerson);
        System.out.println(person == clonePerson);
        System.out.println(person.equals(clonePerson));
    }

}
