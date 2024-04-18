[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=14639891&assignment_repo_type=AssignmentRepo)
# Chapter4アセスメント

## 試験概要

試験時間：120分

本試験では、CSVのデータを使用してさまざまなデータ加工を行った機能を実装します。
本試験では必要なクラスとメソッドの定義は既に済ませてコメントアウトしています。
以下の説明を読み、各設問に解答し提出してください。

- 設問の仕様とJavadocをもとに必要な処理を実装すること
- 実装前に処理フローをコメントアウトで記述すること
- 実装完了後、自己採点（動作確認）を行うこと
- 自己採点完了後、次の設問に進むこと
- 全てのプログラムが実行可能であること
- コンパイルエラー状態での提出は禁止
- 出力内容やメソッド名が指示通りでない場合は不正解となる
- 実行時に`Build failed, do you want to continue.`という警告が出たときは`continue`を選択すると実行可能
- メソッド名や引数・返り値の型などこちらで既に用意しているものを勝手に変更した場合は不正解となる
- peopleData.csvを誤って上書きしたときは、perpleData_backup.csvの内容を利用してください
- CSVデータの1行目にある以下の情報はカラム名（列名）と呼称する

---
 各カラムごとの意味とデータ
---

| カラム名 | 意味 | 例 |
| --- | --- | --- |
| Name   | 人の名前      | Yoshida |
| Age    | 年齢          | 45      |
| Country| 国籍          | Japan   |
| City   | 出身都市      | Tokyo   |
| Food   | 好きな食べ物  | Sushi   |
| Item1  | 所持品1       | Phone   |
| Item2  | 所持品2       | Wallet  |
| Item3  | 所持品3       | Book    |






## 設問1:

### 目安時間

30分

### 設問

要件に従ってクラスの定義と処理の実装を行ってください。



#### クラスの定義

peopleData.csvのデータをマッピングするためのクラス・フィールド・コンストラクタ・アクセサを、以下要件に従って実装してください。

**クラス**
`model`パッケージを新たに作成し、その中に`Person`クラスを実装すること

**フィールド**
以下の仕様でフィールドを実装すること

| アクセス修飾子 | フィールド名 | 型 | peopleDate.csvで対応するカラム |
| --- | --- | --- | --- |
| private | name | 文字列 | Name（名前） |
| private | age | 整数 | Age（年齢） |
| private | country | 文字列 | Country（国籍） |
| private | city | 文字列 | City（出身都市） |
| private | food | 文字列 | Food（好きな食べ物） |
| private | items | 文字列のリスト | Item1、Item2、Item3（所持品1,2,3） |

**コンストラクタ**
各フィールドを初期化するために、以下6つの引数を受け取れる1つのコンストラクタを実装する

| 引数の型・名前 | 説明 |
| --- | --- |
| 文字列・name | nameフィールドに代入する |
| 整数・age | ageフィールドに代入する |
| 文字列・country | countryフィールドに代入する |
| 文字列・city | cityフィールドに代入する |
| 文字列・food | foodフィールドに代入する |
| 文字列のリスト・items | itemsフィールドに代入する |

※引数の順番はname・age・country・city・food・itemsの順とする

**アクセサ（getter）**
以下の仕様に沿って、各フィールドに対応するgetterを実装する

| メソッド名 | 返り値の型 | 処理内容 |
| --- | --- | --- |
| getName | 文字列 | nameフィールドを返却する |
| getAge | 整数列 | ageフィールドを返却する |
| getCountry | 文字列 | countryフィールドを返却する |
| getCity | 文字列 | cityフィールドを返却する |
| getFood | 文字列 | foodフィールドを返却する |
| getItems | 文字列のリスト | itemsフィールドを返却する |

**アクセサ（setter）**
以下の仕様に沿って、各フィールドに対応するsetterを実装する

| メソッド名 | 引数の型・名前 | 返り値の型 | 処理内容 |
| --- | --- | --- | --- |
| setName | 文字列・name | なし | nameフィールドに代入する |
| setAge | 整数・age | なし | ageフィールドに代入する |
| setCountry | 文字列・country | なし | countryフィールドに代入する |
| setCity | 文字列・city | なし | cityフィールドに代入する |
| setFood | 文字列・food | なし | foodフィールドに代入する |
| setItems | 文字列のリスト・items | なし | itemsフィールドに代入する |


#### 処理の実装

`Person` オブジェクトを格納するリストを要件に従って `question1.Q1Execute.java` のメインメソッド内に宣言してください。

