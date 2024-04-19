package CSC115WEEK1;

class ArrayExercisesSoln {

    public static void main (String[] args) {	
		//arrayReview();
		testSumPositive();
		testArraysEqual();
		testDoubleAll();
		testAllOdd();
	}
	
	public static void arrayReview () {
			
		// Q1a. What is the output of the following:
		int[] array1 = null;
		System.out.println("array1: " + array1);
		System.out.println("array1[5]: " + array1[5]);

		// Q1b. What is the output of the following:
		// array1[1] = 5;
		// System.out.println("array1[1]: " + array1[1]);

		// Q1c. What is the output of the following:
		// int[] array2 = {4, 5, 6};
		// System.out.println("array2: " + array2);
		// System.out.println("array2[1]: " + array2[1]);

		// Q1d. What is the output of the following:
		// double[] array3 = new double[2];
		// System.out.println("array3: " + array3);
		// System.out.println("array3[0]: " + array3[0]);
		// System.out.println("array3[10]: " + array3[10]);
		
		// array1 = array2; 
		// array1[1] = 9;
		// System.out.println("array1: " + array1);
		// System.out.println("array2[0]: " + array2[0]); 
		// System.out.println("array2[1]: " + array2[1]);

	}  

	public static void testSumPositive() {
		System.out.println("Testing sumPositive");
		int result = 0;
		int expected = 0;
		
		int[] arr0 = new int[0];
		int[] arr1 = {7};
		int[] arr2 = {-7};
		int[] arr3 = {8, -1, -4, 2};
		int[] arr4 = {5, -9, 4, -2};
		int[] arr5 = {-1, 2, 3};
		
		result = sumPositive(arr0);
		expected = 0;
		System.out.println("sumPositive empty array");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr1);
		expected = 7;
		System.out.println("sumPositive [7]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
	
		result = sumPositive(arr2);
		expected = 0;
		System.out.println("sumPositive [-7]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr3);
		expected = 10;
		System.out.println("sumPositive [8, -1, -4, 2]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr4);
		expected = 9;
		System.out.println("sumPositive [5, -9, 4, -2]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		result = sumPositive(arr5);
		expected = 5;
		System.out.println("sumPositive [-1, 2, 3]");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
	}
	
	/*
	 * Purpose: Gets the sum of all positive values in the array
	 * Parameters: int[] arr
	 * Returns: int - the sum of all positive values
	 */
	public static int sumPositive(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				sum += arr[i];
			}
		}
		return sum;
	}
		
	
	public static void testArraysEqual() {
		System.out.println("\nTesting arraysEqual");
		int[] asc1 = {1, 2, 3, 4};
		int[] asc2 = {1, 2, 3, 4, 5};
		int[] des1 = {4, 3, 2, 1};
		int[] des2 = {4, 3, 2, 1};
		boolean same = arraysEqual(asc1, asc2);
		System.out.println("asc1 and asc2 equal:" +same);
		same = arraysEqual(asc1, des1);
		System.out.println("asc1 and des1 equal:" +same);
		same = arraysEqual(des1, des2);
		System.out.println("des1 and des2 equal:" +same);
		System.out.println();
	}
	
	/*
	 * Purpose: Determines whether two arrays are equal
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays are the size length with 
	 *                    the same values at each position
	 */
	public static boolean arraysEqual(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		int i = 0;
		while (i<a.length && a[i] == b[i]) {	
			i++;
		}
		return i==a.length;

	}
	
    
	public static void testDoubleAll() {
		System.out.println("\nTesting doubleAll");
		int[] a1 = {7, 1, 3, 4};
		int[] a1x2 = {14, 2, 6, 8};
		int[] a1x2x2 = {28, 4, 12, 16};
		
		doubleAll(a1);
		System.out.println("doubleAll {7,1,3,4} should now equal a1x2");
		System.out.println("a1 equals a1x2: " + arraysEqual(a1, a1x2));
		
		doubleAll(a1);
		System.out.println("doubleAll {14, 2, 6, 8} should now equal a1x2x2");
		System.out.println("a1 equals a1x2x2: " + arraysEqual(a1, a1x2x2));
		
		int[] a2 = {5, 4, 9};
		int[] a2x2 = {10, 8, 18};
		int[] a2x2x2 = {20, 16, 36};
		
		doubleAll(a2);
		System.out.println("doubleAll {5,4,9} equals {10,8,18}: " + arraysEqual(a2, a2x2));
		
		doubleAll(a2);
		System.out.println("doubleAll {10,8,18} equals {20,16,36}: " + arraysEqual(a2, a2x2x2));
		
		System.out.println();
	}
	
	/*
	 * Purpose: Doubles the values of all elements in given array
	 * Parameters: int[] arr - the array to modify
	 * Returns: void - nothing
	 */
	public static void doubleAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]*2;
		}
	}
		
	public static void testAllOdd() {
		System.out.println("\nTesting allOdd");
		boolean result = false;
		boolean expected = false;
		
		int[] a1 = {2};
		result = allOdd(a1);
		System.out.println("allOdd {2} should be "+expected+", result: "+result);
		
		int[] a2 = {3};
		expected = true;
		result = allOdd(a2);
		System.out.println("allOdd {2} should be "+expected+", result: "+result);
		
		int[] a3 = {3, 5, 6};
		result = allOdd(a3);
		expected = false;
		System.out.println("allOdd {3, 5, 6}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);

		int[] a4 = {7, 9, 15, 2, 5};
		result = allOdd(a4);
		expected = false;
		System.out.println("allOdd {7,9,15,2,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		int[] a5 = {7, 9, 15, 5};
		result = allOdd(a5);
		expected = true;
		System.out.println("allOdd {7,9,15,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
		
		int[] a6 = {6, 7, 9, 15, 2, 5};
		result = allOdd(a6);
		expected = false;
		System.out.println("allOdd {6,7,9,15,2,5}");
		System.out.println("expected result: " + expected);
		System.out.println("returned result: " + result);
	}
	
	/*
	 * Purpose: Determine if the array contains only odd values
	 * Parameters: int[] arr 
	 * Returns: boolean - true if the array contains only odd values,
	 *                    false if at least one even value is found
	 */
	public static boolean allOdd(int[] arr) {
		boolean noEvens = true;
		int i = 0;
		while (i < arr.length && noEvens == true) {
			if (arr[i]%2 == 0) {
				noEvens = false;
			}
			i++;
		}
		return noEvens;
	} 

}
