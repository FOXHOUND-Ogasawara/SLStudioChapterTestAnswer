package question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreMessage {
    public static void main(String[] args) throws IOException {
        // BufferedReaderの準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // スコアを入力させる
        System.out.println("Enter your score (0-100): ");
        int score = Integer.parseInt(reader.readLine());

        // スコアに基づいて条件分岐し、適切なメッセージを出力する
        if (score >= 80) {
            // スコアが80以上の場合、"Great!"と出力
            System.out.println("Great!");
        } else if (score >= 60) {
            // スコアが60以上80未満の場合、"Good!"と出力
            System.out.println("Good!");
        } else if (score >= 40) {
            // スコアが40以上60未満の場合、"Fair."と出力
            System.out.println("Fair.");
        } else if (score >= 0) {
            // スコアが0以上40未満の場合、"Poor..."と出力
            System.out.println("Poor...");
        } else {
            // スコアが0未満の場合、"Invalid score."と出力
            System.out.println("Invalid score.");
        }
    }
}
