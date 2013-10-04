package com.ebay.glass;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;



@SuppressWarnings("deprecation")
public class GetItemDetails {

	private static HttpClient http_client;
	public static final int HTTP_TIMEOUT = 30 * 1000; // milliseconds
	
	@SuppressWarnings("deprecation")
	private static HttpClient getHttpClient() {
		if (http_client == null) {
			http_client = new DefaultHttpClient();
			final HttpParams params = http_client.getParams();
			HttpConnectionParams.setConnectionTimeout(params, HTTP_TIMEOUT);
			HttpConnectionParams.setSoTimeout(params, HTTP_TIMEOUT);
		}
		return http_client;
	}
	
	public static JSONObject getItemDetails(String itemId) {

		String result = null;
		try {
			String url = "http://open.api.sandbox.ebay.com/shopping?callname=GetSingleItem&responseencoding=JSON&appid=Huangshu-1a32-4d55-9490-983ba5a49f3d&siteid=0&ItemID="+itemId+"&version=829";
			HttpResponse response;
			HttpClient client = getHttpClient();
			HttpGet request = new HttpGet(url);
			response = client.execute(request);

			if (response != null) {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			return new JSONObject(result);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Response from Server " + result);
		return null;
	}
	
	public static void main(String args[]){
		getItemDetails("110125158421");
	}
}
