import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseCodeCheck {
	
	
		public static String URLChecker (String URLPASS,String ActualRedirect) throws Exception {
    	URL url = new URL(URLPASS);
    	HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    	if(ActualRedirect.equals("FALSE")){
    		connection.setInstanceFollowRedirects(false);	
    	} else {
    		connection.setInstanceFollowRedirects(true);
		}
    	
        connection.setRequestMethod("GET");
        
        try {
        connection.connect();
        
        int code = connection.getResponseCode();
        URL FinalURL = connection.getURL();
        
        if (code==200)
        {
            //System.out.println("OK");
        	
        	return FinalURL+","+code;
        }
        else {
        	return FinalURL+","+code;
        }
        
        }
        catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
        	URL FinalURL = connection.getURL();
        	return FinalURL+","+e;
        			
        }
    }
}