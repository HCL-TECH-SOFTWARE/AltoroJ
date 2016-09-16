package com.ibm.security.appscan.altoromutual.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.wink.json4j.*;

import com.ibm.security.appscan.altoromutual.util.OperationsUtil;

@Path("transfer")
public class TransferAPI extends AltoroAPI {
	
	@POST
	public Response trasnfer(String bodyJSON,
			@Context HttpServletRequest request) {

		
		/*if (!ServletUtil.isLoggedin(request)) {
			response = "{\"loggedIn\" : \"false\"}";
			return Response.status(400).entity(response).build();
		}*/
		
		JSONObject myJson = new JSONObject();
		Long creditActId;
		String fromAccount;
		double amount;
		String message;
		
		try {
			myJson =new JSONObject(bodyJSON);
			//Get the transaction parameters
			creditActId = Long.parseLong(myJson.get("toAccount").toString());
			fromAccount = myJson.get("fromAccount").toString();
			amount = Double.parseDouble(myJson.get("transferAmount").toString());
			message = OperationsUtil.doTransfer(request,creditActId,fromAccount,amount);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).entity("{\"Error\": \"Request is not in JSON format\"}").build();
		}

		
		
		
		if(message.startsWith("ERROR")){
			return Response.status(500).entity("\"error\":\"" + message+"\"}").build();
		}
		
		return Response.status(200).entity("{\"success\":\""+message+"\"}").build();
	}
}
