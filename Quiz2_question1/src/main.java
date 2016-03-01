import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
		// lines 9-18 takes input from the user about the tuition and corresponding payments
		
		System.out.printf("How much was the cost of your tuition this year?");
		double initialTuitionCost = user_input.nextDouble();
		System.out.printf("What is the percentage increases in tuition for each year?");
		double tuitionPercentageIncrease = user_input.nextDouble();
		tuitionPercentageIncrease = tuitionPercentageIncrease/100;
		System.out.printf("What is your fixed APR on your student tuition?");
		double fixedAPRTuition = user_input.nextDouble();
		fixedAPRTuition = fixedAPRTuition/100;
		System.out.printf("And how long do you plan on paying off these loans?");
		double term = user_input.nextDouble();
		user_input.close();
		
		/**lines 24-25 Calls the methods tuitionTotal and monthlyPayments
		It them stores them to Tuition and monthlyPayments **/
		
		double Tuition = tuitionTotal(initialTuitionCost, tuitionPercentageIncrease);
		double monthlyPayments = monthlyPayments(Tuition, term, fixedAPRTuition);
		
		// lines 29 and 30 print the two results of this program out to the user to see.
		
		System.out.printf("The total amount you will owe on tuition is $%.2f%n", Tuition);
		System.out.printf("The amount you will need to pay each month to pay off $%.2f in %.0f years is $%.2f.", Tuition, term, monthlyPayments);
	}

	/** This method computes the total tuition after four years
	 * @param startingTuition
	 * @param tuitionPercentage
	 * @return totalSum
	 */
	public static double tuitionTotal(double startingTuition, double tuitionPercentage){
		double totalSum = 0;
		//counter must start at zero since first year of college has no percentage increase
		for (int counter=0; counter < 4; counter++){
			totalSum += startingTuition * (Math.pow(1+tuitionPercentage,counter));
		}
		return totalSum;
	}
	/** This method computes the passer rating and prints out the passer rating
	 * @param tuition
	 * @param years
	 * @param rate
	 * @return monthlyPayments
	 * This method assumes the interest is accrued on an annual basis
	 */
	public static double monthlyPayments(double tuition, double years, double rate){
		//This would be similar if we let the rate accrue monthly by changing years in Math.pow() to 12*years
		double monthlyPayments = (tuition * (Math.pow(1+rate, years)))/(12*years);
		return monthlyPayments;		
	}
}

