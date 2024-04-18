package question2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Person;

public class Q2Execute {
    private static final String FILE_PATH = "app/src/main/resources/peopleData.csv";

    public static void main(String[] args) {
        List<Person> peopleList = loadPeopleData(FILE_PATH);
        // 確認のために読み込んだデータを出力
        printNumberWithCigarette(peopleList);
    }

    public static List<Person> loadPeopleData(String filePath) {
        List<Person> peopleList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // ヘッダー行のスキップ
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String country = data[2];
                String city = data[3];
                String food = data[4];
                List<String> items = new ArrayList<>();
                // Item1から始まる列（インデックス5）以降をリストに追加
                for (int i = 5; i < data.length; i++) {
                    items.add(data[i]);
                }
                peopleList.add(new Person(name, age, country, city, food, items));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peopleList;
    }

    public static void removeAndOutputNames(List<Person> peopleList) {
        List<Person> removedList = new ArrayList<>(peopleList);
        removedList.subList(54, 85).clear();
        removedList.subList(9, 45).clear();
        removedList.forEach(person -> System.out.println(person.getName()));
    }

    public static void printFormattedPeopleList(List<Person> peopleList) {
        peopleList.stream()
                .limit(25)
                .map(person -> {
                    if (person.getCountry().equals("USA")) {
                        person.setCountry("America");
                    }
                    return person;
                })
                .forEach(person -> System.out.println(person.getName() + " was born in " + person.getCountry()));
    }

    public static void printNamesWithBook(List<Person> peopleList) {
        peopleList.stream()
                .filter(person -> person.getItems().contains("Book"))
                .map(person -> person.getName())
                .distinct()
                .forEach(name -> System.out.println(name));
    }

    public static void printNumberWithCigarette(List<Person> peopleList) {
        List<Person> peopleWithCigarette = peopleList.stream()
                .filter(person -> person.getItems().contains("Cigarette"))
                .collect(Collectors.toList());
        System.out.println("There are " + peopleWithCigarette.size() + " smokers.");
    }
}