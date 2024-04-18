package question5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleChoice {
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

        // 4択の選択肢を追加
        String[][] options = {
            {"1: Water", "2: Yeast", "3: Flour", "4: Salt"},
            {"1: China", "2: Japan", "3: Korea", "4: Vietnam"},
            {"1: Germany", "2: United Kingdom", "3: USA", "4: Italy"},
            {"1: Amazon River", "2: Nile River", "3: Yangtze River", "4: Mississippi River"},
            {"1: Andes", "2: Rockies", "3: Himalayas", "4: Alps"},
            {"1: Sydney", "2: Melbourne", "3: Canberra", "4: Brisbane"}
        };

        // 正解の番号を設定
        String[] answers = {
            "3", // Flour
            "2", // Japan
            "2", // United Kingdom
            "2", // Nile River
            "3", // Himalayas
            "3"  // Canberra
        };

        boolean[] correctAnswers = new boolean[questions.length];
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            // 選択肢の表示
            for (String option : options[i]) {
                System.out.println(option);
            }

            // 回答の入力前メッセージの変更
            System.out.print("Please enter the number of your answer: ");
            String userAnswer = reader.readLine();

            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!");
                score++;
                correctAnswers[i] = true;
            } else {
                System.out.println("Incorrect.");
                correctAnswers[i] = false;
            }
        }

        System.out.println("Your score is: " + score);

        System.out.println("Review the incorrect answers:");
        for (int i = 0; i < correctAnswers.length; i++) {
            if (!correctAnswers[i]) {
                System.out.println("Question: " + questions[i]);
                // 不正解だった問題の正解の表示形式の変更
                System.out.println("Correct answer: " + options[i][Integer.parseInt(answers[i]) - 1]);
            }
        }
    }
}