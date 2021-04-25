/*
 * Project Description:
 * We have 1000 replicate populations, each starting with one individual.
 * Every generation, each individual independently either dies or divides
 * To form two individuals, each happening with 50% probability.
 * 
 * 
 * To plot:
 * a) the number of surviving (non-extinct) populations
 * b) the average number of individuals per surviving population
 * c) the total number of individuals summed over all surviving populations
 */
public class PopulationDriver {
	private static int totalSurvivingPops = 0;
	private static int totalSurvivingIndivs = 0;
	private static double avgSurviving = 0;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			runGenerations(new Population(), 10);
		}
		//Rounds data to first two decimal points.
		avgSurviving = ((double) totalSurvivingIndivs/totalSurvivingPops) * 100;
		avgSurviving = Math.floor(avgSurviving) / 100;
		
		System.out.print(totalSurvivingPops + " ");
		System.out.print(totalSurvivingIndivs + " ");
		System.out.println(avgSurviving);
	}
	
	private static void runGenerations(Population population, int generations) {
		for (int i = 0; i < generations; i++) {
			population.generation();
		}
		
		if (population.isExtinct() == false) {
			totalSurvivingPops++;
			totalSurvivingIndivs += population.getSize();
		}
	}
}
