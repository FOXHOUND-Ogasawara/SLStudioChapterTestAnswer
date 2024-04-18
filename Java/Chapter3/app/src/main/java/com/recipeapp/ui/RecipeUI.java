package com.recipeapp.ui;

import com.recipeapp.model.Recipe;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();
                        break;
                    case "2":
                        addNewRecipe();
                        break;
                    case "3":
                        searchRecipe();
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes() {
        try {
            List<Recipe> recipes = dataHandler.readData();
            if (recipes.isEmpty()) {
                System.out.println("No recipes available.");
            }
            System.out.println();
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for (Recipe recipe : recipes) {
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.print("Ingredients: ");
                for (Ingredient ingredient : recipe.getIngredients()) {
                    System.out.print(ingredient.getName() + ", ");
                }
                System.out.println();
                System.out.println("-----------------------------------");
            }
        } catch (IOException e) {
            System.out.println("Failed to read recipes: " + e.getMessage());
        }
    }

    private void addNewRecipe() {
        try {
            System.out.println("Adding a new recipe.");
            System.out.print("Enter recipe name: ");
            String name = reader.readLine().trim();

            List<Ingredient> ingredients = new ArrayList<>();
            String ingredientInput = "";
            System.out.println("Enter ingredients (type 'done' when finished):");

            while (true) {
                System.out.print("Ingredient: ");
                ingredientInput = reader.readLine().trim();
                if ("done".equals(ingredientInput)) {
                    break;
                }
                ingredients.add(new Ingredient(ingredientInput));
            }

            Recipe newRecipe = new Recipe(name, ingredients);
            dataHandler.writeData(newRecipe);
            System.out.println("Recipe added successfully.");
        } catch (IOException e) {
            System.out.println("Failed to add new recipe: " + e.getMessage());
        }
    }


    private void searchRecipe() {
        try {
            System.out.print("Enter search query (e.g., 'name=Tomato&ingredient=Garlic'): ");
            String query = reader.readLine();
            List<Recipe> results = dataHandler.searchData(query);
            if (results.isEmpty()) {
                System.out.println("No matching recipes found.");
            } else {
                System.out.println("Matching Recipes:");
                for (Recipe recipe : results) {
                    System.out.println("Name: " + recipe.getName());
                    System.out.print("Ingredients: ");
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        System.out.print(ingredient.getName() + ", ");
                    }
                    System.out.println("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to search recipes: " + e.getMessage());
        }
    }

}