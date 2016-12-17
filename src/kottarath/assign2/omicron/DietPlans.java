package kottarath.assign2.omicron;

/**
 * @author Priya
 * Abstract class DietPlans implements the interface DietPlan.
 */
public abstract class DietPlans implements DietPlan {

		//Constructor
		public DietPlans(String fileName,int dayOfWeek,boolean isDinnerDeliveryRequired) {
			//set filename
			this.fileName=fileName;
			//set dayOfWeek as String based on the integer parameter.
			for(Day day:Day.values())//iterates through the values of Enum Day.
			{
				if(day.getValue()==dayOfWeek)
				{
					this.dayOfWeek=day.toString(); 
					break;
				}
			}
			
			//set veganMeal and load recipes
			mealCategory=new VeganMeal(this.fileName);
			
			//set lunch
			lunch=new Lunch(mealCategory);
			//set dinner
			dinner=new Dinner(mealCategory,isDinnerDeliveryRequired);
		}

		//data members
		private Meal lunch;
		private Meal dinner;
		private String fileName;
		private String dayOfWeek;
		private MealCategory mealCategory;
		
		//getters
		public Meal getLunch()
		{
			return lunch;
		}
		public Meal getDinner()
		{
			return dinner;
		}
		public String getDayOfWeek()
		{
			return dayOfWeek;
		}
		public MealCategory getMealCategory()
		{
			return mealCategory;
		}
		
		//setters
		public void setLunch(Lunch lunch)
		{
			this.lunch=lunch;
		}
		public void setDinner(Dinner dinner)
		{
			this.dinner=dinner;
		}
		public void setDayOfWeek(String dayOfWeek)
		{
			this.dayOfWeek=dayOfWeek;
		}
		public void setMealCategory(MealCategory mealCategory)
		{
			this.mealCategory=mealCategory;
		}
		
		//Methods

		/**
		 * Returns description of lunch, dinner and day of week in the following format:
		 * Diet Plan for <day of week>:
		 * Lunch: <Recipe name>:<description>:<calories>:<cost>
		 * Dinner: <Recipe name>:<description>:<calories>:<cost>
		 * @author Priya
		 * @see kottarath.assign2.omicron.DietPlan#showPlan()
		 * @return String
		 */
		@Override
		public String showPlan() {
			//Concatenates lunch details, dinner details and day of week.
			StringBuilder plan=new StringBuilder();
			plan.append("Diet plan for "+getDayOfWeek() +": \n");
			plan.append("Lunch: "+getLunch().getDetails()+"\n");
			plan.append("Dinner: "+getDinner().getDetails());
			
			return plan.toString();
		}

		/**
		 * Returns total cost of lunch and dinner.
		 * @author Priya
		 * @see kottarath.assign2.omicron.DietPlan#getCost()
		 * @return Double
		 */
		@Override
		public double getCostOfPlan() {
			//calculates total cost of lunch and dinner
			return getLunch().getCost()+getDinner().getCost();
		}

}

