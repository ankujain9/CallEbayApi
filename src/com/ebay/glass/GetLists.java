package com.ebay.glass;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetMyeBayBuyingCall;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.PaginatedItemArrayType;

/**
 * Servlet implementation class GetLists
 */
public class GetLists extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLists() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ApiContext apiContext = GetApiContext.getApiContext();
			GetMyeBayBuyingCall buyingCall = new GetMyeBayBuyingCall(apiContext);
			
			ItemListCustomizationType bidType = new ItemListCustomizationType();
			bidType.setInclude(true);
			buyingCall.setBidList(bidType);
			
			ItemListCustomizationType watchList = new ItemListCustomizationType();
			watchList.setInclude(true);
			
			buyingCall.setWatchList(watchList);

//			buyingCall.setItemID("110124751127");


			buyingCall.setEndUserIP("195.34.23.32");

			System.out.println("Begin to cal eBay API, please wait ... ");
			buyingCall.getMyeBayBuying();
			if(buyingCall.hasError()){
				System.out.println("errir");
			}
			
			PaginatedItemArrayType returnWatchList = buyingCall.getReturnedWatchList();
			System.out.println(returnWatchList.getItemArray().getItem().length);
			
			PaginatedItemArrayType returnBidList = buyingCall.getReturnedBidList();
			System.out.println(returnBidList.getItemArray().getItem().length);
			System.out.println(returnBidList.getItemArray().getItem(0).getItemID());
			
			System.out.println("End to cal eBay API, show call result ...");
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			e.printStackTrace();
		} 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