型 : List

ローカル変数名 : `peopleList`

初期値 : 以下の3つの `Person` オブジェクトを初期値としたArrayListのインスタンス

| 名前     | 年齢 | 国籍   | 出身都市 | 好きな食べ物 | 所持品1,2,3             |
| -------- | ---- | ------ | -------- | ------------ | ----------------------- |
| Alice    | 18   | France | Paris    | Macaron      | Key, Phone, Card        |
| Benjamin | 69   | Canada | Montreal | Bagel        | Cigarette, Wallet, Book |
| Chiara   | 32   | Italy  | Rome     | Carbonara    | Glasses, Book, Card     |

上記リストが宣言できたら、StreamAPIを使用して年齢が30歳以上の名前と年齢を出力して下さい。出力のフォーマットは出力結果を再現してください。

**完成した場合の出力結果**

```
Benjamin, 69 years old
Chiara, 32 years old
```

### プログラムのテスト（動作確認）

**テストケース1**
1. `src/main/java/question1/Q1PersonTest.java`を開く
2. 処理がコメントアウトされているので、コメントアウトを外す
3. Q1PersonTestクラスのmainメソッドを実行する
4. 以下出力になるかを確認する
  ```
  --- コンストラクタ・getterのテスト結果 ---
  Name: ichiro, Age: 11, Country: USA, City: Chicago, Food: Pizza, Items: Phone, Book,
  ------

  --- setterのテスト結果 ---
  Name: Jiro, Age: 12, Country: Japan, City: Tokyo, Food: Sushi, Items: Card, Phone,
  ------
  ```

**テストケース2**
1. Q1Executeクラスのmainメソッドを実行する
2. 以下出力になるかを確認する
  ```
  Benjamin, 69 years old
  Chiara, 32 years old
  ```


## 設問2:

### 目安時間

40分

### 設問

要件に応じたメソッドを`question2.Q2Execute.java`にすべて実装してください。
mainメソッドには各メソッドの動作確認用の処理がコメントアウトされているので、動作確認時にコメントアウトを外してテストケース通り動くか確認してください。
動作確認用の処理は改変してはいけません。

#### loadPeopleData
Personオブジェクトのリストを格納するローカル変数 `peopleList`を定義してください。
`peopleData.csv` のデータを `Person` オブジェクトにマッピングして`peopleList` に追加してください。
`peopleList`にマッピングしたPersonオブジェクトを追加し終わったら、`peopleList`を返却してください。

