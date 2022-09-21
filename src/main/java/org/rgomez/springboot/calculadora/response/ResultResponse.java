package org.rgomez.springboot.calculadora.response;

import java.math.BigDecimal;

public class ResultResponse {

	private Long brand_id;
	private String start_date;
	private String end_date;
	private Long price_list;
	private Long product_id;
	private BigDecimal price;
	private String curr;

	public Long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Long getPrice_list() {
		return price_list;
	}

	public void setPrice_list(Long price_list) {
		this.price_list = price_list;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

}
