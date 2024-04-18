package question6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FisherYatesShuffle {
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

        String[] answers = {
            "3", // Flour
            "2", // Japan
            "2", // United Kingdom
            "2", // Nile River
            "3", // Himalayas
            "3"  // Canberra
        };


        // シャッフル用のインデックス配列
        int[] orders = new int[questions.length];
        for (int i = 0; i < questions.length; i++) {
            orders[i] = i;
        }

        // フィッシャー・イェーツアルゴリズムでシャッフルする
        Random random = new Random();
        for (int i = orders.length - 1; i > 0; i--) {
            int rNum = random.nextInt(i + 1);
            int temp = orders[i];
            orders[i] = orders[rNum];
            orders[rNum] = temp;
        }

        boolean[] correctAnswers = new boolean[questions.length];
        int score = 0;
        // 質問番号
        int questionCount = 0;
        // シャッフル用のインデックスを利用する
        for (int index : orders) {
            // 質問番号のカウントアップ
            questionCount++;
            System.out.println("Question " + questionCount + ": " + questions[index]);

            for (String option : options[index]) {
                System.out.println(option);
            }

            System.out.print("Please enter the number of your answer: ");
            String userAnswer = reader.readLine();

            // ユーザーの回答が正解かどうかをチェック
            if (userAnswer.equals(answers[index])) {
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
                System.out.println("Correct answer: " + options[i][Integer.parseInt(answers[i]) - 1]);
            }
        }
    }
}