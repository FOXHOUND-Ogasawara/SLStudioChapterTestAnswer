package question3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Person;

public class Q3Execute {

    private static final String FILE_PATH = "app/src/main/resources/peopleData.csv";
    private static final String EXPORT_PATH = "app/src/main/resources/exportData.csv";

    public static void main(String[] args) {
        List<Person> peopleList = loadPeopleData(FILE_PATH);
        // 確認のために読み込んだデータを出力
        Map<String, Map<String, Set<String>>> data = getCountryCityFoodMap(peopleList);
        writeMapToCSV(EXPORT_PATH, data);
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

    public static Set<String> getKyotoFavoriteFoods(List<Person> peopleList) {
        return peopleList.stream()
                .filter(person -> "Kyoto".equals(person.getCity()))
                .map(person -> person.getFood())
                .collect(Collectors.toSet());
    }

    public static Map<String, Set<String>> getCityFoodMap(List<Person> peopleList) {
        Map<String, Set<String>> cityFoodMap = new HashMap<>();
        for (Person person : peopleList) {
            String city = person.getCity();
            String food = person.getFood();
            if (!cityFoodMap.containsKey(city)) {
                cityFoodMap.put(city, new HashSet<>());
            }
            cityFoodMap.get(city).add(food);
        }
        return cityFoodMap;
    }

    public static Map<String, Map<String, Set<String>>> getCountryCityFoodMap(List<Person> peopleList) {
        Map<String, Map<String, Set<String>>> countryCityFoodMap = new HashMap<>();
        peopleList.stream()
                .map(people -> people.getCountry())
                .distinct()
                .forEach(country -> {
                    List<Person> peopleInCountry = peopleList.stream()
                            .filter(person -> person.getCountry().equals(country))
                            .collect(Collectors.toList());
                    countryCityFoodMap.put(country, getCityFoodMap(peopleInCountry));
                });
        return countryCityFoodMap;
    }

    public static void writeMapToCSV(String exportFilename,
            Map<String, Map<String, Set<String>>> countryCityFoodMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(exportFilename))) {
            writer.write("Country,City,Food1,Food2,Food3\n");

            for (String country : countryCityFoodMap.keySet()) {
                Map<String, Set<String>> cityFoodMap = countryCityFoodMap.get(country);

                for (String city : cityFoodMap.keySet()) {
                    List<String> foodList = new ArrayList<>(cityFoodMap.get(city));

                    String food1 = "";
                    String food2 = "";
                    String food3 = "";

                    if (foodList.size() > 2) {
                        food1 = foodList.get(0);
                        food2 = foodList.get(1);
                        food3 = foodList.get(2);
                    } else if (foodList.size() == 1) {
                        food1 = foodList.get(0);
                    } else if (foodList.size() == 2) {
                        food1 = foodList.get(0);
                        food2 = foodList.get(1);
                    }

                    String foods = food1 + "," + food2 + "," + food3;

                    writer.write(country + "," + city + "," + foods + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}