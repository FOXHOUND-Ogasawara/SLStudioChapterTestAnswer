[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=14591342&assignment_repo_type=AssignmentRepo)
# Chapter3アセスメント

- ## 試験概要

  以下の説明を読み、各設問に解答し提出してください。

  - 実装前に処理フローをコメントアウトで記述すること
  - 実装完了後、自己採点（動作確認）を行うこと
  - 自己採点完了後、次の設問に進むこと
  - 全てのプログラムが実行可能であること
  - コンパイルエラー状態での提出は禁止
  - 出力内容やメソッド名が指示通りでない場合は不正解となる

  ## 設問の前提

  - `src/main/java/App.java` - 実行用クラス

  - `src/main/java/ui/RecipeUI.java` - 表示に関連したクラス

  - `src/main/resources/recipes.csv` - レシピのデータ(CSV)

    - ファイルの各行は、単一のレシピを表し、レシピ名と主な材料がカンマ区切りで記載されています。

    - 誤って消してしまったりした場合は以下の内容をコピーしてください。

      ```
      Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock
      Chicken Curry,Chicken, Curry Powder, Onion, Garlic, Ginger
      Beef Stew,Beef, Potatoes, Carrots, Onion, Beef Stock
      Vegetable Stir Fry,Broccoli, Carrot, Bell Peppers, Soy Sauce
      Spaghetti Bolognese,Ground Beef, Tomato Sauce, Onion, Garlic, Spaghetti
      Caesar Salad,Romaine Lettuce, Croutons, Parmesan Cheese, Caesar Dressing
      Grilled Salmon,Salmon, Lemon, Garlic, Olive Oil
      Pancakes,Flour, Milk, Egg, Butter, Maple Syrup
      Chocolate Cake,Flour, Cocoa Powder, Baking Powder, Eggs, Sugar
      Lasagna,Ground Beef, Lasagna Noodles, Ricotta Cheese, Tomato Sauce
      Tacos,Ground Beef, Taco Shells, Lettuce, Tomato, Cheese
      French Toast,Bread, Egg, Milk, Cinnamon, Sugar
      Mushroom Risotto,Arborio Rice, Mushrooms, Onion, Chicken Stock, Parmesan Cheese
      Quiche Lorraine,Eggs, Cream, Bacon, Cheese, Pie Crust
      Ratatouille,Eggplant, Zucchini, Bell Pepper, Tomato, Onion
      Chicken Alfredo,Chicken, Fettuccine, Cream, Parmesan Cheese, Garlic
      BBQ Ribs,Pork Ribs, BBQ Sauce, Garlic, Brown Sugar
      Vegetable Soup,Carrots, Potatoes, Celery, Tomato, Vegetable Stock
      Macaroni and Cheese,Macaroni, Cheddar Cheese, Milk, Butter, Flour
      Banana Bread,Bananas, Flour, Sugar, Baking Soda, Eggs
      ```

## 設問1: クラスの実装

### 目安時間

5分

### 設問

`com.recipeapp.model`パッケージ内に、レシピ管理アプリのデータモデルとして`Recipe`クラスと`Ingredient`クラスを作成してください。

### ステップ1： クラスの実装

| クラス名 | 属性          | 型                 | 説明               |
| -------- | ------------- | ------------------ | ------------------ |
| `Recipe` | `name`        | `String`           | レシピの名前       |
|          | `ingredients` | `ArrayList<Ingredient>` | レシピの材料リスト |

| メソッド名       | 戻り値の型         | 引数                                        | 説明                         |
| ---------------- | ------------------ | ------------------------------------------- | ---------------------------- |
| コンストラクタ   |                    | `String name, ArrayList<Ingredient> ingredients` | レシピ名と材料リストを初期化 |
| `getName`        | `String`           | なし                                        | レシピ名を返す               |
| `getIngredients` | `ArrayList<Ingredient>` | なし                                        | 材料リストを返す             |



| クラス名     | 属性   | 型       | 説明       |
| ------------ | ------ | -------- | ---------- |
| `Ingredient` | `name` | `String` | 材料の名前 |

