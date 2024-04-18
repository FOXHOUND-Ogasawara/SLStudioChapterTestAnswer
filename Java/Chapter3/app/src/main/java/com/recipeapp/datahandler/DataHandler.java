package com.recipeapp.datahandler;

import com.recipeapp.model.Recipe;

import java.io.IOException;
import java.util.List;

public interface DataHandler {
    public String getMode();
    public List<Recipe> readData() throws IOException;
    public void writeData(Recipe recipe) throws IOException;
    public List<Recipe> searchData(String keyword) throws IOException;
}