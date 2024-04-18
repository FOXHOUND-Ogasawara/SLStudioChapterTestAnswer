[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=14405537&assignment_repo_type=AssignmentRepo)
# chapter1定着度確認テスト

## 試験概要

以下の説明を読み、各設問に解答し提出してください。

- 実装前に処理フローをコメントアウトで記述すること
- 実装完了後、自己採点（動作確認）を行うこと
- 自己採点完了後、次の設問をすすめること
- 全てのプログラムが実行可能であること
- コンパイルエラー状態での提出は禁止


## 設問1

### **シンプルな計算機**

### 目安時間

10分

### 設問

以下の要件を満たすシンプルな計算プログラムをステップに従い作成してください。

- 2つの整数の入力を求める
    - 1つ目の入力時には`Enter first number:`  (文末は半角スペース)と出力する
    - 2つ目の入力時には`Enter second number:` (文末は半角スペース)と出力する
- 加算（`+`）または減算（`-`）のいずれかを選択させる
    - 選択時には`Choose operation (+ or -):` (文末は半角スペース)と出力する
- 入力された2つの数に対して選択された演算を実行し、以下の形式で結果を表示して処理を終了する
    - `Result: 計算結果`(:と計算結果の間は半角スペース)
- 無効な演算子を入力した場合は、エラーメッセージを表示して処理を終了する
    - `Error: Invalid operation`

**対象のファイル**

