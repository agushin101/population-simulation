import java.util.Random;

public class Population {
	//Represents the number of living units.
	private int size;
	private boolean extinct;
	
	public Population() {
		this.size = 1;
		this.extinct = false;
	}
	
	/*
	 * Generates numbers 0 and 1 with 50% probability each.
	 * 0 represents extinction of the unit, 1 represents division.
	 */
	public void generation() {
		Random random = new Random();
		//this.size shifts constantly---need to store the initial size before division starts.
		int startingPopulation = size;

		for (int i = 0; i < startingPopulation; i++) {
			int survives = random.nextInt(2);
			
			if (survives == 0) {
				size--;
			}
			
			else {
				size++;
			}
		}
		
		if (size == 0) {
			extinct = true;
		}
	}
	
	/*
	 * Returns whether or not the population is extinct.
	 */
	public boolean isExtinct() {
		return this.extinct;
	}
	
	/*
	 * Returns the size of the population.
	 */
	public int getSize() {
		return this.size;
	}
	
}
