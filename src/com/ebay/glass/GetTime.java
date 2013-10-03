package com.ebay.glass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;

/**
 * Servlet implementation class GetTime
 */
public class GetTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			ApiContext apiContext = GetApiContext.getApiContext();

			// [Step 2] Create call object and execute the call
			GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(
					apiContext);
			System.out.println("Begin to cal eBay API, please wait ... ");
			Calendar cal = apiCall.geteBayOfficialTime();
			System.out.println("End to cal eBay API, show call result ...");

			// [Setp 3] Handle the result returned
			System.out.println("Official eBay Time : "
					+ cal.getTime().toString());
			PrintWriter pw = response.getWriter();
			pw.print(cal.getTime().toString());
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			PrintWriter pw = response.getWriter();
			pw.print("exception");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
