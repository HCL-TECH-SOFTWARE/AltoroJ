package com.ibm.security.appscan.altoromutual.api;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import com.ibm.security.appscan.altoromutual.model.Account;
import com.ibm.security.appscan.altoromutual.model.Transaction;
import com.ibm.security.appscan.altoromutual.model.User;
import com.ibm.security.appscan.altoromutual.util.DBUtil;
import com.ibm.security.appscan.altoromutual.util.OperationsUtil;


@Path("/account")
public class AccountAPI extends AltoroAPI {

	// For the get method return all accounts
	@GET
	public Response getAccounts(@Context HttpServletRequest request) {

		// HttpSession session = request.getSession(true);
		String response;
	
		
		try {
			Account[] account = (OperationsUtil.getUser(request)).getAccounts();
			// System.out.println("We got so far!");
			response = "{\"Accounts\":\n[\n";
			for (int i = 0; i < account.length; i++) {
				response = response + "{ \"Name\" : \"" + account[i].getAccountName()
						+ "\", \"id\": \"" + account[i].getAccountId() + "\"}";
				if (i < account.length - 1)
					response = response + ",\n";
			}
			response = response + "\n]}";

		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error: " + e.getLocalizedMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON_TYPE).build();
	}

	// Method to return details about a specific account
	@GET
	@Path("/{accountNo}")
	public Response getAccountBalance(@PathParam("accountNo") String accountNo,
			@Context HttpServletRequest request) {

		// Check that the user is logged in
		// System.out.println(accountNo);
		String response;

		// not checking the account number, side privilege escalation possible
		try {
			// Get the account balance
			double dblBalance = Account.getAccount(accountNo).getBalance();
			String format = (dblBalance < 1) ? "$0.00" : "$.00";
			String balance = new DecimalFormat(format).format(dblBalance);
			response = "{\"balance\" : \"" + balance + "\" ,\n";
			// Get the last 10 transactions

			// return Response.status(200).entity(balance).build();
		} catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("{Error : " + e.getLocalizedMessage())
					.build();
		}

		// Get the last 10 transactions
		String last10Transactions;
		last10Transactions = this.getLastTenTransactions(accountNo);
		if (last10Transactions.equals("Error")) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("{Error : Unexpected error during transfer}")
					.build();
		}
		response = response + last10Transactions;

		JSONObject myJson = new JSONObject();
		try {

			response = response
					+ "\"credits\":[{\"account\":\"1001160140\", \"date\":\"2004-12-29\", \"description\":\"Paycheck\", \"amount\":\"1200\"},{\"account\":\"1001160140\", \"date\":\"2005-01-12\", \"description\":\"Paycheck\", \"amount\":\"1200\"},{\"account\":\"1001160140\", \"date\":\"2005-01-29\", \"description\":\"Paycheck\", \"amount\":\"1200\"},{\"account\":\"1001160140\", \"date\":\"2005-02-12\", \"description\":\"Paycheck\", \"amount\":\"1200\"},{\"account\":\"1001160140\", \"date\":\"2005-03-01\", \"description\":\"Paycheck\", \"amount\":\"1200\"},{\"account\":\"1001160140\", \"date\":\"2005-03-15\", \"description\":\"Paycheck\", \"amount\":\"1200\"}],";
			response = response
					+ "\"debits\":[{\"account\":\"1001160140\", \"date\":\"2005-01-17\", \"description\": \"Withdrawal\" , \"amount\":\"2.85\"},{\"account\":\"1001160140\", \"date\":\"2005-01-25\", \"description\": \"Rent\" , \"amount\":\"800\"},{\"account\":\"1001160140\", \"date\":\"2005-01-27\", \"description\": \"Electric Bill\" , \"amount\":\"45.25\"},{\"account\":\"1001160140\", \"date\":\"2005-01-28\", \"description\": \"Heating\" , \"amount\":\"29.99\"},{\"account\":\"1001160140\", \"date\":\"2005-01-29\", \"description\": \"Transfer to Savings\" , \"amount\":\"321\"},{\"account\":\"1001160140\", \"date\":\"2005-01-29\", \"description\": \"Groceries\" , \"amount\":\"19.6\"}]}";
			myJson =new JSONObject(response);
			myJson.put("accountId", accountNo);
			return Response.status(Response.Status.OK).entity(myJson.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		}catch (JSONException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error has occurred: " + e.getLocalizedMessage()).build();
		}
	}

