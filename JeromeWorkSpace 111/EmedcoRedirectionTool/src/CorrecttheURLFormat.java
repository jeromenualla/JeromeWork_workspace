
public class CorrecttheURLFormat {
	
	public static String CorrectURLFormat(String URLtoCorrect) {
		String convertCurrentURL;
		if (URLtoCorrect.startsWith("http://")) {
			convertCurrentURL=URLtoCorrect;
			return convertCurrentURL;
		}else{
			convertCurrentURL = "http://"+URLtoCorrect;
			return convertCurrentURL;
		}	
		
	}

}