#### プログラムのテスト（動作確認）
1. Q2Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- loadPeopleDataの結果 ---");
  // List<Person> peopleList1 = loadPeopleData(FILE_PATH);
  // printAllPeopleList(peopleList1);
  // System.out.println("------" + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- loadPeopleDataの結果 ---
  Name: Sarah, Age: 21, Country: France, City: Paris, Food: Macaron, Items: Cigarette, Phone, Book,
  Name: Emily, Age: 41, Country: USA, City: Chicago, Food: DeepDishPizza, Items: Cigarette, Phone, Card,
  Name: Francesco, Age: 71, Country: Italy, City: Milan, Food: Ossobuco, Items: Cigarette, Wallet, Card,
  Name: Liam, Age: 57, Country: Canada, City: Montreal, Food: SmokedMeatSandwich, Items: Card, Wallet, Card,
  Name: Hannah, Age: 35, Country: Germany, City: Munich, Food: Pretzel, Items: Book, Phone, Card,
  Name: Noah, Age: 48, Country: Canada, City: Vancouver, Food: NanaimoBar, Items: Phone, Key, Cigarette,
  Name: Louis, Age: 43, Country: France, City: Paris, Food: Croissant, Items: Cigarette, Phone, Wallet,
  Name: Olivia, Age: 48, Country: Canada, City: Montreal, Food: Bagel, Items: Cigarette, Phone, Glasses,
  Name: Emma, Age: 48, Country: Germany, City: Munich, Food: Weisswurst, Items: Cigarette, Book, Phone,
  Name: Emily, Age: 87, Country: USA, City: LosAngeles, Food: Sushi, Items: Phone, Cigarette, Wallet,
  Name: Rin, Age: 43, Country: Japan, City: Tokyo, Food: Sushi, Items: Glasses, Cigarette, Cigarette,
  Name: Kenji, Age: 75, Country: Japan, City: Osaka, Food: Takoyaki, Items: Book, Cigarette, Book,
  Name: Emily, Age: 40, Country: USA, City: NewYork, Food: Bagel, Items: Key, Card, Key,
  Name: Giulia, Age: 70, Country: Italy, City: Naples, Food: CapreseSalad, Items: Book, Card, Phone,
  Name: Sakura, Age: 64, Country: Japan, City: Kyoto, Food: Yuba, Items: Cigarette, Glasses, Card,
  Name: Emily, Age: 31, Country: USA, City: LosAngeles, Food: Sushi, Items: Key, Glasses, Key,
  Name: Max, Age: 23, Country: Germany, City: Berlin, Food: DnerKebab, Items: Wallet, Key, Card,
  Name: Kenji, Age: 39, Country: Japan, City: Kyoto, Food: Yuba, Items: Key, Book, Phone,
  Name: Sarah, Age: 71, Country: USA, City: NewYork, Food: Cheesecake, Items: Phone, Glasses, Book,
  Name: Ashley, Age: 73, Country: USA, City: NewYork, Food: Cheesecake, Items: Book, Book, Wallet,
  Name: Louis, Age: 74, Country: France, City: Lyon, Food: CoqauVin, Items: Wallet, Wallet, Cigarette,
  Name: Mia, Age: 31, Country: Germany, City: Munich, Food: Weisswurst, Items: Glasses, Phone, Phone,
  Name: Leon, Age: 71, Country: Germany, City: Hamburg, Food: Fischbrtchen, Items: Book, Cigarette, Card,
  Name: James, Age: 90, Country: USA, City: LosAngeles, Food: AvocadoToast, Items: Glasses, Glasses, Glasses,
  Name: Noah, Age: 59, Country: Canada, City: Vancouver, Food: Salmon, Items: Glasses, Cigarette, Phone,
  Name: Leo, Age: 53, Country: France, City: Lyon, Food: Quenelle, Items: Book, Phone, Book,
  Name: Benjamin, Age: 38, Country: Canada, City: Vancouver, Food: NanaimoBar, Items: Book, Wallet, Card,
  Name: Camille, Age: 32, Country: France, City: Marseille, Food: Bouillabaisse, Items: Book, Card, Cigarette,
  Name: Max, Age: 30, Country: Germany, City: Hamburg, Food: Labskaus, Items: Glasses, Glasses, Cigarette,
  Name: Sophia, Age: 69, Country: Canada, City: Toronto, Food: PeamealBacon, Items: Cigarette, Key, Cigarette,
  Name: Jessica, Age: 34, Country: USA, City: LosAngeles, Food: Tacos, Items: Cigarette, Key, Phone,
  Name: Leo, Age: 85, Country: France, City: Lyon, Food: CoqauVin, Items: Key, Cigarette, Book,
  Name: John, Age: 38, Country: USA, City: Chicago, Food: Popcorn, Items: Key, Key, Key,
  Name: Haruto, Age: 62, Country: Japan, City: Osaka, Food: Takoyaki, Items: Wallet, Cigarette, Card,
  Name: Sofia, Age: 69, Country: Germany, City: Hamburg, Food: Fischbrtchen, Items: Book, Card, Key,
  Name: Chloe, Age: 71, Country: France, City: Lyon, Food: Quenelle, Items: Card, Book, Card,
  Name: John, Age: 65, Country: USA, City: LosAngeles, Food: Tacos, Items: Wallet, Cigarette, Glasses,
  Name: Rin, Age: 45, Country: Japan, City: Kyoto, Food: Yuba, Items: Card, Phone, Key,
  Name: Sarah, Age: 49, Country: USA, City: LosAngeles, Food: Tacos, Items: Phone, Cigarette, Cigarette,
  Name: Camille, Age: 43, Country: France, City: Marseille, Food: Bouillabaisse, Items: Key, Cigarette, Cigarette,
  Name: Charlotte, Age: 73, Country: Canada, City: Toronto, Food: ButterTart, Items: Glasses, Book, Phone,
  Name: Yuki, Age: 40, Country: Japan, City: Osaka, Food: Kushikatsu, Items: Book, Wallet, Wallet,
  Name: Lukas, Age: 76, Country: Germany, City: Munich, Food: Weisswurst, Items: Key, Book, Card,
  Name: Robert, Age: 46, Country: USA, City: NewYork, Food: Bagel, Items: Cigarette, Glasses, Card,
  Name: Paul, Age: 27, Country: Germany, City: Munich, Food: Pretzel, Items: Book, Glasses, Cigarette,
  Name: Luca, Age: 21, Country: Italy, City: Milan, Food: Panettone, Items: Key, Book, Glasses,
  Name: Emma, Age: 49, Country: Canada, City: Montreal, Food: Bagel, Items: Book, Cigarette, Book,
  Name: Anna, Age: 70, Country: Germany, City: Munich, Food: Pretzel, Items: Book, Book, Key,
  Name: Kenji, Age: 67, Country: Japan, City: Kyoto, Food: MatchaSweets, Items: Book, Phone, Glasses,
  Name: Francesco, Age: 19, Country: Italy, City: Naples, Food: Pizza, Items: Key, Wallet, Book,
  Name: Alessandro, Age: 30, Country: Italy, City: Milan, Food: Risotto, Items: Phone, Cigarette, Cigarette,
  Name: Louis, Age: 35, Country: France, City: Lyon, Food: CoqauVin, Items: Key, Cigarette, Glasses,
  Name: Liam, Age: 73, Country: Canada, City: Montreal, Food: Bagel, Items: Cigarette, Glasses, Key,
  Name: Jessica, Age: 54, Country: USA, City: Chicago, Food: DeepDishPizza, Items: Wallet, Phone, Wallet,
  Name: Sarah, Age: 86, Country: France, City: Lyon, Food: SaladeLyonnaise, Items: Phone, Phone, Book,
  Name: Sofia, Age: 63, Country: Germany, City: Berlin, Food: Eisbein, Items: Cigarette, Card, Cigarette,
  Name: Miyu, Age: 49, Country: Japan, City: Osaka, Food: Takoyaki, Items: Card, Glasses, Phone,
  Name: Benjamin, Age: 76, Country: Canada, City: Toronto, Food: Poutine, Items: Cigarette, Wallet, Card,
  Name: Robert, Age: 51, Country: USA, City: NewYork, Food: Bagel, Items: Book, Phone, Phone,
  Name: Francesco, Age: 38, Country: Italy, City: Naples, Food: Sfogliatella, Items: Wallet, Cigarette, Cigarette,
  Name: Luca, Age: 37, Country: Italy, City: Milan, Food: Panettone, Items: Key, Cigarette, Card,
  Name: Alice, Age: 71, Country: France, City: Lyon, Food: Quenelle, Items: Cigarette, Phone, Card,
  Name: Sophia, Age: 55, Country: Canada, City: Montreal, Food: Bagel, Items: Wallet, Wallet, Wallet,
  Name: Sarah, Age: 29, Country: USA, City: Chicago, Food: ItalianBeef, Items: Glasses, Phone, Card,
  Name: Naomi, Age: 16, Country: Japan, City: Osaka, Food: Okonomiyaki, Items: Cigarette, Cigarette, Phone,
  Name: Hiroshi, Age: 68, Country: Japan, City: Kyoto, Food: KaisekiRyori, Items: Phone, Key, Book,
  Name: Camille, Age: 65, Country: France, City: Marseille, Food: Bouillabaisse, Items: Book, Book, Book,
  Name: Kenji, Age: 52, Country: Japan, City: Tokyo, Food: Ramen, Items: Cigarette, Key, Card,
  Name: Jessica, Age: 67, Country: USA, City: LosAngeles, Food: Sushi, Items: Cigarette, Wallet, Key,
  Name: Sophia, Age: 89, Country: Canada, City: Toronto, Food: ButterTart, Items: Key, Wallet, Wallet,
  Name: Ashley, Age: 42, Country: USA, City: NewYork, Food: HotDog, Items: Glasses, Glasses, Book,
  Name: Sarah, Age: 72, Country: France, City: Paris, Food: Baguette, Items: Glasses, Key, Book,
  Name: David, Age: 41, Country: USA, City: Chicago, Food: ItalianBeef, Items: Cigarette, Glasses, Glasses,
  Name: Olivia, Age: 44, Country: Canada, City: Montreal, Food: PoudingChmeur, Items: Wallet, Glasses, Book,
  Name: Kenji, Age: 54, Country: Japan, City: Tokyo, Food: Sushi, Items: Glasses, Book, Key,
  Name: Paul, Age: 72, Country: Germany, City: Munich, Food: Weisswurst, Items: Cigarette, Glasses, Cigarette,
  Name: Hannah, Age: 86, Country: Germany, City: Berlin, Food: DnerKebab, Items: Key, Card, Key,
  Name: Leo, Age: 61, Country: France, City: Marseille, Food: Bouillabaisse, Items: Cigarette, Card, Cigarette,
  Name: Davide, Age: 79, Country: Italy, City: Milan, Food: Panettone, Items: Phone, Phone, Glasses,
  Name: Olivia, Age: 74, Country: Canada, City: Toronto, Food: ButterTart, Items: Wallet, Book, Book,
  Name: Emma, Age: 63, Country: Germany, City: Berlin, Food: DnerKebab, Items: Wallet, Glasses, Key,
  Name: Louis, Age: 52, Country: France, City: Lyon, Food: SaladeLyonnaise, Items: Glasses, Glasses, Phone,
  Name: John, Age: 31, Country: USA, City: LosAngeles, Food: Tacos, Items: Glasses, Cigarette, Glasses,
  Name: Sarah, Age: 88, Country: USA, City: LosAngeles, Food: AvocadoToast, Items: Book, Wallet, Book,
  Name: David, Age: 28, Country: USA, City: Chicago, Food: ItalianBeef, Items: Phone, Key, Cigarette,
  Name: Liam, Age: 62, Country: Canada, City: Vancouver, Food: Salmon, Items: Cigarette, Key, Book,
  Name: Avery, Age: 48, Country: Canada, City: Toronto, Food: ButterTart, Items: Phone, Phone, Wallet,
  Name: Alessandro, Age: 87, Country: Italy, City: Rome, Food: Carbonara, Items: Book, Key, Phone,
  Name: Ashley, Age: 26, Country: USA, City: Chicago, Food: Popcorn, Items: Card, Phone, Cigarette,
  Name: Alice, Age: 25, Country: France, City: Marseille, Food: Navette, Items: Phone, Phone, Wallet,
  Name: Alice, Age: 83, Country: France, City: Marseille, Food: Navette, Items: Card, Phone, Cigarette,
  Name: Chiara, Age: 18, Country: Italy, City: Milan, Food: Panettone, Items: Wallet, Wallet, Card,
  Name: Finn, Age: 44, Country: Germany, City: Berlin, Food: Currywurst, Items: Cigarette, Phone, Book,
  Name: Sarah, Age: 76, Country: USA, City: LosAngeles, Food: Tacos, Items: Glasses, Cigarette, Cigarette,
  Name: Emma, Age: 49, Country: France, City: Paris, Food: Croissant, Items: Book, Key, Cigarette,
  Name: Michael, Age: 72, Country: USA, City: LosAngeles, Food: Tacos, Items: Phone, Cigarette, Cigarette,
  Name: Aurora, Age: 47, Country: Italy, City: Rome, Food: Carbonara, Items: Glasses, Wallet, Cigarette,
  Name: Charlotte, Age: 35, Country: Canada, City: Vancouver, Food: Salmon, Items: Book, Key, Key,
  Name: Alessandro, Age: 15, Country: Italy, City: Rome, Food: Carbonara, Items: Glasses, Wallet, Cigarette,
  Name: Sophia, Age: 32, Country: Canada, City: Toronto, Food: Poutine, Items: Glasses, Book, Glasses,
  ------
  ```


#### removeAndOutputNames

引数`List<Person> peopleList` から、以下の条件に基づいてPersonオブジェクトを削除するメソッドです。

- リストの末尾から50%の要素を削除する
  - 例えばリストのサイズが100の場合、50~99番目の要素が削除されます
- リストのサイズが割り切れない場合は、小数部分は切り捨てて考えるものとする
  - 例えばリストのサイズが1の場合、1の50%は0.5となるので、小数点は切り捨てて0として考える
- 削除する際は、subListメソッドを使用する
- 削除後の残りのPersonオブジェクトの名前をコンソールに出力する

出力例

```
Sarah
Emily
Francesco
Liam
Hannah
Noah
Louis
Olivia
Emma
Emily
Rin
Kenji
Emily
Giulia
Sakura
Emily
Max
Kenji
Sarah
Ashley
Louis
Mia
Leon
James
Noah
Leo
Benjamin
Camille
Max
Sophia
Jessica
Leo
John
Haruto
Sofia
Chloe
John
Rin
Sarah
Camille
Charlotte
Yuki
Lukas
Robert
Paul
Luca
Emma
Anna
Kenji
Francesco
```

#### プログラムのテスト（動作確認）
1. Q2Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- removeAndOutputNamesの結果 ---");
  // removeAndOutputNames(peopleList1);
  // System.out.println("------" + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- removeAndOutputNamesの結果 ---
  Sarah
  Emily
  Francesco
  Liam
  Hannah
  Noah
  Louis
  Olivia
  Emma
  Emily
  Rin
  Kenji
  Emily
  Giulia
  Sakura
  Emily
  Max
  Kenji
  Sarah
  Ashley
  Louis
  Mia
  Leon
  James
  Noah
  Leo
  Benjamin
  Camille
  Max
  Sophia
  Jessica
  Leo
  John
  Haruto
  Sofia
  Chloe
  John
  Rin
  Sarah
  Camille
  Charlotte
  Yuki
  Lukas
  Robert
  Paul
  Luca
  Emma
  Anna
  Kenji
  Francesco
  ------
  ```



