import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class WriteCsv {
	
	public static void main(String[] args) throws IOException	{
		String fileName = "C:\\Jerome\\CSV\\may redirects-seton ca 2";
		String fileNameCsv = fileName + ".csv";
		System.out.println(fileNameCsv);
		String generateCsv = fileName + "_TestResults.csv";
		FileWriter fw = new FileWriter(generateCsv);
		PrintWriter pw = new PrintWriter(fw);
		File file = new File(fileNameCsv); //File = Java file class
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.next();inputStream.next();inputStream.next();inputStream.next();
			while (inputStream.hasNext()){
				String data = inputStream.next(); //Gets a whole line
				String delims = "[,]";
				String[] values = data.split(delims);
				System.out.println(values[0] + "***");
				pw.print(values[0]+","+values[1]);
				pw.println("");
			}
			inputStream.close();
			pw.flush();
			pw.close();
			fw.close();
		}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
}