| メソッド名     | 戻り値の型 | 引数          | 説明           |
| -------------- | ---------- | ------------- | -------------- |
| コンストラクタ |            | `String name` | 材料名を初期化 |
| `getName`      | `String`   | なし          | 材料名を返す   |

### ステップ2： 実装の確認

- 実装したクラスにコンパイルエラーが起きていないことを確認する



## 設問2: `DataHandler`インターフェースの定義

### 目安時間

5分

### 設問

`com.recipeapp.datahandler`パッケージ内に、`DataHandler`インターフェースを定義してくださいい。

| インターフェース名 | メソッド名   | 戻り値の型     | 引数             | 説明                                                         |
| ------------------ | ------------ | -------------- | ---------------- | ------------------------------------------------------------ |
| `DataHandler`      | getMode      | String         | なし             | 現在のモードを返します。                                     |
|                    | `readData`   | `ArrayList<Recipe>` | なし             | レシピデータを読み込み、`Recipe`オブジェクトのリストとして返します。 |
|                    | `writeData`  | `void`         | `Recipe recipe`  | 指定された`Recipe`オブジェクトを追加します。                 |
|                    | `searchData` | `ArrayList<Recipe>` | `String keyword` | 指定されたキーワードでレシピを検索し、一致する`Recipe`オブジェクトのリストを返します。 |

### ステップ2： 実装の確認

- 実装したクラスにコンパイルエラーが起きていないことを確認する

##  

## 設問3: インタフェースの実装クラスの作成

`DataHandler`インタフェースを実装したクラスを作成してください。

CSV (Comma-Separated Values)とJSON (JavaScript Object Notation)という2つの形式に応じたクラスを作成します。

CSVは「カンマ区切り値」の略で、データをカンマで区切って記述するテキスト形式のファイルフォーマットです。

```
Tomato Soup,Tomatoes, Onion, Garlic, Vegetable Stock
Chicken Curry,Chicken, Curry Powder, Onion, Garlic, Ginger
Beef Stew,Beef, Potatoes, Carrots, Onion, Beef Stock
```

JSONは「JavaScriptオブジェクト記法」の略で、データをテキスト形式で記述するための軽量なフォーマットです。

```
[
    {
      "name": "Tomato Soup",
      "ingredients": ["Tomatoes", "Onion", "Garlic", "Vegetable Stock"]
    },
    {
      "name": "Chicken Curry",
      "ingredients": ["Chicken", "Curry Powder", "Onion", "Garlic", "Ginger"]
    },
    {
      "name": "Beef Stew",
      "ingredients": ["Beef", "Potatoes", "Carrots", "Onion", "Beef Stock"]
    }
]
```

### ステップ1：インタフェースの実装

#### CSV形式に対応したクラス

`com.recipeapp.datahandler`パッケージに`DataHandler`インターフェースを実装した`CSVDataHandler.java`クラスを作成してください。

| フィールド名 | 型       | 説明                                      |
| ------------ | -------- | ----------------------------------------- |
| `filePath`   | `String` | レシピデータを格納するCSVファイルのパス。 |

| コンストラクタ                    | 説明                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| `CSVDataHandler()`                | フィールド`filePath`に`app/src/main/resources/recipes.csv`を代入する |
| `CSVDataHandler(String filePath)` | フィールド`filePath`に引数を代入する                         |


| メソッド名   | 説明                                                         |
| ------------ | ------------------------------------------------------------ |
| `getMode`      | 文字列`CSV`を返してください。                                |
| `readData`   | 以降の設問で処理を実装するため定義し、nullをreturnしてください。 |
| `writeData`  | 以降の設問で処理を実装するため定義のみ行います。             |
| `searchData` | 以降の設問で処理を実装するため定義し、nullをreturnしてください。 |

#### JSON形式に対応したクラス

`com.recipeapp.datahandler`パッケージに`DataHandler`インターフェースを実装した`JSONDataHandler.java`クラスを作成してください。

