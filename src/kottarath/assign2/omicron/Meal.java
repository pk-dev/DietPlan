package kottarath.assign2.omicron;

/**
 * @author Priya
 * Interface Meal enforces the functionalities all meals should have.
 */
public interface Meal {
	Recipe getARecipe();
	int showCalories();
	double getCost();
	String getDetails();
}
