package com.ebay.glass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.PlaceOfferCall;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.OfferType;
import com.ebay.soap.eBLBaseComponents.SellingStatusType;

/**
 * Servlet implementation class PlaceOfferNow
 */
public class PlaceOffer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceOffer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try {
			String itemId = request.getParameter("itemId");

			Double finalPrice = 0.0;
			if (request.getParameter("amount") != null) {
				finalPrice = Double.parseDouble((String) request
						.getParameter("amount"));
			} else {
				Double price = getCurrentPrice(itemId);
				finalPrice = getBidIncrements(price);
			}

			ApiContext apiContext = GetApiContext.getApiContext();
			PlaceOfferCall apiCall = new PlaceOfferCall(apiContext);
			apiCall.setItemID(itemId);

			OfferType offer = new OfferType();
			offer.setAction(BidActionCodeType.BID);

			AmountType amount = new AmountType();
			amount.setCurrencyID(CurrencyCodeType.USD);
			amount.setValue(finalPrice);

			offer.setMaxBid(amount);
			offer.setQuantity(1);
			apiCall.setOffer(offer);

			apiCall.setEndUserIP("195.34.23.32");

			System.out.println("Begin to cal eBay API, please wait ... ");
			SellingStatusType sellingStatus = apiCall.placeOffer();
			pw.print(0);
			System.out.println("End to cal eBay API, show call result ...");
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			pw.print(1);
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

	private Double getCurrentPrice(String itemId) {
		try {
			JSONObject itemDetails = GetItemDetails.getItemDetails(itemId);
			Double price;

			price = (Double) itemDetails
					.get("Item.ConvertedCurrentPrice.Value");
			return price;

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}

	private Double getBidIncrements(Double price) {

		if (price < 10) {
			return price + 1;
		} else if (price >= 10 && price < 25) {
			return price + 2;
		} else if (price >= 25 && price < 100) {
			return price + 3;
		} else {
			return price + 5;
		}
	}
}
