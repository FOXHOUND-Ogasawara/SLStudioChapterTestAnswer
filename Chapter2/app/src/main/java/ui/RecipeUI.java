package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
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
                        System.out.println("Exit the application.");
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
        List<String> recipes = fileHandler.readRecipes();
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }
        System.out.println();
        System.out.println("Recipes:");
        System.out.println("-----------------------------------");
        for (String recipe : recipes) {
            String[] parts = recipe.split(",", 2);
            System.out.println("Recipe Name: " + parts[0]);
            if (parts.length > 1) {
                System.out.println("Main Ingredients: " + parts[1]);
            }
            System.out.println("-----------------------------------");
        }
    }

    private void addNewRecipe() throws IOException {
        System.out.println();
        System.out.print("Enter recipe name: ");
        String name = reader.readLine();
        System.out.print("Enter main ingredients (comma separated): ");
        String ingredients = reader.readLine();
        fileHandler.addRecipe(name, ingredients);
        System.out.println("Recipe added successfully.");
    }

    private void searchRecipe() throws IOException {
        System.out.print("Enter search query (e.g., 'name=Tomato&ingredient=Garlic'): ");
        String query = reader.readLine().toLowerCase();
        String[] criteria = query.split("&");
        List<String> recipes = fileHandler.readRecipes();
        boolean found = false;

        System.out.println("\nSearch Results:");
        for (String recipe : recipes) {
            boolean matches = true;
            for (String criterion : criteria) {
                String[] keyValue = criterion.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];
                    if ("name".equals(key) && !recipe.toLowerCase().contains(value)) {
                        matches = false;
                        break;
                    }
                    if ("ingredient".equals(key) && !recipe.toLowerCase().contains(value)) {
                        matches = false;
                        break;
                    }
                }
            }
            if (matches) {
                System.out.println(recipe);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recipes found matching the criteria.");
        }
    }

}