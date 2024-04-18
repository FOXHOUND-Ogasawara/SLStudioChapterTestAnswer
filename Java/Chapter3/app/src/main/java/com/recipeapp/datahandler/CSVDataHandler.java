package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import com.recipeapp.model.Ingredient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVDataHandler implements DataHandler {
    private final String filePath;

    public CSVDataHandler() {
        filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getMode() {
        return "CSV";
    }

    @Override
    public List<Recipe> readData() throws IOException {
        List<Recipe> recipes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                String name = parts[0].trim();
                List<Ingredient> ingredients = new ArrayList<>();
                if (parts.length > 1) {
                    for (String ingredientName : parts[1].split(",")) {
                        ingredients.add(new Ingredient(ingredientName.trim()));
                    }
                }
                recipes.add(new Recipe(name, ingredients));
            }
        }
        return recipes;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
	        bw.write(recipe.getName());
					for (Ingredient ingredient : recipe.getIngredients()) {
							bw.write("," + ingredient.getName());
					}
							bw.newLine();
        }
    }

    @Override
    public List<Recipe> searchData(String query) throws IOException {
        List<Recipe> allRecipes = readData();
        List<Recipe> filteredRecipes = new ArrayList<>();
        String[] queries = query.split("&");
        for (Recipe recipe : allRecipes) {
            boolean matches = true;
            for (String q : queries) {
                String[] parts = q.split("=");
                if (parts.length != 2) {
										continue;
								}
                String key = parts[0];
                String value = parts[1].toLowerCase();
                if ("name".equals(key) && !recipe.getName().toLowerCase().contains(value)) {
                    matches = false;
                    break;
                }
                if ("ingredient".equals(key)) {
                    boolean ingredientMatch = false;
                    for (Ingredient ingredient : recipe.getIngredients()) {
                        if (ingredient.getName().toLowerCase().contains(value)) {
                            ingredientMatch = true;
                            break;
                        }
                    }
                    if (!ingredientMatch) {
												matches = false;
										}
                }
                if (!matches) {
										break;
								}
            }
            if (matches) filteredRecipes.add(recipe);
        }
        return filteredRecipes;
    }

}