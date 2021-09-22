package com.main;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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

		// Test Case: 5 30.56 true 10.13 false 48.71 true 96.82 false 15.49 true

		try {
			Scanner lScanner = new Scanner(System.in);
			boolean proceed = true;
			int noOfCompanies = 0;
			if (args.length == 0) {
				System.out.println("Enter the no of companies: ");
				noOfCompanies = lScanner.nextInt();
				if (!checkInput(noOfCompanies, "No of companies"))
					proceed = false;
			} else {
				noOfCompanies = Integer.parseInt(args[0]);
			}

			List<Stocks> lStocks = new ArrayList<Stocks>();

			int i = 0, j = 1;
			while (i < noOfCompanies && proceed) {
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
				if (!checkInput(stockPrice, "Stock price of the company " + (i + 1))) {
					proceed = false;
					break;
				}
				lStocks.add(new Stocks(stockPrice, priceRose));
				i++;
			}

			MergeSort lMergeSort = new MergeSort();
			int lChoice = -1;

			while (lChoice != 0 && proceed) {
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

				// Exit
				case 0: {
				}
					break;

				// Ascending Order Stock Prices
				case 1: {
					System.out.println("Stock prices in ascending order are : \n" + Arrays
							.toString(lMergeSort.getSortedArray(
									lStocks.stream().mapToDouble(Stocks::getStockPrice).toArray(), false))
							.substring(1).replace("]", "").replaceAll(", ", " "));
				}
					break;

				// Descending Order Stock Prices
				case 2: {
					System.out.println("Stock prices in descending order are : \n" + Arrays
							.toString(lMergeSort.getSortedArray(
									lStocks.stream().mapToDouble(Stocks::getStockPrice).toArray(), true))
							.substring(1).replace("]", "").replaceAll(", ", " "));
				}
					break;

				// Rose Stock Prices
				case 3: {
					System.out.println("Total no of companies whose stock price rose today : "
							+ lStocks.stream().filter(Stocks -> Stocks.getPriceRose()).count());
				}
					break;

				// Declined Stock Prices
				case 4: {
					System.out.println("Total no of companies whose stock price declined today : "
							+ lStocks.stream().filter(Stocks -> (!(Stocks.getPriceRose()))).count());
				}
					break;

				// Search Stock Price
				case 5: {
					System.out.println("Enter the key value: ");
					double key = lScanner.nextDouble();
					if (DoubleStream.of(lStocks.stream().mapToDouble(Stocks::getStockPrice).toArray()).boxed()
							.collect(Collectors.toCollection(ArrayList::new)).contains(key))
						System.out.println("Stock of value " + key + " is present");
					else
						System.out.println("Value not found");
				}
					break;

				default:
					System.out.println("Invalid choice. Enter a valid no.");
				}
			}
			System.out.println("Exited successfully");
			lScanner.close();
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input.\n" + "Try Test Case mentioned below for testing\n"
					+ "5 30.56 true 10.13 false 48.71 true 96.82 false 15.49 true");
			e.printStackTrace();
		}
	}

	public static <T extends Number> boolean checkInput(T input, String inputName) {
		if (input.doubleValue() <= 0) {
			System.out.println(inputName + " should be greater than 0");
			return false;
		}
		return true;
	}
}
