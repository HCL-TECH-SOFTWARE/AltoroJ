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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.commons.codec.binary.Base64;

import com.ibm.security.appscan.altoromutual.util.DBUtil;

/**
 * This class models user's account
 * @author Alexei
 */
public class Account {
	private long accountId = -1;
	private String accountName = null;
	private double balance = -1;
	
	public static Account getAccount(String accountNo) throws SQLException {
		if (accountNo == null || accountNo.trim().length() == 0)
			return null;

		long account = Long.parseLong(accountNo);

		return getAccount(account);
	}
	
	public static Account getAccount(long account) throws SQLException {
		return DBUtil.getAccount(account);
	}
	
	public Account(long accountId, String accountName, double balance) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
	}
	
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}
	
	public static Account[] fromBase64List (String b64accounts){
		String accounts = new String(Base64.decodeBase64(b64accounts)); 
		
		StringTokenizer outerTokens = new StringTokenizer(accounts, "|");
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		while (outerTokens.hasMoreTokens()){
			StringTokenizer tokens = new StringTokenizer(outerTokens.nextToken(), "~");
			
			long acctId = -1;
			String acctName = null;
			double amt = Double.MAX_VALUE;
			if (tokens.hasMoreTokens())
				acctId = Long.valueOf(tokens.nextToken());
			
			if (tokens.hasMoreTokens())
				acctName = tokens.nextToken();
			
			if (tokens.hasMoreTokens())
				amt = Double.valueOf(tokens.nextToken());
			
			if (acctId > -1 && acctName != null && amt != Double.MAX_VALUE){
				accountList.add(new Account(acctId, acctName, amt));
			}
		}
		
		return (accountList.toArray(new Account[accountList.size()]));
	}
	
	public static String toBase64List(Account[] accounts){
	
		StringBuffer accountList = new StringBuffer();
		
		for (Account account:accounts){
			accountList.append(account.getAccountId());
			accountList.append("~");
			accountList.append(account.getAccountName());
			accountList.append("~");
			accountList.append(account.getBalance());
			accountList.append("|");
		}
		
		return Base64.encodeBase64String(accountList.toString().getBytes());
		
	}
}