src/main/java/question1/**Calculator.java**

### ステップ1：プログラムの設計

プログラムを実装する前にコメントアウトを使用して、プログラムの流れを説明する内容を記述してください。

### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース1**

- 1つ目の入力：5
- 2つ目の入力：3
- 演算子の選択：+
- `Result: 8`と出力さていることを確認する

**テストケース2**

- 1つ目の入力：10
- 2つ目の入力：8
- 演算子の選択：-
- `Result: 2`と出力さていることを確認する

**テストケース3**

- 1つ目の入力：5
- 2つ目の入力：3
- 演算子の選択：*
- `Error: Invalid operation`と出力さていることを確認する



## 設問2

### スコアに応じたメッセージ表示

### 目安時間

10分

### 設問

以下の要件を満たすスコアに応じたメッセージ表示プログラムをステップに従い作成してください。

- スコアの入力を求める
    - 入力時には`Enter your score (0-100):`  (文末は半角スペース)と出力する
- スコアに応じて以下のメッセージを出力する
    - 80以上： "Great!"
    - 60以上80未満： "Good!"
    - 40以上60未満： "Fair."
    - 40未満： "Poor..."
    - 0未満： "Invalid score."
    - ※100より大きい値の考慮は不要

**対象のファイル**

`src/main/java/question2/ScoreMessage.java`

### ステップ1：プログラムの設計

プログラムを実装する前にコメントアウトを使用して、プログラムの流れを説明する内容を記述してください。

### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース1**

- 入力スコア：85
- 期待される出力：`Great!`

**テストケース2**

- 入力スコア：65
- 期待される出力：`Good!`

**テストケース3**

- 入力スコア：50
- 期待される出力：`Fair.`

**テストケース4**

- 入力スコア：30
- 期待される出力：`Poor...`

**テストケース5**

- 入力スコア：-1
- 期待される出力：`Invalid score.`



## 設問3

### スコアに応じたメッセージ表示

### 目安時間

10分

### **設問**

以下の要件を満たす配列内の要素の合計計算プログラムをステップに従い作成してください。

- 5つの整数の入力を求める
    - 各入力時には**`Enter number X:`** (Xは1から5までの数、文末は半角スペース)と出力する
- 入力された5つの数を配列に格納する
- 格納された配列の内容を順番に出力する
    - 配列を出力する前に`You entered:`と出力する
- 配列内の要素の合計を計算し、以下の形式で出力する
    - **`Total: 合計値`**(:と合計値の間は半角スペース)

**対象のファイル**

**`src/main/java/question3/ArraySum.java`**

### **ステップ1：プログラムの設計**

実装する前にコメントアウトを使用して、プログラムの流れを説明する内容を記述してください。

### **ステップ2：プログラムの実装**

コメントアウトで記述したプログラムの流れに従って、実装してください。

### **ステップ3：プログラムのテスト（動作確認）**

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース**

- 入力数値：5, 10, 15, 20, 25
- 配列内容の出力確認：5, 10, 15, 20, 25 が順に出力されること
- 期待される合計出力：**`Total: 75`**



## 設問4

### クイズゲームの拡張

### 目安時間

20分

### **設問**

以下の既存のクイズプログラムを拡張して、不正解だった質問とその正解を出力する機能をステップに従い追加してください。

- 不正解だった質問とその正解は以下の形式でメッセージを出力する
    - `Question: 質問文`(:と合計値の間は半角スペース)
    - `Correct answer: 正解`(:と合計値の間は半角スペース)
- スコア表示後に不正解だった質問とその正解を出力する前に以下のメッセージを出力する
    - `Review the incorrect answers:`

```jsx
package question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuizGame {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

				// 質問文
        String[] questions = {
            "What is the main ingredient in traditional Italian pizza dough?", // イタリアの伝統的なピザ生地の主原料は？
            "Which country is known for inventing sushi?", // 寿司を発明したことで知られる国は？
            "In which country did the sandwich originate?", // サンドイッチの発祥国は？
            "What is the longest river in the world?", // 世界で最も長い川は？
            "Mount Everest is located in which mountain range?", // エベレストはどの山脈にあるか？
            "What is the capital city of Australia?" // オーストラリアの首都は？
        };

        // 正解
        String[] answers = {
            "Flour", // 小麦粉
            "Japan", // 日本
            "United Kingdom", // イギリス
            "Nile River", // ナイル川
            "Himalayas", // ヒマラヤ山脈
            "Canberra" // キャンベラ
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.print("Please enter your answer: ");
            String userAnswer = reader.readLine();

            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!"); // 正解
                score++;
            } else {
                System.out.println("Incorrect."); // 不正解
            }
        }

        System.out.println("Your score is: " + score);
    }
}
```

**対象のファイル**

**`src/main/java/question4/QuizGame.java`**

### **ステップ1：プログラムの設計**

実装する前にコメントアウトを使用して、既存のプログラムに拡張する内容を記述してください。

### **ステップ2：プログラムの実装**

コメントアウトで記述したプログラムの流れに従って、実装してください。

### **ステップ3：プログラムのテスト（動作確認）**

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース1**

質問1、3、6に正しく回答し、質問2、4、5に間違って回答し、出力結果を確認する

- 質問1への回答: Flour
- 質問2への回答: China (不正解)
- 質問3への回答: United Kingdom
- 質問4への回答: Amazon (不正解)
- 質問5への回答: Alps (不正解)
- 質問6への回答: Canberra

```jsx
Question 1: What is the main ingredient in traditional Italian pizza dough?
Please enter your answer: Flour
Correct!
Question 2: Which country is known for inventing sushi?
Please enter your answer: China
Incorrect.
Question 3: In which country did the sandwich originate?
Please enter your answer: United Kingdom
Correct!
Question 4: What is the longest river in the world?
Please enter your answer: Amazon
Incorrect
Question 5: Mount Everest is located in which mountain range?
Please enter your answer: Alps
Incorrect.
Question 6: What is the capital city of Australia?
Please enter your answer: Canberra
Correct!
Your score is: 3
Review the incorrect answers:
Question: Which country is known for inventing sushi?
Correct answer: Japan
Question: What is the longest river in the world?
Correct answer: Nile River
Question: Mount Everest is located in which mountain range?
Correct answer: Himalayas
```



## **設問5**

### **4択形式のクイズゲームへの拡張**

### **目安時間**

20分

### **設問**

設問4のプログラムを拡張して、4択形式で質問を提示し、番号で回答できるようにする機能を追加してください。

- 対象のクラス内のmainメソッド内に設問4の内容をコピー&ペーストする
- 各質問には4つの選択肢を提示し、番号（1, 2, 3, 4）で回答します
- クイズの出題形式の変更に合わせて出力内容も修正する
    - 回答の入力前のメッセージは`Please enter the number of your answer:`に修正する
    - 不正解だった問題の正解は`Correct answer: 3: Flour`に修正する（`:`の後は半角スペース）
- 選択肢は以下の内容を用いて下さい

```jsx
"1: Water", "2: Yeast", "3: Flour", "4: Salt"
"1: China", "2: Japan", "3: Korea", "4: Vietnam"
"1: Germany", "2: United Kingdom", "3: USA", "4: Italy"
"1: Amazon River", "2: Nile River", "3: Yangtze River", "4: Mississippi River"
"1: Andes", "2: Rockies", "3: Himalayas", "4: Alps"
"1: Sydney", "2: Melbourne", "3: Canberra", "4: Brisbane"
```

- 正解は以下の内容を用いて下さい

```jsx
// 正解の番号を設定
String[] answers = {
		"3", // Flour
	  "2", // Japan
	  "2", // United Kingdom
	  "2", // Nile River
	  "3", // Himalayas
	  "3"  // Canberra
};
```

**対象のファイル**

**`src/main/java/question4/MultipleChoice.java`**

### **ステップ1：プログラムの設計**

実装する前にコメントアウトを使用して、既存のプログラムに追加する4択形式の質問と回答処理を記述してください。

### **ステップ2：プログラムの実装**

コメントアウトで記述したプログラムの流れに従って、実装してください。

### **ステップ3：プログラムのテスト（動作確認）**

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース1**

質問1、3、6に正しく回答し、質問2、4、5に間違って回答し、出力結果を確認する

- 質問1への回答: 3 (Flour)
- 質問2への回答: 1 (China) - 不正解
- 質問3への回答: 2 (United Kingdom)
- 質問4への回答: 1 (Amazon River) - 不正解
- 質問5への回答: 1(Sydney) - 不正解
- 質問6への回答: 3 (Canberra)

```jsx
Question 1: What is the main ingredient in traditional Italian pizza dough?
1: Water
2: Yeast
3: Flour
4: Salt
Please enter the number of your answer: 3
Correct!
Question 2: Which country is known for inventing sushi?
1: China
2: Japan
3: Korea
4: Vietnam
Please enter the number of your answer: 1
Incorrect.
Question 3: In which country did the sandwich originate?
1: Germany
2: United Kingdom
3: USA
4: Italy
Please enter the number of your answer: 2
Correct!
Question 4: What is the longest river in the world?
1: Amazon River
2: Nile River
3: Yangtze River
4: Mississippi River
Please enter the number of your answer: 1
Incorrect.
Question 5: Mount Everest is located in which mountain range?
1: Andes
2: Rockies
3: Himalayas
4: Alps
Please enter the number of your answer: 1
Incorrect.
Question 6: What is the capital city of Australia?
1: Sydney
2: Melbourne
3: Canberra
4: Brisbane
Please enter the number of your answer: 3
Correct!
Your score is: 3
Review the incorrect answers:
Question: Which country is known for inventing sushi?
Correct answer: 2: Japan
Question: What is the longest river in the world?
Correct answer: 2: Nile River
Question: Mount Everest is located in which mountain range?
Correct answer: 3: Himalayas
```



## **設問6**

### **クイズゲームへのシャッフル機能の追加**

### **目安時間**

20分

### **設問**

設問5のプログラムを拡張して、質問が毎回ランダムな順番にシャッフルされる機能を追加してください。

シャッフルはフィッシャー・イェーツアルゴリズムを用いて実装してください。

- 質問、選択肢、答えは、それぞれがランダムに並び替えられるようにしてください
- ランダムにシャッフルされた質問をユーザーに提示し、回答を受け取るようにしてください
- 不正解だった質問とその正解の出力機能を維持してください

**対象のファイル**

**`src/main/java/question6/FisherYatesShuffle.java`**

### **ステップ1：プログラムの設計**

実装する前にコメントアウトを使用して、既存のプログラムに追加する質問のシャッフル処理を記述してください。

### **ステップ2：プログラムの実装**

コメントアウトで記述したプログラムの流れに従って、質問をシャッフルする機能を実装してください。

### **ステップ3：プログラムのテスト（動作確認）**

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース**

プログラムを複数回実行し、質問が毎回異なる順序で提示されることを確認する。また、シャッフルされた質問に対する正解と不正解が適切に処理されているかを確認する。



## **設問7**

### **ジャグ配列を使ったクイズゲームの拡張**

### **目安時間**

20分

### **設問**

設問6のプログラムを拡張して、各質問に対する答えをジャグ配列を使用して複数の可能性を持たせ、ユーザーの入力がジャグ配列内のいずれかの答えと一致するかどうかをチェックする機能を追加してください。

- 各質問の答えを複数の可能性を持つようにジャグ配列を使用して格納します
- ユーザーが入力した答えがジャグ配列内のいずれかの答えと一致するかどうかを判断する処理を追加します
- クイズの出題形式の変更に合わせて出力内容も修正する
    - 回答の入力前のメッセージは`Please enter your answer:` に修正する（`:`の後は半角スペース）
    - 不正解だった問題の正解は`Correct answer: 3: Flour`に修正する（`:`の後は半角スペース）
- 質問に対する答えは以下の内容を用いて下さい

```jsx
"3: Flour", "3", "Flour", "flour", "Wheat Flour",
"2: Japan", "2", "Japan", "japan", "Nihon", "Nippon",
"2: United Kingdom", "2", "United Kingdom", "UK", "Britain",
"2: Nile River", "2", "Nile River", "Nile",
"3: Himalayas", "3", "Himalayas", "Himalaya Mountains",
"3: Canberra", "3", "Canberra", "canberra"
```

**対象のファイル**

**`src/main/java/question7/FlexiQuiz.java`**

### **ステップ1：プログラムの設計**

実装する前にコメントアウトを使用して、既存のプログラムに追加するジャグ配列を使用した答えの処理を記述してください。

### **ステップ2：プログラムの実装**

コメントアウトで記述したプログラムの流れに従って、ジャグ配列を使用した答えの処理を実装してください。

### **ステップ3：プログラムのテスト（動作確認）**

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース**

- 質問に対してジャグ配列に含まれる複数の答えのうちの一つを入力し、それが正解として認識されるかを確認する
- ジャグ配列に含まれない答えを入力した場合、それが不正解として認識されるかを確認する
- 不正解だった場合、正しい答えが出力されるかを確認する



## **設問8**

### **クイズゲームへのジャンル選択機能の追加**

### **目安時間**

20分

### **設問**

設問7のプログラムを拡張して、ジャンル選択機能を追加してください。ユーザーはプログラムの開始時にジャンルを選択し、選択されたジャンルに基づいて質問が出題されます。各ジャンルは異なる質問セットを持っています。

- ジャンルに応じて異なる質問セットを用意します（例: "Food", "Geography"）。
- ユーザーがジャンルを選択すると、そのジャンルに対応する質問のみが出題されます。
- ユーザーが無効なジャンルを選択した場合、再度選択を求めます。

**対象のファイル**

**`src/main/java/question8/GenreQuiz.java`**

### **ステップ1：プログラムの設計**

実装する前にコメントアウトを使用して、既存のプログラムに追加するジャンル選択機能の処理を記述してください。

### **ステップ2：プログラムの実装**

コメントアウトで記述したプログラムの流れに従って、ジャンル選択機能を実装してください。

### **ステップ3：プログラムのテスト（動作確認）**

以下のテストケースに従ってプログラムの動作を確認してください。

すべてのケースを確認し、問題があればプログラムを修正し、問題なければ次の問題へ進んでください。

**テストケース**

- ユーザーが有効なジャンルを選択した場合、そのジャンルに対応する質問が出題されることを確認する。
- ユーザーが無効なジャンルを選択した場合、再度ジャンルの選択を求めることを確認する。
- 選択したジャンルに応じて、正解と不正解が適切に処理されることを確認する。
