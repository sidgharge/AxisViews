package com.demo.jdbcviews.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "reviewer_txbpower_view")
@Immutable
public class ReviewerTxbPower {

	@Id
	@Column(name = "rev_id")
	private int revId;

	@Column(name = "rev_name")
	private String revName;

	@Column(name = "rev_key")
	private String revKey;

	@Column(name = "rev_rm")
	private String revRm;

	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public String getRevKey() {
		return revKey;
	}

	public void setRevKey(String revKey) {
		this.revKey = revKey;
	}

	public String getRevRm() {
		return revRm;
	}

	public void setRevRm(String revRm) {
		this.revRm = revRm;
	}

}
