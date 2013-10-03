package com.ebay.glass;

import java.util.Calendar;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;

public class GetTimeNow {

	public static void getTime() {
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
		} catch (Exception e) {
			System.out.println("Fail to get eBay official time.");
			e.printStackTrace();
		}

	}

}
