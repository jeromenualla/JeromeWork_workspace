
public class Comparator {

	public static String CompareURL(String Expected,String Actual, String StatusCodeActual){
		if((Actual.equals(Expected))&&(StatusCodeActual.equals("200"))){
			return "PASS";
		}else{
			return "FAIL";
		}
		
	}
	
}
