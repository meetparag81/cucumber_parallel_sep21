package RestApi;

import com.sun.jersey.api.client.config.ClientConfig;

public class RestAPI {

	public static String GetEmployeeIDwithinyear(String URL, String URIc) {{
         String EmployeeID = "";
         System.setProperty("https.protocols", "SSLv1");
         System.setProperty("https.protocols", "SSLv2");
         System.setProperty("https.protocols", "SSLv3");
        //====================================================================================================================================
        // This is where we get the total employee count based on the filters 
        //====================================================================================================================================
        String queryc = URL + URIc;
        
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(MyClientResponseFilter.class);
        clientConfig.register(new AnotherClientFilter());

        Client client = ClientBuilder.newClient(clientConfig);
        client.register(ThirdClientFilter.class);
        
         RestClient clientc = new RestClient(queryc);
        clientc.Authenticator = basicAuthenticator;
        var requestc = new RestRequest(Method.GET);
        requestc.AddHeader("Postman-Token", "8296a6ab-4616-4eab-8513-5497b39b4a02");
        IRestResponse responsec = clientc.Execute(requestc);
        string responseContentc = responsec.Content;
        int statusCodec = (int)responsec.StatusCode;
        string responseErrormMessagec = responsec.ErrorMessage;
        if (responsec.StatusCode == HttpStatusCode.OK)
        {
            Console.WriteLine("Request success");
            dynamic apic = JObject.Parse(responseContentc);
            int count = apic.d.__count;
            Console.WriteLine("Count :" + count);
            //==============================================================================================================================================
            //Getting a random employee based on the filters and total employee count 
            //==============================================================================================================================================
            Random random = new Random();
            int randomNumber = random.Next(0, count);
            string URI = URIc + "&$skip=";
            string query = URL + URI + randomNumber;
            Console.WriteLine(query);
            var client = new RestClient(query);
            client.Authenticator = basicAuthenticator;
            var request = new RestRequest(Method.GET);
            request.AddHeader("Postman-Token", "8296a6ab-4616-4eab-8513-5497b39b4a02");
            IRestResponse response = client.Execute(request);
            string responseContent = response.Content;
            int statusCode = (int)response.StatusCode;
            string responseErrormMessage = response.ErrorMessage;
            if (response.StatusCode == HttpStatusCode.OK)
            {
                Console.WriteLine("Request success");
                dynamic api = JObject.Parse(responseContent);
                EmployeeID = api.d.results[0].userId;
                Console.WriteLine("Employee ID :" + EmployeeID);
            }
            else
            {
                Console.WriteLine("Request failed");
                Console.WriteLine("status code is : " + statusCode);
                Console.WriteLine("Error mesaage is :" + responseErrormMessage);
            }
        }
        else
        {
            Console.WriteLine("Request failed");
            Console.WriteLine("status code is : " + statusCodec);
            Console.WriteLine("Error mesaage is :" + responseErrormMessagec);
        }



        return EmployeeID;
    }}

}
