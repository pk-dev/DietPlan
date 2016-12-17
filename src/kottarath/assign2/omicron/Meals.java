
package kottarath.assign2.omicron;


/**
 * @author Priya
 * Class Meals implements the interface Meal
 * Meals is the parent class for different meals(Lunch, Dinner)
 *
 */
public class Meals implements Meal {

	//Constructors
	
	public Meals(MealCategory mealCategory)
	{
		//set the value of mealCategory with the parameter value
		this.mealCategory=mealCategory;
		//set recipe to a random recipe under the mealCategory
		this.recipe=getARecipe();
	}
	
	//data members
	private Recipe recipe=new Recipe();
	private MealCategory mealCategory;
	
	//getters
	public Recipe getRecipe()
	{
		return recipe;
	}
	public MealCategory getMealCategory()
	{
		return mealCategory;
	}
	
	//setters
	public void setRecipe(Recipe recipe)
	{
		this.recipe=recipe;
	}
	public void setMealCategory(MealCategory mealCategory)
	{
		this.mealCategory=mealCategory;
	}
	
	//Methods

	/**
	 * @author Priya
	 * @see kottarath.assign2.omicron.Meal#getARecipe()
	 * @return Recipe class
	 * Returns a random Recipe object corresponding to the mealCategory chosen.
	 */
	@Override
	public Recipe getARecipe() {
		
		return getMealCategory().getARecipe();
		
	}

	/**@author Priya
	 * @see kottarath.assign2.omicron.Meal#getCalories()
	 * @return Integer 
	 * Returns number of calories in the recipe chosen.
	 */
	@Override
	public int showCalories() {
		//get calories in the random recipe chosen.
		return getRecipe().getCalories();
	}

	/**@author Priya
	 * @see kottarath.assign2.omicron.Meal#getCost()
	 * @return Double
	 * Returns the cost of recipe chosen
	 */
	@Override
	public double getCost() {
		return getRecipe().getCost();
	}

	/**@author Priya
	 * @see kottarath.assign2.omicron.Meal#getDetails()
	 * @return String
	 * Returns a concatenated string with recipe name, description, calories and cost
	 * in the following format.
	 * <recipe name> : <description> : <calories> : $<cost>
	 */
	@Override
	public String getDetails() {
		StringBuilder recipeDetails=new StringBuilder();
		//Colon (:) is used as a separator
		recipeDetails.append(getRecipe().getName() + " : ");
		recipeDetails.append(getRecipe().getDescription()+ " : ");
		recipeDetails.append(getRecipe().getCalories()+ " : ");
		recipeDetails.append(String.format("$%.2f", getRecipe().getCost()));
		
		return recipeDetails.toString();
	}

}
