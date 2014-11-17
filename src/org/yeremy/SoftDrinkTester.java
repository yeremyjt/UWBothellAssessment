package org.yeremy;

/*
* This program tests the functionality of the SoftDrinkInventory class.
* An object is constructed which initially holds no real data.
* A datafile containing initial data is used to fill the SoftDrink object.
* Then transactions are processed where each transaction contains how
* cases are bought or sold. A function displays a report of the drink name,
* ID, starting inventory, final inventory, and the number of transactions
* processed.
*/
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SoftDrinkTester {

	private static class SoftDrinkInventory {
		final int MAX_DRINK_COUNT = 100;
		private String[] nameArray = new String[MAX_DRINK_COUNT];
		private String[] idArray = new String[MAX_DRINK_COUNT];
		private int[] startingInventoryArray = new int[MAX_DRINK_COUNT];
		private int[] finalInventoryArray = new int[MAX_DRINK_COUNT];
		private int[] transactionsArray = new int[MAX_DRINK_COUNT];

		public SoftDrinkInventory() {
			initializeString(nameArray);
			initializeString(idArray);
			initializeInt(startingInventoryArray);
			initializeInt(finalInventoryArray);
			initializeInt(transactionsArray);
		}

		public void buildInventory(Scanner inventoryFile) {
			int index = 0;
			while(inventoryFile.hasNext()) {
				String[] temp = inventoryFile.nextLine().split(" ");
				nameArray[index] = temp[0];
				idArray[index] = temp[1];
				startingInventoryArray[index] = Integer.parseInt(temp[2]);
				finalInventoryArray[index] = Integer.parseInt(temp[2]);
				index++;
			}
		}

		public void processTransactions(Scanner transFile) {
			int index;
			while(transFile.hasNextLine()) {
				//Finding the index
				String[] temp = transFile.nextLine().split(" ");

				/* NOTE
				 * I'm using brute force to find the ID in the array,
				 * but this is not scalable at all. Since this is an assessment
				 * for a CS beginners class, I didn't implement a more robust solution
				 * either involving binary search trees or a hash table.
				*/
				index = findID(temp[0]);
				if(index >= 0) {
					finalInventoryArray[index] += Integer.parseInt(temp[1]);
					transactionsArray[index]++;
				}
				index++;
			}
		}

		private int findID(String ID) {
			for(int i = 0; i < idArray.length; i++) {
				if(ID.equals(idArray[i]))
					return i;
			}
			return -1;
		}

		public void displayReport() {
			System.out.println(String.format("%10s%10s%20s%20s%10s", "Soft Drink","ID", "Starting Inventory", "Final Inventory", "# Transactions"));
			for(int i = 0; i < idArray.length; i++) {
				if(!idArray[i].equals(""))
					System.out.println(String.format("%10s%10s%20d%20d%10d",nameArray[i], idArray[i], startingInventoryArray[i], finalInventoryArray[i], transactionsArray[i]));
				else break;
			}
		}

		private void initializeString (String[] array) {
			for(int i = 0; i < array.length; i++) {
				array[i] = "";
			}
		}

		private void initializeInt(int[] array) {
			for(int i = 0; i < array.length; i++) {
				array[i] = 0;
			}
		}
	}

	public static void main (String[] args) {

		Scanner inventoryFile = null; // inventory data file

		Scanner transFile = null; // transaction data file

		// open the inventory initialization file

		try {

			inventoryFile = new Scanner(new FileInputStream("data6.txt"));

		}

		catch (FileNotFoundException e) {

			System.out.println("File not found or not opened.");

			System.exit(0);

		}

		// open the file containing the buy/sell transactions

		try {

			transFile = new Scanner(new FileInputStream("data6trans.txt"));

		}

		catch (FileNotFoundException e) {

			System.out.println("File not found or not opened.");

			System.exit(0);

		}

		// instantiate the soft drink distributorship object

		// and process the transactions by updating the inventory totals

		SoftDrinkInventory softDrinks = new SoftDrinkInventory();

		softDrinks.buildInventory(inventoryFile);

		softDrinks.processTransactions(transFile);

		softDrinks.displayReport();

	}

}