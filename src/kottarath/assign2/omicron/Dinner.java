package kottarath.assign2.omicron;

/**
 * @author Priya
 * Dinner class inherits from Meals class which implements Meal.
 * It contains logic specific to Dinner.
 */
public class Dinner extends Meals {

	//Constructor
	public Dinner(MealCategory mealCategory, boolean delivery) {
		super(mealCategory);
		this.delivery=delivery;
	}
	
	//data members
	private boolean delivery;
	private final double DELIVERY_FEE=5.0;
	
	//getters
	public boolean isDelivery()
	{
		return delivery;
	}
	
	//setters
	public void setDelivery(boolean delivery)
	{
		this.delivery=delivery;
	}
	
	
	//Methods
	
	/**
	 * Returns the cost of the recipe + delivery fee.
	 * @author Priya
	 * @see kottarath.assign2.omicron.Meals#getCost()
	 * @return Double
	 */
	@Override
	public double getCost()
	{
		//adds delivery fee to cost of recipe if 'delivery' is true
		if(isDelivery())
			return super.getCost()+DELIVERY_FEE;
		//else return only cost of the recipe
		return super.getCost();
	}
	
	/**
	 * Returns a concatenated string with recipe name, description, calories and total cost
	 * Total cost includes cost of the recipe and delivery fee.
	 * @author Priya
	 * @see kottarath.assign2.omicron.Meals#getDetails()
	 * @return String
	 */
	@Override
	public String getDetails()
	{
		StringBuilder recipeDetails=new StringBuilder();
		//Colon (:) is used as a separator
		recipeDetails.append(getRecipe().getName() + " : ");
		recipeDetails.append(getRecipe().getDescription()+ " : ");
		recipeDetails.append(showCalories()+ " : ");
		recipeDetails.append(String.format("$%.2f", getCost()));
		
		return recipeDetails.toString();
	}

}
