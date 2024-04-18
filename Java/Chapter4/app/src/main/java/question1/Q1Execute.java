package question1;

import java.util.List;

import model.Person;

public class Q1Execute {

    public static void main(String[] args) {
        List<Person> peopleList = List.of(
                new Person("Allice", 18, "France", "Paris", "Macaron", List.of("Key", "Phone", "Card")),
                new Person("Benjamin", 69, "Canada", "Montreal", "Bagel", List.of("Cigarette", "Wallet", "Book")),
                new Person("Chiara", 32, "Italy", "Rome", "Carbonara", List.of("Glasses", "Book", "Card")));

        peopleList.stream()
                .filter(person -> person.getAge() >= 30)
                .forEach(person -> System.out.println(person.getName() + ", " + person.getAge() + " years old"));

    }

}