#### printFormattedPeopleList

`peopleList` の中で、国籍の `USA` という文字列を `America` に変更し、先頭の25件分のデータを以下のフォーマットで出力するメソッドです。

このメソッドの実装にはStreamAPIを使用してください。

- 名前が `Mark` 、国籍が `USA` の場合

```
Mark was born in America
```

出力結果

```
Sarah was born in France
Emily was born in America
Francesco was born in Italy
Liam was born in Canada
Hannah was born in Germany
Noah was born in Canada
Louis was born in France
Olivia was born in Canada
Emma was born in Germany
Emily was born in America
Rin was born in Japan
Kenji was born in Japan
Emily was born in America
Giulia was born in Italy
Sakura was born in Japan
Emily was born in America
Max was born in Germany
Kenji was born in Japan
Sarah was born in America
Ashley was born in America
Louis was born in France
Mia was born in Germany
Leon was born in Germany
James was born in America
Noah was born in Canada
```

#### プログラムのテスト（動作確認）
1. Q2Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- printFormattedPeopleListの結果 ---");
  // List<Person> peopleList2 = loadPeopleData(FILE_PATH);
  // printFormattedPeopleList(peopleList2);
  // System.out.println("------"  + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- printFormattedPeopleListの結果 ---
  Sarah was born in France
  Emily was born in America
  Francesco was born in Italy
  Liam was born in Canada
  Hannah was born in Germany
  Noah was born in Canada
  Louis was born in France
  Olivia was born in Canada
  Emma was born in Germany
  Emily was born in America
  Rin was born in Japan
  Kenji was born in Japan
  Emily was born in America
  Giulia was born in Italy
  Sakura was born in Japan
  Emily was born in America
  Max was born in Germany
  Kenji was born in Japan
  Sarah was born in America
  Ashley was born in America
  Louis was born in France
  Mia was born in Germany
  Leon was born in Germany
  James was born in America
  Noah was born in Canada
  ------
  ```



#### printNamesWithBook

`peopleList` の中から所持品に `Book` を含むデータのみを抽出し、名前を全て出力するメソッドです。

ただし、同じ名前は1度しか出力しません。

メソッドの実装にはStreamAPIを使用してください。

出力結果

```
Sarah
Hannah
Emma
Kenji
Giulia
Ashley
Leon
Leo
Benjamin
Camille
Sofia
Chloe
Charlotte
Yuki
Lukas
Paul
Luca
Anna
Francesco
Robert
Hiroshi
Olivia
Liam
Alessandro
Finn
Sophia
```

#### プログラムのテスト（動作確認）
1. Q2Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- printNamesWithBookの結果 ---");
  // List<Person> peopleList3 = loadPeopleData(FILE_PATH);
  // printNamesWithBook(peopleList3);
  // System.out.println("------"  + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- printNamesWithBookの結果 ---
  Sarah
  Hannah
  Emma
  Kenji
  Giulia
  Ashley
  Leon
  Leo
  Benjamin
  Camille
  Sofia
  Chloe
  Charlotte
  Yuki
  Lukas
  Paul
  Luca
  Anna
  Francesco
  Robert
  Hiroshi
  Olivia
  Liam
  Alessandro
  Finn
  Sophia
  ------
  ```



