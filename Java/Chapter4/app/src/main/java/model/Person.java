package model;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String country;
    private String city;
    private String food;
    private List<String> items;

    public Person(String name, int age, String country, String city, String food, List<String> items) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.city = city;
        this.food = food;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getFood() {
        return food;
    }

    public List<String> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}