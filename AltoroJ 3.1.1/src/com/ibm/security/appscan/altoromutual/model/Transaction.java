/**
This application is for demonstration use only. It contains known application security
vulnerabilities that were created expressly for demonstrating the functionality of
application security testing tools. These vulnerabilities may present risks to the
technical environment in which the application is installed. You must delete and
uninstall this demonstration application upon completion of the demonstration for
which it is intended. 

IBM DISCLAIMS ALL LIABILITY OF ANY KIND RESULTING FROM YOUR USE OF THE APPLICATION
OR YOUR FAILURE TO DELETE THE APPLICATION FROM YOUR ENVIRONMENT UPON COMPLETION OF
A DEMONSTRATION. IT IS YOUR RESPONSIBILITY TO DETERMINE IF THE PROGRAM IS APPROPRIATE
OR SAFE FOR YOUR TECHNICAL ENVIRONMENT. NEVER INSTALL THE APPLICATION IN A PRODUCTION
ENVIRONMENT. YOU ACKNOWLEDGE AND ACCEPT ALL RISKS ASSOCIATED WITH THE USE OF THE APPLICATION.

IBM AltoroJ
(c) Copyright IBM Corp. 2008, 2013 All Rights Reserved.
 */

package com.ibm.security.appscan.altoromutual.model;

import java.util.Date;

/**
 * This class models a transactions
 * @author Alexei
 *
 */
public class Transaction {

	private int transactionId;
	private long accountId;
	private String transactionType;
	private double amount;
	private Date date;
	
	public Transaction(int transactionId, long accountId, Date date, String transactionType, double amount) {
		this.accountId = accountId;
		this.amount = amount;
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.date = date;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public long getAccountId() {
		return accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}
}
