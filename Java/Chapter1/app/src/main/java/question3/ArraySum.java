package question3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArraySum {
    public static void main(String[] args) throws IOException {
        // BufferedReaderの準備
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 入力値の格納用に配列を用意する
        int[] numbers = new int[5];
        // 合計値を格納する
        int total = 0;

        // 数値を配列に格納
        for (int i = 0; i < numbers.length; i++) {
            // 入力を求めるメッセージの出力
            System.out.println("Enter number " + (i + 1) + ": ");
            // 入力を求め配列に格納する
            numbers[i] = Integer.parseInt(reader.readLine());
        }

        // 配列の内容を出力する前のメッセージの出力
        System.out.println("You entered:");
        for (int num : numbers) {
            // 配列の内容を出力
            System.out.println(num);
            // 合計値の算出
            total += num;
        }

        // 合計値を出力
        System.out.println("Total: " + total);
    }
}