| メソッド名   | 説明                                                       |
| ------------ | ---------------------------------------------------------- |
| `getMode`      | 文字列`JSON`を返してください。                             |
| `readData`   | 処理の実装は行わないので定義し、nullをreturnしてください。 |
| `writeData`  | 処理の実装は行わないので定義のみ行います。                 |
| `searchData` | 処理の実装は行わないので定義し、nullをreturnしてください。 |

### ステップ2： 実装の確認

- 実装したクラスにコンパイルエラーが起きていないことを確認する

## 設問4: データハンドラーの選択と初期化

### 目安時間

15分

### 設問

`com.recipeapp`パッケージの`App`クラスに処理を追加し、ユーザーがファイル形式を選択できるように実装してください。

### 仕様

- ユーザーの選択に応じて、`CSVDataHandler`または`JSONDataHandler`のインスタンスを生成する
  - 「1」を選択した場合、`CSVDataHandler`インスタンスを生成する
  - 「2」を選択した場合、`JSONDataHandler`インスタンスを生成する
- 不正な入力（「1」「2」以外）が与えられた場合、`CSVDataHandler`インスタンスを生成する
- 選択されたデータハンドラーを`com/recipeapp`パッケージの`RecipeUI`に渡し、`displayMenu`メソッドを呼び出してメインメニューを表示します。

### ステップ1：プログラムの設計

コメントアウトを使用してプログラムの流れを説明する内容を記述してください。

### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

#### テストケース1

- 「1」を選択し、`Current mode: CSV`と表示された後に、メインメニューが表示されることを確認します。
- 「2」を選択し、`Current mode: JSON`と表示された後に、メインメニューが表示されることを確認します。
- 「3」を入力し、`Current mode: CSV`と表示された後に、メインメニューが表示されることを確認します。

## 設問5: レシピ一覧表示機能の実装例

### 目安時間

30分

### 設問

`recipes.csv`ファイルからレシピデータを読み込み、コンソールに一覧表示する機能をステップに従い作成してください。

### ステップ1：プログラムの設計

以下のメソッドを定義し、コメントアウトを使用してプログラムの流れを説明する内容を記述してください。

`src/main/java/com/recipeapp/datahandler/CSVDataHandler.java` 

| メソッド名    | 戻り値の型     | 引数 | 説明                                                         |
| ------------- | -------------- | ---- | ------------------------------------------------------------ |
| `readData` | `ArrayList<Recipe>` | なし | `recipes.csv`からレシピデータを読み込み、それをリスト形式で返します。 |

`src/main/java/com/recipeapp/ui/RecipeUI.java`

| メソッド名       | 戻り値の型 | 引数 | 説明                                                         |
| ---------------- | ---------- | ---- | ------------------------------------------------------------ |
| `displayRecipes` | `void`     | なし | `DataHandler`から読み込んだレシピデータを整形してコンソールに表示します。 |

- IOExceptionが発生したときは`Error reading file: 例外のメッセージ`と表示すること
- 表示形式は以下の出力例を再現すること

```
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 1

Recipes:
-----------------------------------
Recipe Name: Tomato Soup
Main Ingredients: Tomatoes, Onion, Garlic, Vegetable Stock
-----------------------------------
Recipe Name: Chicken Curry
Main Ingredients: Chicken, Curry Powder, Onion, Garlic, Ginger
-----------------------------------
Recipe Name: Beef Stew
Main Ingredients: Beef, Potatoes, Carrots, Onion, Beef Stock
-----------------------------------

以下省略
```



### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

#### テストケース1

- `recipes.csv`ファイルに複数のレシピが記載されている場合、すべてのレシピが正しく一覧表示されることを確認します。

#### テストケース2

- `recipes.csv`ファイルが空の場合、"No recipes available."というメッセージが表示されることを確認します。



## 設問6: 新規登録機能

### 目安時間

30分

### 設問

ユーザーからレシピ名と主な材料を入力させ、これらの情報を`recipes.csv`ファイルに新しい行として追加する機能をステップに従い作成してください。

### ステップ1：プログラムの設計

以下のメソッドを定義し、コメントアウトを使用してプログラムの流れを説明する内容を記述してください。

`src/main/java/com/recipeapp/datahandler/CSVDataHandler.java`