	// Methods for getting the transactions

	// Get the last 10 transactions
	@GET
	@Path("/{accountNo}/transactions")
	public Response showLastTenTransactions(
			@PathParam("accountNo") String accountNo,
			@Context HttpServletRequest request) {
		String response;

		response = "{";
		// Get the last 10 transactions
		String last10Transactions;
		last10Transactions = this.getLastTenTransactions(accountNo);
		if (last10Transactions.equals("Error")) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("{Error : Unexpected error during transfer}")
					.build();
		}
		response = response + last10Transactions;
		response = response + "}";

		try {
			JSONObject myJson = new JSONObject();
			myJson =new JSONObject(response);
			return Response.status(Response.Status.OK).entity(myJson.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (JSONException e) {
			return Response
					.status(Response.Status.OK)
					.entity("{ \"Error\" : \"Unexpected error occured retrieving transactions.\"} " + e.getLocalizedMessage())
					.build();
		}
	}

	// Get transactions between two dates
	@POST
	@Path("/{accountNo}/transactions")
	public Response getTransactions(@PathParam("accountNo") String accountNo,
			String bodyJSON, @Context HttpServletRequest request) throws SQLException {

		/*if (!this.loggedIn(request)) {
			return Response.status(401).entity("{\"loggedIn\" : \"false\"}")
					.build();
		}*/
		User user = OperationsUtil.getUser(request);
		String startString;
		String endString;
		
		JSONObject myJson = new JSONObject();
		try {
			myJson =new JSONObject(bodyJSON);
			startString = (String) myJson.get("startDate");
			endString = (String) myJson.get("endDate");
		} catch (JSONException e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("{Error : Unexpected request format}").build();
		}

		Transaction[] transactions = new Transaction[0];

		try {
			Account[] account = new Account[1];
			account[0] = user.lookupAccount(Long.parseLong(accountNo));

			transactions = user.getUserTransactions(startString, endString,
					account);
		} catch (SQLException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("{Error : Database failed to return requested data} " + e.getLocalizedMessage())
					.build();
		}

		String response = "{\"transactions\":[";
		
		for (int i = 0; i < transactions.length; i++) {
			// limit to 100 entries
			if (i == 100)
				break;

			double dblAmt = transactions[i].getAmount();
			String format = (dblAmt < 1) ? "$0.00" : "$.00";
			String amount = new DecimalFormat(format).format(dblAmt);
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm")
					.format(transactions[i].getDate());

			response += "{\"id\":" + "\"" + transactions[i].getTransactionId()
					+ "\"," + "\"date\":" + "\"" + date + "\","
					+ "\"account\":\"" + transactions[i].getAccountId() + "\","
					+ "\"type\":\"" + transactions[i].getTransactionType()+
					"\"," + "\"amount\":\"" + amount + "\"}";
			if(i<transactions.length-1) response+=",";
		}
		response += "]}";

		try {
			myJson =new JSONObject(response);
			return Response.status(Response.Status.OK).entity(myJson.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (JSONException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error has occurred: " + e.getLocalizedMessage()).build();
		}
	}

	// utilities for the API
	private String getLastTenTransactions(String accountNo) {
		String response = "";
		try {
			response = response + "\"last_10_transactions\" :\n[";
			Transaction[] transactions = DBUtil
					.getTransactions(null, null, new Account[] { DBUtil
							.getAccount(Long.valueOf(accountNo)) }, 10);
			for (Transaction transaction : transactions) {
				double dblAmt = transaction.getAmount();
				String dollarFormat = (dblAmt < 1) ? "$0.00" : "$.00";
				String amount = new DecimalFormat(dollarFormat).format(dblAmt);
				String date = new SimpleDateFormat("yyyy-MM-dd")
						.format(transaction.getDate());
				response = response + "{\"date\" : \"" + date
						+ "\", \"transaction_type\" : \""
						+ transaction.getTransactionType()
						+ "\", \"amount\" : \"" + amount + "\" },\n";
			}
			response = response + "],\n";
		} catch (Exception e) {
			return "Error: " + e.getLocalizedMessage();
		}

		return response;

	}

}