#### printNumberWithCigarette

`peopleList` の中から所持品に `Cigarette` を含むデータのみを抽出し、件数を以下の出力結果のフォーマットに沿って出力するメソッドです。

メソッドの実装にはStreamAPIを使用してください。

- 出力結果

```
There are 51 smokers.
```

#### プログラムのテスト（動作確認）
1. Q2Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- printNumberWithCigaretteの結果 ---");
  // List<Person> peopleList4 = loadPeopleData(FILE_PATH);
  // printNumberWithCigarette(peopleList4);
  // System.out.println("------"  + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- printNumberWithCigaretteの結果 ---
  There are 51 smokers.
  ------
  ```




## 設問3:

### 目安時間

40分

### 設問

要件に応じたメソッドを`question3.Q3Execute.java`にすべて実装してください。
mainメソッドには各メソッドの動作確認用の処理がコメントアウトされているので、動作確認時にコメントアウトを外してテストケース通り動くか確認してください。
動作確認用の処理を改変してはいけません。

#### loadPeopleData

設問2と同様に実装してください。
※設問2と同様の処理の為、動作確認は省きます。

#### getKyotoFavoriteFoods

`Person` 型のオブジェクトのリストを引数として受け取り、その中から `Kyoto` を出身都市に持つ人が好きな食べ物の一覧を返します。

食べ物の一覧は Set 型とします。

- 出力結果(順不同)

```
Yuba
MatchaSweets
KaisekiRyori
```

#### プログラムのテスト（動作確認）
1. Q3Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // List<Person> peopleList = loadPeopleData(FILE_PATH);

  // System.out.println("--- getKyotoFavoriteFoodsの結果 ---");
  // System.out.println(getKyotoFavoriteFoods(peopleList));
  // System.out.println("------" + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- getKyotoFavoriteFoodsの結果 ---
  [Yuba, MatchaSweets, KaisekiRyori]
  ------
  ```


