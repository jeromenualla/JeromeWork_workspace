import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SetonUS_Redirection_Tool {

	public static void main (String[] args) throws Exception {
	    
		String fileName = "\\\\10.192.200.25\\csv\\CSV - Staging - SUS June redirects v2";
        String fileNameCsv = fileName + ".csv";
        File file = new File(fileNameCsv); //File = Java file class
        Date date= new Date(); // java.util.Date will get date today 
        SimpleDateFormat df = new SimpleDateFormat(); //apply format to date
        df.applyPattern("MMddyyyy_hhmmaa"); // this is the format to apply
        String generateCsv = fileName+"_TestResults_"+ df.format(date) +".csv";
        FileWriter fw = new FileWriter(generateCsv);    //This is the FileWriter
        PrintWriter pw = new PrintWriter(fw);    //This Writes the Content of the File
        pw.println("Current URL"+","+"Redirect To URL"+","+"Requestor"+","+"Date"+","+"URL_ENTERED"+","+"URL_ENTERED_STATUSCODE"+","+"FINAL_URL"+","+"FINAL_URL_STATUSCODE"+","+"PASS/FAIL"+","+"LIVE_REDIRECT_URL"+","+"LIVE_REDIRECT_URL_STATUSCODE");
        pw.flush();
        
        int x = 1;
        
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.next();inputStream.next();inputStream.next();inputStream.next();
            
            while (inputStream.hasNext()){
                String data = inputStream.next(); 
                String[] values = data.split(",");
                System.out.println(x);
                String URLtoCorrect1 = CorrecttheURLFormat.CorrectURLFormat(values[0]);
                String URLtoCorrect2 = CorrecttheURLFormat.CorrectURLFormat(values[1]);
                String URLtoPASS = URLtoCorrect1;
        		String[] URLPASSEDFOLLOWREDIRECTFALSE = ResponseCodeCheck.URLChecker(URLtoPASS,"FALSE").split(",");
        		String[] URLPASSEDFOLLOWREDIRECTTRUE = ResponseCodeCheck.URLChecker(URLtoPASS,"TRUE").split(",");
        		String CompareStatus = Comparator.CompareURL(URLtoCorrect2, URLPASSEDFOLLOWREDIRECTTRUE[0], URLPASSEDFOLLOWREDIRECTTRUE[1]);
        		String strCompareLive = CompareLive.ReturnLiveURL(URLtoCorrect2);
        		String URLCompareLive = ResponseCodeCheck.URLChecker(strCompareLive, "FALSE");
        		pw.println(URLtoCorrect1+","+URLtoCorrect2+","+values[2]+","+values[3]+","+URLPASSEDFOLLOWREDIRECTFALSE[0]+","+URLPASSEDFOLLOWREDIRECTFALSE[1]+","+URLPASSEDFOLLOWREDIRECTTRUE[0]+","+URLPASSEDFOLLOWREDIRECTTRUE[1]+","+CompareStatus+","+URLCompareLive);
        		pw.flush();
        		x++;
        		
            }
            inputStream.close();
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pw.close();
        fw.close();
	}
	
}