| メソッド名  | 戻り値の型 | 引数     | 説明                                                         |
| ----------- | ---------- | -------- | ------------------------------------------------------------ |
| `writeData` | `void`     | `Recipe` | 新しいレシピを`recipes.csv`に追加します。レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。 |

`src/main/java/com/recipeapp/ui/RecipeUI.java`

| メソッド名     | 戻り値の型 | 引数 | 説明                                                         |
| -------------- | ---------- | ---- | ------------------------------------------------------------ |
| `addNewRecipe` | `void`     | なし | ユーザーからレシピ名と主な材料を入力させ、`DataHandler`を使用して`recipes.csv`に新しいレシピを追加します。 |

- IOExceptionが発生したときは`Failed to add new recipe: 例外のメッセージ`と表示すること
- 材料の入力は`done`と入力するまで入力を受け付けること
- 表示形式は以下の出力例を再現すること

```
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 2

Adding a new recipe.
Enter recipe name: A
Enter ingredients (type 'done' when finished):
Ingredient: a
Ingredient: b
Ingredient: c
Ingredient: done
Recipe added successfully.
```

### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

#### **テストケース1**

- レシピ名と主な材料を入力し、`"Recipe added successfully."`というメッセージが表示されること
- 登録した内容が`recipes.csv`ファイルに正しく追加されていること



## 設問7: 検索機能

### 目安時間

50分

### 設問

ユーザーが指定した条件（レシピ名や主な材料）に基づいて`recipes.csv`ファイル内のレシピを検索し、一致するものを表示する機能をステップに従い作成してください。

`src/main/java/com/recipeapp/datahandler/CSVDataHandler.java`

| メソッド名   | 戻り値の型     | 引数     | 説明                                                         |
| ------------ | -------------- | -------- | ------------------------------------------------------------ |
| `searchData` | `ArrayList<Recipe>` | `String` | 検索クエリを受け取り、そのクエリに基づいてレシピを検索し、一致するレシピを返します。 |

`src/main/java/com/recipeapp/ui/RecipeUI.java`

| メソッド名     | 戻り値の型 | 引数 | 説明                                                         |
| -------------- | ---------- | ---- | ------------------------------------------------------------ |
| `searchRecipe` | `void`     | なし | ユーザーから検索クエリを入力させ、`DataHandler`から検索結果を受け取り、受け取った結果をコンソールに表示します。 |

- 検索クエリは`name`と`ingredient`のキーをサポートし、`&`で複数の条件を組み合わせることができる。
  - 例: `name=Soup&ingredient=Tomato`は、名前に"Soup"を含み、材料に"Tomato"を含むレシピを検索する。

- 一致するレシピがある場合は、そのレシピの名前と主な材料を表示する。
- 一致するレシピがない場合は、`No matching recipes found.`と出力する。
- IOExceptionが発生したときは`Failed to search recipes: 例外のメッセージ`と表示すること
- 表示形式は以下の出力例を再現すること

```
// 一致するレシピがある場合
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 3
Enter search query (e.g., 'name=Tomato&ingredient=Garlic'): name=Soup&ingredient=Tomato

Matching Recipes:
Name: Tomato Soup
Ingredients: Tomatoes, Onion, Garlic, Vegetable Stock,

Name: Vegetable Soup
Ingredients: Carrots, Potatoes, Celery, Tomato, Vegetable Stock,

```



```
// 一致するレシピがない場合
Main Menu:
1: Display Recipes
2: Add New Recipe
3: Search Recipe
4: Exit Application
Please choose an option: 3
Enter search query (e.g., 'name=Tomato&ingredient=Garlic'): pizza

No matching recipes found.
```



### ステップ2：プログラムの実装

コメントアウトで記述したプログラムの流れに従って、実装してください。

### ステップ3：プログラムのテスト（動作確認）

以下のテストケースに従ってプログラムの動作を確認してください。

#### **テストケース1**

- 検索クエリ`name=Soup&ingredient=Tomato`を入力し、条件に一致するレシピが表示されることを確認します。

#### **テストケース2**

- 検索クエリ`name=Pizza`を入力し、`No matching recipes found.`というメッセージが表示されることを確認します。
