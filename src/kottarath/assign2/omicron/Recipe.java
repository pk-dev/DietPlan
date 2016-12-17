
package kottarath.assign2.omicron;

/**
 * @author Priya
 * Class Recipe
 */
public class Recipe {

	//Constructor
	public Recipe() {
		// TODO Auto-generated constructor stub
	}
	
	//data members
	private String name;
	private String description;
	private double cost;
	private int calories;
	
	//getters
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public int getCalories()
	{
		return calories;
	}
	
	//setters
	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setDescription(String description)
	{
		this.description=description;
	}
	
	public void setCost(double cost)
	{
		this.cost=cost;
	}
	
	public void setCalories(int calories)
	{
		this.calories=calories;
	}
	
	//Methods
	

}
