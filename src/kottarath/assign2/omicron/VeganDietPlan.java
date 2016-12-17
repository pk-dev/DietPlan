
package kottarath.assign2.omicron;

/**
 * @author Priya
 * Class VeganDietPlan inherits from abstract class DietPlans which implements the interface DietPlan.
 */
public class VeganDietPlan extends DietPlans {

	//Constructor
	/**
	 * @author Priya
	 * @param fileName
	 * @param dayOfWeek
	 * @param isDinnerDeliveryRequired
	 */
	public VeganDietPlan(String fileName,int dayOfWeek,boolean isDinnerDeliveryRequired) {
		super(fileName, dayOfWeek, isDinnerDeliveryRequired);
		
	}
	
}
