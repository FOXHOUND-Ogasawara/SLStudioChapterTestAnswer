package question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        // BufferedReaderの準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // ユーザーに最初の数を入力させる
        System.out.println("Enter first number: ");
        int num1 = Integer.parseInt(reader.readLine());

        // ユーザーに2番目の数を入力させる
        System.out.println("Enter second number: ");
        int num2 = Integer.parseInt(reader.readLine());

        // 加算または減算の操作をユーザーに選択させる
        System.out.println("Choose operation (+ or -): ");
        String operation = reader.readLine();

        // 結果を格納するための変数
        int result;
        // ユーザーの入力に基づいて加算または減算を実行
        if (operation.equals("+")) {
            // 加算し結果を格納する
            result = num1 + num2;
            // 計算結果の出力
            System.out.println("Result: " + result);
        } else if (operation.equals("-")) {
            // 減算し結果を格納する
            result = num1 - num2;
            // 計算結果の出力
            System.out.println("Result: " + result);
        } else {
            // 無効な演算子が入力された場合のエラーメッセージを出力する
            System.out.println("Error: Invalid operation");
        }
    }
}