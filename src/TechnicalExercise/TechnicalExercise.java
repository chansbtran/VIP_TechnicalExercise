package TechnicalExercise;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * @author	Chan Tran
 * @version	03/19/2019
 */
public class TechnicalExercise {

	private static int sum = 10;
	private List<Integer[]> pairs;
	
	public static void main(String args[]) {
		System.out.print("Please enter the integers you'd like to compute (comma delimited): ");
		Scanner user = new Scanner(System.in);
		String intInput = user.nextLine();
		user.close();
		
		TechnicalExercise te = new TechnicalExercise();
		try {
			te.test(intInput);
		}
		catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	/*
	 * Empty constructor, initializes field variable pairs.
	 */
	public TechnicalExercise() {
		pairs = new ArrayList<Integer[]>();
	}
	
	/*
	 * Used for testing other methods. First calculates all possible pairs,
	 * then removes duplicates, and lastly removes any reversed duplicates.
	 * 
	 * @param	input	input from user (numbers delimited by commas)
	 */
	private void test(String input) {
		List<Integer> intList = convertStringToIntList(input);
		
		// Calculates all possible pairs
		calculatePairs(intList);
		printPairs(getPairs());
		
		// Removes duplicate pairs
		setPairs(removeDuplicates(getPairs()));
		printPairs(getPairs());
		
		// Removes duplicate reversed pairs
		setPairs(removeReverse(getPairs()));
		printPairs(getPairs());
	}

	/*
	 * Splits out the input given and converts the string into integers.
	 * 
	 * @param	input	String of inputs
	 * @return			the list of integers
	 */
	private List<Integer> convertStringToIntList(String input) {
		List<Integer> intList = new ArrayList<Integer>();
		String[] str = input.split(",");
		for (String temp : str)
			intList.add(Integer.parseInt(temp.trim()));
		return intList;
	}
	
	/*
	 * Calculates all possible pairs.
	 * 
	 * @param	intList	list of integers
	 */
	private void calculatePairs(List<Integer> intList)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : intList) {
			if (map.containsKey(i))
				map.put(i, map.get(i) + 1);
			else
				map.put(i, 1);
		}

		List<Integer[]> temp = new ArrayList<Integer[]>();
		for (int i : intList) {
			int expected = sum - i;
			if (map.containsKey(expected))
			{				
				int counter = map.get(expected);
				if (i == 5)
					counter--;
				for (int j = 0; j < counter; j++)
				{
					Integer[] list = {i, expected};
					temp.add(list);
				}
			}
		}
		setPairs(temp);
	}
	
	/*
	 * Removes any 'exact' duplicate pairs.
	 * 
	 * @param	original	the original list
	 * @return				the list after removing exact pairs
	 */
	public List<Integer[]> removeDuplicates(List<Integer[]> original)
	{
		boolean found = false;
		List<Integer[]> noDupes = new ArrayList<Integer[]>();
		for (Integer[] i : original) {
			for (Integer[] j : noDupes) {
				if (Arrays.equals(i, j))
					found = true;
			}
			if (!found)
				noDupes.add(i);
			found = false;
		}
		return noDupes;
	}
	
	/*
	 * Removes any reversed duplicate pairs.
	 * 
	 * @param	original	the original list
	 * @return				the list after removing reversed pairs
	 */
	public List<Integer[]> removeReverse(List<Integer[]> original)
	{
		List<Integer[]> temp = new ArrayList<Integer[]>(original);
		for (int i = 0; i < original.size(); i++) {
			for (int j = i + 1; j < temp.size(); j++) {
				if (Arrays.equals(original.get(i), reverse(temp.get(j)))) {
					original.remove(j);
					temp.remove(j);
					i--;
					break;
				}
			}
		}
		return original;
	}
	
	/*
	 * Reverses an Integer pair
	 * 
	 * @param	original	the original Integer pair
	 * @return				the reversed pair
	 * 
	 */
	public Integer[] reverse(Integer[] original) {
		Integer[] replace = {original[1], original[0]};
		return replace;
	}
	
	/*	
	 * Prints out the pairs given the list of array of Integers.
	 * 
	 * @param	pair	the list of array Integer pairs
	 */
	public void printPairs(List<Integer[]> pair) {
		int counter = 0;
		for (Integer[] i : pair) {
			if (counter + 1 == pair.size())
				System.out.print("[" + i[0] +"," + i[1] + "]\n");
			else
				System.out.print("[" + i[0] +"," + i[1] + "],");
			counter++;
		}
	}
	
	public List<Integer[]> getPairs() {
		return pairs;
	}

	public void setPairs(List<Integer[]> pairs) {
		this.pairs = pairs;
	}
}
