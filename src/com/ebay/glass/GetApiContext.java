package com.ebay.glass;

import java.io.IOException;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;

public class GetApiContext {
 
	/**
	 * Populate eBay SDK ApiContext object with data input from user
	 * 
	 * @return ApiContext object
	 */
	public static ApiContext getApiContext() throws IOException {

		ApiContext apiContext = new ApiContext();

		// set Api Token to access eBay Api Server
		ApiCredential cred = apiContext.getApiCredential();
		cred.seteBayToken("AgAAAA**AQAAAA**aAAAAA**xH1MUg**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6wFk4GhC5CDpQidj6x9nY+seQ**d1ICAA**AAMAAA**TS21ocEdvEI4w+7PPHl177gbF9sfOF6XVfVa/x27HJnF+JoOOVL8WCdECiE8FCoC4sjEUd39pfwYmiBafeAtZwfRHPlLdmehs+ldJnwKyJN8DeagqnS1xPfBcAQkYO+0L+Z411/EPnNZXFMMLS4uHpUJOOatIzp8xr7tmWqYf1uwZa5GAupBQrTTsFQ7nRd01pcOB0VMWUZtVD74s/FoJ7BK6L4kk+3Tc0R64+qDoiidIAReLPOWIovHZ2i5myS1sPNCXDMFUbeB8ssMxVo+taEXlrric++qcYnET2njpzuNmrFIJC3imXapn+N4YBxItRVuxJ3uupt0Pb5TZ0hbjAe/E6zcyvQhL2v5ybdAvlziqlh5NEkAEIG+HPGhrU4iPK40eMBEiweErhRE5/NX7jbrVrVXkGYFkSj0VwoWQmbydTnZP9nz2hnEs6itBEb7bvUu9waKtGmly2Ns85F6OTVAggSQ9qTf9X/Oi0h4kyJ6vd/2/4J+fEY8zl0fwWIU1lug3qlGNxeeHiBlfUQBuxxd8I/KLqbSsX8OSGzUZ5yu9jZMa/faVfKyGoW0M3O/0fGfP0nco1M09NCunJhSE/fa2OJYV6HDS45wsm1J+e2qR7pLIYEoSPaKqxcnskNVwhqW5I0jfX53I98gGrez8I32pszIuG8/FS29Cyiyuwj7VxFNRv6BiNFA8E809yV1P6V98TEr2hNPq+MyQMfzMg0dj0f0nQzLxHbfwm8XyGX8ybxrl0VbllMMLUQzYQAE");
		apiContext.setApiServerUrl("https://api.sandbox.ebay.com/wsapi");

		return apiContext;
	}
}
