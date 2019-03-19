package com.ibm.security.appscan.altoromutual.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.wink.json4j.*;

import com.ibm.security.appscan.altoromutual.util.OperationsUtil;

@Path("transfer")
public class TransferAPI extends AltoroAPI {
	
	@POST
	public Response trasnfer(String bodyJSON,
			@Context HttpServletRequest request) {
		
		JSONObject myJson = new JSONObject();
		Long creditActId;
		Long fromAccount;
		double amount;
		String message;
		
		try {
			myJson =new JSONObject(bodyJSON);
			//Get the transaction parameters
			creditActId = Long.parseLong(myJson.get("toAccount").toString());
			fromAccount = Long.parseLong(myJson.get("fromAccount").toString());
			amount = Double.parseDouble(myJson.get("transferAmount").toString());
			message = OperationsUtil.doApiTransfer(request,creditActId,fromAccount,amount);
		} catch (JSONException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("An error has occurred: " + e.getLocalizedMessage()).build();
		}
			
		if(message.startsWith("ERROR")){
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("\"error\":\"" + message+"\"}").build();
		}
		
		return Response.status(Response.Status.OK).entity("{\"success\":\""+message+"\"}").type(MediaType.APPLICATION_JSON_TYPE).build();
	}
}
