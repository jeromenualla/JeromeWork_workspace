import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MAIN {

	public static void main (String[] args) throws Exception {
	    
		String fileName = "\\\\10.192.200.25\\csv\\CSV - EMEDCOTEST";
        String fileNameCsv = fileName + ".csv";
        File file = new File(fileNameCsv); //File = Java file class
        Date date= new Date(); // java.util.Date will get date today 
        SimpleDateFormat df = new SimpleDateFormat(); //apply format to date
        df.applyPattern("MMddyyyy_hhmmaa"); // this is the format to apply
        String generateCsv = fileName+"_TestResults_"+ df.format(date) +".csv";
        FileWriter fw = new FileWriter(generateCsv);    //This is the FileWriter
        PrintWriter pw = new PrintWriter(fw);    //This Writes the Content of the File
        pw.println("Current URL"+","+"Redirect To URL"+","+"Requestor"+","+"Date"+","+"Actual Redirect URL"+","+"404 on Title"+","+"Test Result");
        pw.flush();
        
        int x = 1;
        
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.next();inputStream.next();inputStream.next();inputStream.next();
            
            while (inputStream.hasNext()){
                String data = inputStream.next(); 
                String[] values = data.split(",");
                System.out.println(x);
                String URLtoPASS = values[0];
        		String[] URLPASSED = ResponseCodeCheck.URLChecker(URLtoPASS).split(",");
        		pw.println(values[0]+","+values[1]+","+values[2]+","+values[3]+","+URLPASSED[0]+","+URLPASSED[1]);
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
