package question7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FlexiQuiz {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] questions = {
            "What is the main ingredient in traditional Italian pizza dough?",
            "Which country is known for inventing sushi?",
            "In which country did the sandwich originate?",
            "What is the longest river in the world?",
            "Mount Everest is located in which mountain range?",
            "What is the capital city of Australia?"
        };

        String[][] options = {
            {"1: Water", "2: Yeast", "3: Flour", "4: Salt"},
            {"1: China", "2: Japan", "3: Korea", "4: Vietnam"},
            {"1: Germany", "2: United Kingdom", "3: USA", "4: Italy"},
            {"1: Amazon River", "2: Nile River", "3: Yangtze River", "4: Mississippi River"},
            {"1: Andes", "2: Rockies", "3: Himalayas", "4: Alps"},
            {"1: Sydney", "2: Melbourne", "3: Canberra", "4: Brisbane"}
        };

        // 正解のジャグ配列
        String[][] answers = {
            {"3: Flour", "3", "Flour", "flour", "Wheat Flour"},
            {"2: Japan", "2", "Japan", "japan", "Nihon", "Nippon"},
            {"2: United Kingdom", "2", "United Kingdom", "UK", "Britain"},
            {"2: Nile River", "2", "Nile River", "Nile"},
            {"3: Himalayas", "3", "Himalayas", "Himalaya Mountains"},
            {"3: Canberra", "3", "Canberra", "canberra"}
        };

        int[] orders = new int[questions.length];
        for (int i = 0; i < questions.length; i++) {
            orders[i] = i;
        }

        Random random = new Random();
        for (int i = orders.length - 1; i > 0; i--) {
            int rNum = random.nextInt(i + 1);
            int temp = orders[i];
            orders[i] = orders[rNum];
            orders[rNum] = temp;
        }

        boolean[] correctAnswers = new boolean[questions.length];
        int score = 0;
        int questionCount = 0;
        for (int index : orders) {
            questionCount++;
            System.out.println("Question " + questionCount + ": " + questions[index]);

            // 選択肢の表示
            for (String option : options[index]) {
                System.out.println(option);
            }

            // 出力内容の修正
            System.out.print("Please enter your answer: ");
            String userAnswer = reader.readLine();

            // ジャグ配列をループして正解かチェックする
            boolean correct = false;
            for (String possibleAnswer : answers[index]) {
                if (userAnswer.equals(possibleAnswer)) {
                    correct = true;
                    break;
                }
            }
            // チェックした結果で分岐するように修正する
            if (correct) {
                System.out.println("Correct!");
                score++;
                correctAnswers[index] = true;
            } else {
                System.out.println("Incorrect.");
                correctAnswers[index] = false;
            }
        }

        // スコア表示
        System.out.println("Your score is: " + score);

        // 不正解だった質問と正解の出力
        System.out.println("Review the incorrect answers:");
        for (int i = 0; i < correctAnswers.length; i++) {
            if (!correctAnswers[i]) {
                System.out.println("Question: " + questions[i]);
                // 出力内容の修正
                System.out.println("Correct answer: " + answers[i][0]);
            }
        }
    }
}