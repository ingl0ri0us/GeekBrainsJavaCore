package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Contacts {

    private static HashMap <String, HashSet<String>> contacts = new HashMap<>();

    public static void main(String[] args) {
        addContact("Petrov", "+79261112233");
        addContact("Petrov", "+79261112233");
        addContact("Petrov", "+79261112233");
        addContact("Ivanov", "+79261115566");
        addContact("Sidorov", "+79261112233");
        addContact("Petrov", "+79031455566");
        addContact("Petrov", "+79261112233");
        addContact("Galkin", "+79261112233");
        addContact("Galkin", "+79261112234");
        addContact("Galkin", "+79261112234");

        getContact("Petrov");
        getContact("Ivanov");
        getContact("Galkin");
        getContact("Sidorov");
    }

    private static void getContact(String contact) {
        System.out.println(contact + " : " + contacts.get(contact));
    }

    private static void addContact(String name, String number) {
        HashSet<String> numbers = new HashSet<>();

        if(contacts.containsKey(name)) {
            numbers = contacts.get(name);
            numbers.add(number);
            contacts.put(name, numbers);
        } else {
            numbers.add(number);
            contacts.put(name, numbers);
        }
    }
}
