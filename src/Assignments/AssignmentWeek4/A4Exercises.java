package Assignments.AssignmentWeek4;


public class A4Exercises {

	/*
	 * Purpose: gets the number of competitors in the given list
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number of competitors in the given list
	 */
	public static int competitorsCount(List cList) {
		// TODO: implement this
		
		return cList.size(); // so it compiles
	}
	
	/*
	 * Purpose: gets the number of competitors with a score above x
	 * Parameters: List cList - the list of competitors
	 *             int x - the threshold competitors must score more than
	 * Returns: int - the number competitors with a score above x
	 */
	public static int countScoresAboveX(List cList, int x) {
		// TODO: implement this
		int count = 0;
		for(int i = 0; i<cList.size(); i++) {
			if(cList.get(i).getScore() > x) {
				count++;
			}
		}
		return count; // so it compiles
	}
	
	/*
	 * Purpose: get the number of competitors into the list c is
	 * Parameters: List cList - the list of competitors
	 *             Competitor c - the competitor to find
	 * Returns: int - the distance the first occurrence of 
	 *                c is from the start of the list, or 
	 *                -1 if c is not found in cList
	 */
	public static int distanceAway(List cList, Competitor c) {
		// TODO: implement this
		int element = -1;
		for(int i = 0; i<cList.size(); i++) {
			if(cList.get(i).getName() == c.getName()) {
				element = cList.find(c);
				break;
			}
		}
		return element; // so it compiles
	}
	
	/*
	 * Purpose: get the name of the competitor with the highest score
	 * Parameters: List cList - the list of competitors
	 * Returns: String - the name of the competitor with the highest
	 *                   score, or "" if the list is empty
	 *
	 * Note: if two or more competitors are tied with the highest 
	 *       score, the name of the competitor who comes first in the
	 *       list among those who are tied is returned
	 */
	public static String getBestCompetitorName(List cList) {
		// TODO: implement this
		int highestscore = 0;
		String highestname = "";
		for(int i = 0; i<cList.size(); i++) {
			if(cList.get(i).getScore() > highestscore) {
				highestscore = cList.get(i).getScore();
				highestname = cList.get(i).getName();
			}
			else if(cList.get(i).getScore() == highestscore) {
				highestscore = cList.get(i).getScore();
			}
		}
		return highestname; // so it compiles
	}

	/*
	 * Purpose: get the number of times a new highest score
	 *          in the list of competitors is found
	 * Parameters: List cList - the list of competitors
	 * Returns: int - the number times a new highest score is
	 *                found when traversing from left to right
	 *                through the list of competitors
	 * 
	 * Note: Read through the assignment PDF for more information
	 */
	public static int numberTimesRecordBroken(List cList) {
		// TODO: implement this
		int highestscore = 0;
		int count = 0;
		for(int i = 0; i<cList.size(); i++) {
			if(cList.get(i).getScore() > highestscore) {
				highestscore = cList.get(i).getScore();
				count++;
			}
		}
		return count; // so it compiles
	}
		
	/*
	 * Purpose: get names of all the competitors who had
	 *          the highest score seen so far at some point
	 * Parameters: List cList - the list of competitors
	 * Returns: String[] - the names of competitors who had 
	 *                     the highest score seen so far
	 *                     at some point while traversing 
	 *                     the list from left to right
	 */
	public static String[] listOfRecordBreakers(List cList) {
		// TODO: implement this
		String[] finalarray = new String[0];
		int highestscore = 0;
		for(int i = 0; i<cList.size(); i++) {
			if(cList.get(i).getScore() > highestscore) {
				String[] temparr = new String[finalarray.length+1];
				int index = 0;
				for(int j = 0; j<finalarray.length; j++) {
					temparr[j] = finalarray[j];
					index++;
				}
				temparr[index] = cList.get(i).getName();
				finalarray = temparr;
				highestscore = cList.get(i).getScore();
			}
			
			
		}
		return finalarray; // so it compiles
	}

}