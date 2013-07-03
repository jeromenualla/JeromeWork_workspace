
public class CompareLive {
	
	 public static String compareprod(String CurrentURL) throws Exception {
		 String convertCurrentURL ="";
		 if (CurrentURL.startsWith("http://setonstage.zeondemo.com")) {
			 convertCurrentURL= CurrentURL.replaceFirst("http://setonstage.zeondemo.com", "http://www.seton.com");
		 } else if (CurrentURL.startsWith("setonstage.zeondemo.com")) {
			 convertCurrentURL= CurrentURL.replaceFirst("setonstage.zeondemo.com", "http://www.seton.com");
		 } 
		 else if (CurrentURL.startsWith("http://setoncastg.zeondemo.com")) {
			 convertCurrentURL= CurrentURL.replaceFirst("http://setoncastg.zeondemo.com", "http://www.seton.ca");
		 } else if (CurrentURL.startsWith("setoncastg.zeondemo.com")) {
			 convertCurrentURL= CurrentURL.replaceFirst("setoncastg.zeondemo.com", "http://www.seton.ca");
		 } 	
		 else if (CurrentURL.startsWith("http://emedco.zeondemo.com")) {
			 convertCurrentURL= CurrentURL.replaceFirst("http://emedco.zeondemo.com", "http://www.emedco.com");
		 } else if (CurrentURL.startsWith("setoncastg.zeondemo.com")) {
			 convertCurrentURL= CurrentURL.replaceFirst("emedco.zeondemo.com", "http://www.emedco.com");
		 }
		 else{
			 convertCurrentURL = CurrentURL;
		 }
		 
		 return convertCurrentURL;
    }
	
}
