package com.stockmarket.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	private String code;
	private String name;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Double price = Math.round(Math.random() * 100 * 100.0) / 100.0;//stock price is random between 0 and 100
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date createDate;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date lastModifiedDate;
	

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_id")
	//@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonIgnore
	private List<StockHolding> stockHoldingList;

}
