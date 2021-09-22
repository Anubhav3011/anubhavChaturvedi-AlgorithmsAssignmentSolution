package com.model;

/**
 * @author AnubhavChaturvedi
 * @category AlgorithmsAssignmentSolution
 * @date 2021-09-19
 */

public class Stocks {

	private Double stockPrice;
	private Boolean priceRose;

	public Stocks(Double stockPrice, Boolean priceRose) {
		super();
		this.stockPrice = stockPrice;
		this.priceRose = priceRose;
	}

	public Double getStockPrice() {
		return stockPrice;
	}

	public Boolean getPriceRose() {
		return priceRose;
	}
}
