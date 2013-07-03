public class CompareLive {

	public static String ReturnLiveURL(String URLPASSED){
		
		 String convertCurrentURL ="";
		 if (URLPASSED.startsWith("http://setonstage.zeondemo.com")) {
			 convertCurrentURL= URLPASSED.replaceFirst("http://setonstage.zeondemo.com", "http://www.seton.com");
		 } else if (URLPASSED.startsWith("setonstage.zeondemo.com")) {
			 convertCurrentURL= URLPASSED.replaceFirst("setonstage.zeondemo.com", "http://www.seton.com");
		 } 
		 else if (URLPASSED.startsWith("http://setoncastg.zeondemo.com")) {
			 convertCurrentURL= URLPASSED.replaceFirst("http://setoncastg.zeondemo.com", "http://www.seton.ca");
		 } else if (URLPASSED.startsWith("setoncastg.zeondemo.com")) {
			 convertCurrentURL= URLPASSED.replaceFirst("setoncastg.zeondemo.com", "http://www.seton.ca");
		 } 	
		 else if (URLPASSED.startsWith("http://emedco.zeondemo.com")) {
			 convertCurrentURL= URLPASSED.replaceFirst("http://emedco.zeondemo.com", "http://www.emedco.com");
		 } else if (URLPASSED.startsWith("setoncastg.zeondemo.com")) {
			 convertCurrentURL= URLPASSED.replaceFirst("emedco.zeondemo.com", "http://www.emedco.com");
		 }
		 else{
			 convertCurrentURL = URLPASSED;
		 }
		 
		return convertCurrentURL;
		
	}
}
