package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;
import java.io.IOException;
import java.util.List;

public class JSONDataHandler implements DataHandler {

    @Override
    public String getMode() {
        return "JSON";
    }

    @Override
    public List<Recipe> readData() throws IOException {
        return null;
    }

    @Override
    public void writeData(Recipe recipe) throws IOException {
    }

    @Override
    public List<Recipe> searchData(String keyword) throws IOException {
        return null;
    }

}