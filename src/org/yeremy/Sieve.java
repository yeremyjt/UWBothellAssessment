package org.yeremy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Sieve {

	// Contains a queue of numbers to extract primes from
	private Queue<Integer> numbersQueue = new LinkedList<Integer>();

	// Contains the queue of prime numbers found
	private Queue<Integer> primesQueue = new LinkedList<Integer>();

	// The n number inserted by the client
	private int N;

	// Flag that determines if the computeTo method has been run at least once
	private boolean computeToStatus = false;

	/**
	 * Constructor of Sieve object
	 * @param n Program will return prime numbers up to this specified value
	 */
	public Sieve() {
		//  Constructor
	}

	/**
	 * Computes the prime numbers from a list of consecutive numbers
	 * @param n The maximum number to contain in the list of numbers
	 */

	public void computeTo(int n) {
		if (n < 2) {
			throw new IllegalArgumentException();
		}


		// Cleaning the queues from previous runs
		if (computeToStatus) {
			int size = numbersQueue.size();

			for (int i = 0; i < size; i++) {
				numbersQueue.remove();
			}

			size = primesQueue.size();
			for (int i = 0; i < size; i++) {
				primesQueue.remove();
			}

		}

		computeToStatus = true;

		N = n;
		// Filling the numbers queue from 2 to n inclusive
		for (int i = 2; i <= N; i++) {
			numbersQueue.add(i);
		}

		int p;
		// Sieve algorithm
		do {
			p = numbersQueue.remove();
			primesQueue.add(p);

			Iterator<Integer> iterator = numbersQueue.iterator();

			// Iterating through the queue of numbers
			while (iterator.hasNext()) {
				int number = iterator.next();

				// Delete if it's not a prime number
				if (number % p == 0) {
					iterator.remove();
				}

			}


		} while (p <= Math.sqrt(N));

		// Add all the remaining numbers to the queue of prime numbers
		while(!numbersQueue.isEmpty()) {
			primesQueue.add(numbersQueue.remove());
		}
	}

	/**
	 * Reports the results to the client
	 */
	public void reportResults() {
		if (!computeToStatus)
			throw new IllegalStateException();

		int counter = 0;
		for (int prime: primesQueue) {
			counter++;
			System.out.print(prime + " ");

			// Prints only 12 numbers per line
			if (counter == 12) {
				System.out.println();
				counter = 0;
			}
		}
		System.out.println();
	}


	/**
	 *
	 * @return Returns the maximum number in the list of numbers
	 */
	public int getMax() {
		if (!computeToStatus)
			throw new IllegalStateException();
		return N;
	}

	/**
	 *
	 * @return Returns the count of prime numbers found
	 */
	public int getCount() {
		if (!computeToStatus)
			throw new IllegalStateException();
		return primesQueue.size();
	}

}
