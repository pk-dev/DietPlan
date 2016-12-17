package kottarath.assign2.omicron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Priya
 * Abstract class Category implements the functionalities specified by the interface MealCategory.
 */
public abstract class Category implements MealCategory {
	
		public Category(String fileName)
		{
			//loads recipes from the input file to recipeList
			loadRecipes(fileName);
			//set uniqueRecipeList. 
			uniqueRecipeList=getRecipeList();
		}

		//data members
		private ArrayList<Recipe> recipeList=new ArrayList<Recipe>();
		public final String FILE_PATH="./Recipes/";//folder path where input files are located.
		
		//uniqueRecipeList is used to avoid repetition of same recipe for both lunch and dinner for same day.
		private static ArrayList<Recipe> uniqueRecipeList=new ArrayList<Recipe>();
		
		//getter
		public ArrayList<Recipe> getRecipeList()
		{
			//returns a copy of recipeList to prevent callers from setting values using getter
			return new ArrayList<Recipe>(recipeList);
		}
		
		//setter
		public void setRecipeList(ArrayList<Recipe> recipeList)
		{
			this.recipeList=recipeList;
		}
		
		
		//Methods

		/** @author Priya
		 * @see kottarath.assign2.omicron.MealCategory#showRecipes()
		 * @return ArrayList 
		 * Returns a list of recipes.
		 */
		@Override
		public ArrayList<Recipe> showRecipes() {
			// returns a list of recipes
			return getRecipeList();
		}

		/** @author Priya
		 * @see kottarath.assign2.omicron.MealCategory#getARecipe()
		 * @return Recipe class
		 * Returns a random recipe from the list of recipes 
		 * avoiding repetition of same recipe for a day.
		 */
		@Override
		public Recipe getARecipe() {
			//Get a random recipe corresponding to mealCategory chosen.
			//No two recipes chosen for the same MealCategory object should be the same.
			//choose a random index of the uniqueRecipeList
			int randomIndex=new Random().nextInt(uniqueRecipeList.size());
			Recipe newRecipe=uniqueRecipeList.get(randomIndex);
			//remove the selected recipe from uniqueRecipeList to avoid future repetitions
			uniqueRecipeList.remove(randomIndex);
			//return the recipe item at random index chosen
			return newRecipe;
		}
		

		/**@author Priya
		 * @see kottarath.assign2.omicron.MealCategory#loadRecipes(java.lang.String)
		 * Read data from file and load recipeList
		 */
		@Override
		public void loadRecipes(String fileName) {
			//declare variables required to read/process file data
			ArrayList<Recipe> recipes=new ArrayList<Recipe>();
			Recipe recipe;
			BufferedReader reader;
			
			//Check if file exists in the given path. Print error message if the file is missing.
			File file=new File(FILE_PATH+fileName);
			if(file.exists() && !file.isDirectory())
			{
				try {
					//read data from file line by line
					reader=new BufferedReader(new FileReader(file));
					String line;
					while((line=reader.readLine())!=null)
					{
						//validate format of each line
						//records with invalid format are discarded
						//Expected format of each record:
						//recipeName:description:cost:calories
						//recipeName - must start with an alphabet, can contain only alphabets and white space.
						//description - must start with alphabet or number, can contain only alphabets,numbers,white space,comma and dot.
						//cost - must be a number, If it is a decimal number, maximum decimal scale allowed is 2.
						//calories - whole number.
						Pattern pattern=Pattern.compile("^([a-zA-Z])([a-zA-Z\\s]*)[:][a-zA-Z0-9]([a-zA-Z\\s0-9.,]*)[:]([0-9]+([.][0-9]{1,2})*)[:][0-9]+$");
						Matcher matcher=pattern.matcher(line);
						if(matcher.matches())
						{
						//split the line using ':' as the separator and extract each data
						String[] data=line.split(":");
						
							//assign values to recipe object
							recipe=new Recipe();
							recipe.setName(data[0]);
							recipe.setDescription(data[1]);
							recipe.setCost(Double.parseDouble(data[2]));
							recipe.setCalories(Integer.parseInt(data[3]));
							//add recipe to recipes
							recipes.add(recipe);
						
						}
						else
							System.out.println("Error:File data is in incorrect format. The record "+line+" is ignored.");
							
					}
				}
				catch (IOException e) 
				{
					System.out.println("Exception:"+e.getMessage());
				}
				catch(Exception e)
				{
					System.out.println("Exception:"+e.getMessage());
				}
				finally{
					//set recipeList to the new list of recipes
					setRecipeList(recipes);
				}
				
			}
			else
				System.out.println("Error: File does not exist. Please provide a valid file path and file name.");
			
			
		}


}
