package com.iu.s1.trade;

import java.util.Date;

public class TradeDTO {

	private long tradeNum;
	private String accountNum;
	private Date tDate;
	private long tradeAmount;
	private long tradeBalance;
	private String tradeIO;
	
	
	public long getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(long tradeNum) {
		this.tradeNum = tradeNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public Date gettDate() {
		return tDate;
	}
	public void settDate(Date tDate) {
		this.tDate = tDate;
	}
	public long getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(long tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public long getTradeBalance() {
		return tradeBalance;
	}
	public void setTradeBalance(long tradeBalance) {
		this.tradeBalance = tradeBalance;
	}
	public String getTradeIO() {
		return tradeIO;
	}
	public void setTradeIO(String tradeIO) {
		this.tradeIO = tradeIO;
	}
}
