import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCsv {
	
	public static void main(String[] args)	{
		String fileName = "C:\\Jerome\\CSV\\CSV - SETONCA-1146 - LIVE v1- may redirects-seton ca 2.csv";
		File file = new File(fileName); //File = Java file class
		java.util.Date date= new java.util.Date();
		System.out.println(date);
		int x=1;
		try {
			Scanner inputStream = new Scanner(file);
			inputStream.next();inputStream.next();inputStream.next();inputStream.next();
			while (inputStream.hasNext()){
				String data = inputStream.next(); //Gets a whole line
				String[] values = data.split(",");
				System.out.println(x);
				System.out.println(values[0]);
				x++;
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
