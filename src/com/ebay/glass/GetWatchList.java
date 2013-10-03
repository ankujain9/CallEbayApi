package com.ebay.glass;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetMyeBayBuyingCall;
import com.ebay.soap.eBLBaseComponents.ItemListCustomizationType;
import com.ebay.soap.eBLBaseComponents.PaginatedItemArrayType;

public class GetWatchList {

	public void getWatchAndBidList(){
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
		} 
}}
