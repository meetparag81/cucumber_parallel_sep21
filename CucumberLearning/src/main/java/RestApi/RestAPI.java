package RestApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Authenticator;  
import java.net.PasswordAuthentication;  
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import utilities.ConfigReader;

public class RestAPI {
	
	public static void main(String[] args) {
		ConfigReader CR= new ConfigReader();
		
		String URL = "https://api41.sapsf.com/odata/v2/";
		 CR.Init_prop().getProperty("UATAPIUSERNAME");
		  
		GetEmployeeIDwithinyear(URL,CR.Init_prop().getProperty("UATAPIUSERNAME"),CR.Init_prop().getProperty("UATAPIPASSWORD"));
		
	}

	public static String GetEmployeeIDwithinyear(String URL, String apiusername, String apipassword) {
		
         String EmployeeID = "";
         /*System.setProperty("https.protocols", "SSLv1");
         System.setProperty("https.protocols", "SSLv2");
         System.setProperty("https.protocols", "SSLv3");*/
       //  String URIc =  "EmpJob?$format=json&$select=employmentNav/jobInfoNav,positionNav,userId,managerId,position,businessUnit,costCenter,customString28,customString36,customString37,customString38,eventReason,employmentNav/isContingentWorker,employmentNav/jobInfoNav/company,employmentNav/jobInfoNav/positionNav/type,employmentNav/jobInfoNav/positionNav/cust_EmploymentType,employmentNav/jobInfoNav/positionNav/cust_EmployeeClass&$inlinecount=allpages&$top=1&$expand=employmentNav/jobInfoNav,positionNav&$filter=employmentNav/isContingentWorker+eq+false +and+employmentNav/jobInfoNav/company+eq+'1010'+and+employmentNav/jobInfoNav/positionNav/type+eq+'RP'+and+employmentNav/jobInfoNav/positionNav/cust_EmploymentType+eq+'S'+and+employmentNav/jobInfoNav/positionNav/cust_EmployeeClass+eq+'RE'+and+emplStatus+eq+'56734'";
         String URIc="EmpJob?$format=json&$select=employmentNav/jobInfoNav,positionNav,userId,managerId,position,businessUnit,costCenter,customString28,customString36,customString37,customString38,eventReason,employmentNav/isContingentWorker,employmentNav/jobInfoNav/company,employmentNav/jobInfoNav/positionNav/type,employmentNav/jobInfoNav/positionNav/cust_EmploymentType,employmentNav/jobInfoNav/positionNav/cust_EmployeeClass&$inlinecount=allpages&$top=1&$expand=employmentNav/jobInfoNav,positionNav";
        //====================================================================================================================================
        // This is where we get the total employee count based on the filters 
        //====================================================================================================================================
        String queryc = URL+URIc;       
      //String queryc = URL;
        System.out.println(queryc);
        try {
        	//URL to fetch data from .
            URL url = new URL(queryc);
            
                PasswordAuthentication auth = new PasswordAuthentication(apiusername,apipassword.toCharArray());  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();           
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            String encoded = Base64.getEncoder().encodeToString((apiusername+":"+apipassword).getBytes(StandardCharsets.UTF_8));  //Java 8
            conn.setRequestProperty("Authorization", "Basic "+encoded);
            conn.setRequestProperty("Postman-Token", "8296a6ab-4616-4eab-8513-5497b39b4a02");
          int responsecode = conn.getResponseCode();
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

     
         /*RestClient clientc = new RestClient(queryc);
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

*/

        return EmployeeID;
    }

}
