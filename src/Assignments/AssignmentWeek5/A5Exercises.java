package Assignments.AssignmentWeek5;



public class A5Exercises {

	/*
	 * Purpose: change all occurrences of x to y in the given list
	 * Parameters: List<T> theList - the list to search through
	 *			   T x - the value to change
	 *			   T y = the value to change all x's to
	 * Returns: void - nothing
	 */
	public static <T> void changeXToY(List<T> theList, T x, T y) {
        changeXToYHelper(theList, x, y, 0);
    }

    private static <T> void changeXToYHelper(List<T> theList, T x, T y, int index) {
        if (index >= theList.size()) {
            return; // Base case: reached the end of the list
        }

        if (theList.get(index).equals(x)) {
            theList.change(index, y); // Replace x with y if found
        }

        // Continue recursively with the next element
        changeXToYHelper(theList, x, y, index + 1);
    }
	
	
	
	/*
	 * Purpose: count the total number of odd values in this list
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the total number of odd values found
	 */
	public static int countOdd(List<Integer> theList) {
		// TODO: Call a recursive helper method
		return countOddHelper(theList, 0, 0); // so it compiles
	}
	
	private static int countOddHelper(List<Integer> theList, int index, int count) {
		if(index >= theList.size()) {
			return count;
		}
		else {
			if(theList.get(index) % 2 != 0) {
				count += 1;
			}
			return countOddHelper(theList, index + 1, count);
		}
	}

	/*
	 * Purpose: get the largest sequence of odd values found in a row
	 * Parameters: List<Integer> theList - the list of Integers
	 * Returns: int - the largest sequence of odd values found in a row
	 */
	public static int countMostOddInARow(List<Integer> theList) {
        return countMostOddInARowHelper(theList, 0, 0, 0);
    }

    private static int countMostOddInARowHelper(List<Integer> theList, int index, int currentCount, int maxCount) {
        if (index >= theList.size()) {
            return maxCount; // Base case: reached the end of the list
        }

        int currentNumber = theList.get(index);
        if (currentNumber % 2 != 0) {
            currentCount++; // Increment the count if the current number is odd
            maxCount = Math.max(maxCount, currentCount); // Update maxCount if necessary
        } else {
            currentCount = 0; // Reset the count if the current number is even
        }

        // Continue recursively with the next element
        return countMostOddInARowHelper(theList, index + 1, currentCount, maxCount);
    }
	
	
	
	/*
	 * Purpose: count the elements found in between the first two x's
	 * Parameters: List<Integer> theList - the list of Integers
	 *             int x - the values to search for
	 * Returns: int - the number of values in the list found 
	 *                between the first 2 occurrences if x,
	 *                or -1 if there are not 2 x's in the list.
	 */
	public static int countBetweenX(List<Integer> theList, int x) {
		// TODO: Call a recursive helper method
		return countBetweenXHelper(theList, x, -1, 0); // so it compiles
	}
	
	private static int countBetweenXHelper(List<Integer> theList, int x, int maxcount, int index) {
		if(index >= theList.size()) {
			return maxcount;
		}
		if(theList.size() == 1) {
			return -1;
		}
		
		int currentnumber = theList.get(index);
		if(currentnumber == x) {
			if(maxcount == -1) {
				maxcount = 0;
			}
			else if(maxcount != -1) {
				return maxcount;
			}
		}
		else if(maxcount != -1) {
			maxcount++;
		}
		
		
		
		return countBetweenXHelper(theList, x, maxcount, index+1);
	}
	 
}