#### getCityFoodMap

`Person` 型のオブジェクトのリストを引数として受け取り、各都市出身者の好きな食べ物をMapとして返します。

Mapのキーは都市名で、値はキーの都市を出身都市名に持つ人が好きな食べ物のSetです。

- フォーマット

```
都市名 : [食べ物1, 食べ物2, ...]
```

#### プログラムのテスト（動作確認）
1. Q3Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- getCityFoodMapの結果 ---");
  // System.out.println(getCityFoodMap(peopleList));
  // System.out.println("------" + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- getCityFoodMapの結果 ---
  {Munich=[Pretzel, Weisswurst], Vancouver=[NanaimoBar, Salmon], Chicago=[DeepDishPizza, ItalianBeef, Popcorn], Kyoto=[Yuba, MatchaSweets, KaisekiRyori], Berlin=[Currywurst, Eisbein, DnerKebab], Marseille=[Navette, Bouillabaisse], Lyon=[CoqauVin, Quenelle, SaladeLyonnaise], Hamburg=[Fischbrtchen, Labskaus], Milan=[Risotto, Panettone, Ossobuco], Rome=[Carbonara], Tokyo=[Ramen, Sushi], Naples=[Pizza, CapreseSalad, Sfogliatella], NewYork=[Bagel, HotDog, Cheesecake], LosAngeles=[AvocadoToast, Tacos, Sushi], Osaka=[Okonomiyaki, Takoyaki, Kushikatsu], Montreal=[Bagel, SmokedMeatSandwich, PoudingChmeur], Paris=[Baguette, Croissant, Macaron], Toronto=[Poutine, PeamealBacon, ButterTart]}
  ------
  ```


#### getCountryCityFoodMap

各国ごとの都市とその都市出身者に好まれる食べ物のMapを返すメソッド `getCountryCityFoodMap` を実装してください。

このメソッドは、 `Person` オブジェクトのリストを引数として受け取り、キーが国名、値にQ2で実装した `getCityFoodMap` メソッドの返り値であるMapを要素に持つMapを返却します。

- フォーマット

```
国名1 - 都市名1 : [食べ物1, 食べ物2, ...]
国名1 - 都市名2 : [食べ物1, 食べ物2, ...]
...
国名2 - 都市名1 : [食べ物1, 食べ物2, ...]
...
```

#### プログラムのテスト（動作確認）
1. Q3Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // System.out.println("--- getCountryCityFoodMapの結果 ---");
  // Map<String, Map<String, Set<String>>> data = getCountryCityFoodMap(peopleList);
  // System.out.println(data);
  // System.out.println("------" + "\n");
  ```
