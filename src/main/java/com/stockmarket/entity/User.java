package com.stockmarket.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;

	private String userName;
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@Enumerated(EnumType.STRING)
	private Profiles profile;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date createDate;
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date lastModifiedDate;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<StockHolding> stockHoldingList;

}
