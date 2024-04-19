package Assignments.AssignmentWeek2;

public class A2Exercises {
	
	/*
	 * Purpose: get the total money raised across all fundraisers
	 *          in the given array
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: int: total money raised across all fundraisers
	 * Precondition: the array is not null
	 */	
	public static int totalMoneyRaised(Fundraiser[] array) {
		// TODO: implement this
		int total = 0;
		for (int i = 0; i<array.length; i++) {
			total += array[i].moneyRaised();
		}
		return total; // so it compiles
	}
	
	/*
	 * Purpose: get the total money spent on winning auctions 
	 *          by people with the provided name
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 *             String name - the name to search for
	 * Returns: int: total money raised across all fundraisers
	 * Precondition: the array and name are not null
	 */	
	public static  int totalSpent(Fundraiser[] array, String name) {
		// TODO: implement this
		int total = 0;
		for (int i = 0; i<array.length; i++) {
				total += array[i].moneySpent(name);
			
		}
		return total; // so it compiles
	}

	/*
	 * Purpose: create a new array of AuctionItems that contains
	 *          only the most expensive item from each fundraiser
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: AuctionItem[]: the array of most expensive items
	 * Precondition: the array is not null
	 */	
	public static AuctionItem[] mostExpensiveItems(Fundraiser[] array) {
		// TODO: implement this
		AuctionItem[] newarray = new AuctionItem[array.length];
		for (int i = 0; i<array.length; i++) {
			newarray[i] = array[i].mostExpensive();
		}
		return newarray; // so it compiles
	}
	
	/*
	 * Purpose: calculate and return the average price of the most
	 *          expensive items from each fundraiser in the array
	 * Parameters: Fundraiser[] array - the array of fundraisers
	 * Returns: double - the average price of the most expensive items
	 * Precondition: the array is not null
	 */	
	public static double averageOfMostExpensive(Fundraiser[] array) {
		// TODO: implement this

		int total = 0;
		AuctionItem[] items = new AuctionItem[array.length];
		items = mostExpensiveItems(array);
		int count = items.length;
		for (int i = 0; i<items.length; i++) {
			total += items[i].getHighestBid();
		}
		
		if(count == 0) {
			return 0;
		}
		else {
			return (double)total/count; // so it compiles
	}
	}
}