2. mainメソッドを実行する
3. 以下出力になっていることを確認する
  ```
  --- getCountryCityFoodMapの結果 ---
  {Canada={Vancouver=[NanaimoBar, Salmon], Montreal=[Bagel, SmokedMeatSandwich, PoudingChmeur], Toronto=[Poutine, PeamealBacon, ButterTart]}, USA={Chicago=[DeepDishPizza, ItalianBeef, Popcorn], NewYork=[Bagel, HotDog, Cheesecake], LosAngeles=[AvocadoToast, Tacos, Sushi]}, Japan={Tokyo=[Ramen, Sushi], Kyoto=[Yuba, MatchaSweets, KaisekiRyori], Osaka=[Okonomiyaki, Takoyaki, Kushikatsu]}, Italy={Milan=[Risotto, Panettone, Ossobuco], Rome=[Carbonara], Naples=[Pizza, CapreseSalad, Sfogliatella]}, France={Marseille=[Navette, Bouillabaisse], Lyon=[CoqauVin, Quenelle, SaladeLyonnaise], Paris=[Baguette, Croissant, Macaron]}, Germany={Munich=[Pretzel, Weisswurst], Berlin=[Currywurst, Eisbein, DnerKebab], Hamburg=[Fischbrtchen, Labskaus]}}
  ------
  ```



