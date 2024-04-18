package question1;

import java.util.Arrays;

/**
 * Personクラスの動作確認用クラス
 */

import model.Person;

public class Q1PersonTest {
    public static void main(String[] args) {
        System.out.println("--- コンストラクタ・getterのテスト結果 ---");
        Person person = new Person("ichiro", 11, "USA", "Chicago", "Pizza",
            Arrays.asList("Phone", "Book"));
        printPerson(person);
        System.out.println("------" + "\n");

        System.out.println("--- setterのテスト結果 ---");
        person.setName("Jiro");
        person.setAge(12);
        person.setCountry("Japan");
        person.setCity("Tokyo");
        person.setFood("Sushi");
        person.setItems(Arrays.asList("Card", "Phone"));
        printPerson(person);
        System.out.println("------" + "\n");
    }

    /**
     * 表示確認用
     * @param person
     */
    private static void printPerson(Person person) {
        String items = "";
        for (String item : person.getItems()) {
            items += item + ", ";
        }
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", Country: " + person.getCountry()
                + ", City: " + person.getCity() + ", Food: " + person.getFood() + ", Items: " + items);
    }
}
