package com.main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.model.Stocks;
import com.service.MergeSort;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsAssignmentSolution
 * @date 2021-09-19
 */

public class Driver {

	public static void main(String[] args) throws InputMismatchException {
		// TODO Auto-generated method stub

		// Test Case - 5 10.13 true 15.49 false 48.71 true 96.82 false 30.56 true

		try {
			Scanner lScanner = new Scanner(System.in);
			int noOfCompanies = 0;
			if (args.length == 0) {
				System.out.println("Enter the no of companies: ");
				noOfCompanies = lScanner.nextInt();
			} else
				noOfCompanies = Integer.parseInt(args[0]);

			Stocks[] lStocks = new Stocks[noOfCompanies];
			double[] stockPrices = new double[noOfCompanies];
			int noOfPriceRose = 0;
			for (int i = 0, j = 1; i < noOfCompanies; i++) {
				lStocks[i] = new Stocks();
				double stockPrice = 0.00d;
				boolean priceRose = false;
				if (args.length == 0) {
					System.out.println("Enter current stock price of the company " + (i + 1));
					stockPrice = lScanner.nextDouble();
					System.out.println("Whether company's stock price rose today compare to yesterday?");
					priceRose = lScanner.nextBoolean();
				} else {
					stockPrice = Double.parseDouble(args[j++]);
					priceRose = Boolean.parseBoolean(args[j++]);
				}
				lStocks[i].setStockPrice(stockPrice);
				lStocks[i].setPriceRose(priceRose);
				stockPrices[i] = lStocks[i].getStockPrice();
				if (lStocks[i].getPriceRose())
					noOfPriceRose++;
			}

			MergeSort lMergeSort = new MergeSort();
			int lChoice = -1;

			do {
				System.out.println("-----------------------------------------------\n"
						+ "Enter the operation that you want to perform\n"
						+ "1. Display the companies stock prices in ascending order\n"
						+ "2. Display the companies stock prices in descending order\n"
						+ "3. Display the total no of companies for which stock prices rose today\n"
						+ "4. Display the total no of companies for which stock prices declined today\n"
						+ "5. Search a specific stock price\n" + "6. Press 0 to exit\n"
						+ "-----------------------------------------------");

				lChoice = lScanner.nextInt();
				switch (lChoice) {

				case 0: {
				}
					break;

				case 1: {
					System.out.println("Stock prices in ascending order are :");
					System.out.println(Arrays.toString(lMergeSort.getSortedArray(stockPrices, false)).substring(1)
							.replace("]", "").replaceAll(", ", " "));
				}
					break;

				case 2: {
					System.out.println("Stock prices in descending order are :");
					System.out.println(Arrays.toString(lMergeSort.getSortedArray(stockPrices, true)).substring(1)
							.replace("]", "").replaceAll(", ", " "));
				}
					break;

				case 3: {
					System.out.println("Total no of companies whose stock price rose today : " + noOfPriceRose);
				}
					break;

				case 4: {
					System.out.println("Total no of companies whose stock price declined today : "
							+ (noOfCompanies - noOfPriceRose));
				}
					break;

				case 5: {
					System.out.println("Enter the key value: ");
					double key = lScanner.nextDouble();
					for (int i = 0; i < lStocks.length; i++) {
						if (key == lStocks[i].getStockPrice()) {
							System.out.println("Stock of value " + key + " is present");
							break;
						} else if (i == lStocks.length - 1)
							System.out.println("Stock of value " + key + " is not present");
					}
				}
					break;

				default:
					System.out.println("Invalid choice. Enter a valid no.");
				}
			} while (lChoice != 0);
			lScanner.close();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input.\n" + "Try Test Case mentioned below for testing\n"
					+ "5 30.56 true 10.13 false 48.71 true 96.82 false 15.49 true");
			e.printStackTrace();
		}
	}
}