#### writeMapToCSV

`getCountryCityFoodMap`で作成した`getCountryCityFoodMap` の返り値のMapを利用してCSVファイルを作成します。
以下のフォーマットになるように、exportData.csvファイルにデータを出力してください。
**好きな食べ物が1つの場合**
```
Country,City,Food1,Food2,Food3
国名,都市名,食べ物1
```

**好きな食べ物が2つの場合**
```
Country,City,Food1,Food2,Food3
国名,都市名,食べ物1,食べ物2
```

**好きな食べ物が3つの場合**
```
Country,City,Food1,Food2,Food3
国名,都市名,食べ物1,食べ物2,食べ物3
```

**完成後のexportData.csvの内容例**

```
Country,City,Food1,Food2,Food3
Canada,Vancouver,NanaimoBar,Salmon,
Canada,Montreal,Bagel,SmokedMeatSandwich,PoudingChmeur
Canada,Toronto,Poutine,PeamealBacon,ButterTart
USA,Chicago,DeepDishPizza,ItalianBeef,Popcorn
USA,NewYork,Bagel,HotDog,Cheesecake
USA,LosAngeles,AvocadoToast,Tacos,Sushi
Japan,Tokyo,Ramen,Sushi,
Japan,Kyoto,Yuba,MatchaSweets,KaisekiRyori
Japan,Osaka,Okonomiyaki,Takoyaki,Kushikatsu
Italy,Milan,Risotto,Panettone,Ossobuco
Italy,Rome,Carbonara,,
Italy,Naples,Pizza,CapreseSalad,Sfogliatella
France,Marseille,Navette,Bouillabaisse,
France,Lyon,CoqauVin,Quenelle,SaladeLyonnaise
France,Paris,Baguette,Croissant,Macaron
Germany,Munich,Pretzel,Weisswurst,
Germany,Berlin,Currywurst,Eisbein,DnerKebab
Germany,Hamburg,Fischbrtchen,Labskaus,
```

#### プログラムのテスト（動作確認）
1. Q3Executeのmainメソッド内で、以下処理のコメントアウトを外す
  ```java
  // writeMapToCSV(EXPORT_PATH, data);
  ```
2. mainメソッドを実行する
3. exportData.csvの内容を見て、以下の内容になっているか確認する
  ```
  Country,City,Food1,Food2,Food3
  Canada,Vancouver,NanaimoBar,Salmon,
  Canada,Montreal,Bagel,SmokedMeatSandwich,PoudingChmeur
  Canada,Toronto,Poutine,PeamealBacon,ButterTart
  USA,Chicago,DeepDishPizza,ItalianBeef,Popcorn
  USA,NewYork,Bagel,HotDog,Cheesecake
  USA,LosAngeles,AvocadoToast,Tacos,Sushi
  Japan,Tokyo,Ramen,Sushi,
  Japan,Kyoto,Yuba,MatchaSweets,KaisekiRyori
  Japan,Osaka,Okonomiyaki,Takoyaki,Kushikatsu
  Italy,Milan,Risotto,Panettone,Ossobuco
  Italy,Rome,Carbonara,,
  Italy,Naples,Pizza,CapreseSalad,Sfogliatella
  France,Marseille,Navette,Bouillabaisse,
  France,Lyon,CoqauVin,Quenelle,SaladeLyonnaise
  France,Paris,Baguette,Croissant,Macaron
  Germany,Munich,Pretzel,Weisswurst,
  Germany,Berlin,Currywurst,Eisbein,DnerKebab
  Germany,Hamburg,Fischbrtchen,Labskaus,

  ```
