package com.cooksys.ftd.assignment.day.one;

import java.util.ArrayList;
import java.util.List;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two
 * elements are `1`, and every other element is equal to the sum of its two
 * preceding elements. For example:
 * <p>
 * [1, 1] => [1, 1, 1 + 1] => [1, 1, 2] => [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] => ...etc
 */
public class Fibonacci {

	/**
	 * Calculates the value in the Fibonacci sequence at a given index. For
	 * example, `atIndex(0)` and `atIndex(1)` should return `1`, because the
	 * first two elements of the sequence are both `1`.
	 *
	 * @param i
	 *            the index of the element to calculate
	 * @return the calculated element
	 * @throws IllegalArgumentException
	 *             if the given index is less than zero
	 */
	public static int atIndex(int i) throws IllegalArgumentException {
		// Check to make sure that the index is not negative
		if (i < 0)
			throw new IllegalArgumentException();

		// If the original parameter is 0 or 1, return the appropriate value
		if (i <= 1)
			return 1;

		// Create the initial array of elements [1,1]
		ArrayList<Integer> fibList = new ArrayList<Integer>();
		fibList.add(1);
		fibList.add(1);

		// If the original parameter is > 1, calculate the rest of the fibonacci
		// sequence
		for (int j = 2; j <= i; j++) {
			fibList.add(fibList.get(j - 1) + fibList.get(j - 2));
		}
		// Return the appropriate value
		return fibList.get(i).intValue();
	}

	/**
	 * Calculates a slice of the fibonacci sequence, starting from a given start
	 * index (inclusive) and ending at a given end index (exclusive).
	 *
	 * @param start
	 *            the starting index of the slice (inclusive)
	 * @param end
	 *            the ending index of the slice(exclusive)
	 * @return the calculated slice as an array of int elements
	 * @throws IllegalArgumentException
	 *             if either the given start or end is negative, or if the given
	 *             end is less than the given start
	 */
	public static int[] slice(int start, int end) throws IllegalArgumentException {
		// Check that the start index is less than or equal to the end index
		if (end < start || end < 0 || start < 0)
			throw new IllegalArgumentException();

		// Calculate the fibonacci sequence up to the ending point
		int[] fullSequence = fibonacci(end);

		// Create an empty int[] of length end-start
		int[] sliced = new int[end - start];

		// Iterate over the original sequence and add the values to the sliced
		// array
		for (int j = start; j < end; j++) {
			sliced[j - start] = fullSequence[j];
		}

		// Return the sliced array
		return sliced;

	}

	/**
	 * Calculates the beginning of the fibonacci sequence, up to a given count.
	 *
	 * @param count
	 *            the number of elements to calculate
	 * @return the beginning of the fibonacci sequence, up to the given count,
	 *         as an array of int elements
	 * @throws IllegalArgumentException
	 *             if the given count is negative
	 */
	public static int[] fibonacci(int count) throws IllegalArgumentException {
		if (count < 0)
			throw new IllegalArgumentException();

		// Create the initial array of elements [1,1]
		List<Integer> fibList = new ArrayList<Integer>();
		fibList.add(1);
		fibList.add(1);

		// Calculate the rest of the fibonacci sequence
		for (int j = 2; j < count; j++) {
			fibList.add(fibList.get(j - 1) + fibList.get(j - 2));
		}

		// Create the final array that will be populated with the fib values
		int[] fibSequence = new int[count];

		// Iterate over the fibList and populate the final array with the values
		for (int z = 0; z < count; z++) {
			fibSequence[z] = fibList.get(z);
		}

		// Return the fibonacci sequence int[]
		return fibSequence;

	}

	public static void main(String[] args) {
		// {1, 1, 2, 3, 5, 8}
		Fibonacci.slice(3, 7);
		Fibonacci.slice(0, 0);
	}
}
