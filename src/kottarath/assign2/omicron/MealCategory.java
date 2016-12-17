package kottarath.assign2.omicron;

import java.util.ArrayList;

/**
 * @author Priya
 * Interface MealCategory enforces the necessary 
 * functionalities required for different meal categories.
 * 
 */
public interface MealCategory {
	ArrayList<Recipe> showRecipes();
	Recipe getARecipe();
	void loadRecipes(String fileName);

}
