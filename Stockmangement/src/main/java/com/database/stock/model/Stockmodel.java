package com.database.stock.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Components")
public class Stockmodel {
	@Id
	private int ccode;
	private String cname;
	private String cbrnd;
	private int crate;
	private String cfromc;
	private String cfroml;
	private int cqntyr;
	private int cqntyi;
	private int cttl;
	private int cused;
	private int cbl;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCcode() {
		return ccode;
	}
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public String getCbrnd() {
		return cbrnd;
	}
	public void setCbrnd(String cbrnd) {
		this.cbrnd = cbrnd;
	}
	public int getCrate() {
		return crate;
	}
	public void setCrate(int crate) {
		this.crate = crate;
	}
	public String getCfromc() {
		return cfromc;
	}
	public void setCfromc(String cfromc) {
		this.cfromc = cfromc;
	}
	public String getCfroml() {
		return cfroml;
	}
	public void setCfroml(String cfroml) {
		this.cfroml = cfroml;
	}
	public int getCqntyr() {
		return cqntyr;
	}
	public void setCqntyr(int cqntyr) {
		this.cqntyr = cqntyr;
	}
	public int getCqntyi() {
		return cqntyi;
	}
	public void setCqntyi(int cqntyi) {
		this.cqntyi = cqntyi;
	}
	public int getCttl() {
		return cttl;
	}
	public void setCttl(int cttl) {
		this.cttl = cttl;
	}
	public int getCused() {
		return cused;
	}
	public void setCused(int cused) {
		this.cused = cused;
	}
	public int getCbl() {
		return cbl;
	}
	public void setCbl(int cbl) {
		this.cbl = cbl;
	}
	


}
