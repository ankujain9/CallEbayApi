package com.ebay.glass;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.PlaceOfferCall;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BidActionCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.OfferType;
import com.ebay.soap.eBLBaseComponents.SellingStatusType;

public class PlaceOfferNow1 {

	public void placeBid(){
		try {
			ApiContext apiContext = GetApiContext.getApiContext();
			PlaceOfferCall apiCall = new PlaceOfferCall(apiContext);
			apiCall.setItemID("110124751127");

			OfferType offer = new OfferType();
			offer.setAction(BidActionCodeType.BID);

			AmountType amount = new AmountType();
			amount.setCurrencyID(CurrencyCodeType.USD);
			amount.setValue(3.0);

			offer.setMaxBid(amount);
			offer.setQuantity(1);
			apiCall.setOffer(offer);

			apiCall.setEndUserIP("195.34.23.32");

			System.out.println("Begin to cal eBay API, please wait ... ");
			SellingStatusType sellingStatus = apiCall.placeOffer();
			System.out.println("End to cal eBay API, show call result ...");
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			e.printStackTrace();
		}

	}
}
