package com.model;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsAssignmentSolution
 * @date 2021-09-19
 */

public class Stocks<T extends Number> {

	private T stockPrice;
	private Boolean priceRose;

	public Stocks(T stockPrice, Boolean priceRose) {
		super();
		this.stockPrice = stockPrice;
		this.priceRose = priceRose;
	}

	public T getStockPrice() {
		return stockPrice;
	}

	public Boolean getPriceRose() {
		return priceRose;
	}
}
