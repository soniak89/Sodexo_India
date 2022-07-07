package Sodexo.SodexoIndia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class payload {
	public static String Addplace() throws IOException
	{
		//LocalDate date=java.time.LocalDate.now();
		//Date yourDate = new Date(date);
		
		/*SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy"); 
		String currentdate = DATE_FORMAT.format(date);*/
		String currentdate=LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
		String content = new String(Files.readAllBytes(Paths.get("C:\\GITRepo\\SodexoIndia\\src\\test\\java\\Sodexo\\SodexoIndia\\Test.txt")));
		//final String CONSTANT = org.apache.commons.lang.StringUtils.join( new String[] {""} );
		return "{\r\n"
				+ "    \"FileName\": \"SoniaTESTFILE.pdf\",\r\n"
				+ "    \"FileData\": \""+content+"\",\r\n"
				+ "     \"MobilisePo\":\"PO/0274106\",\r\n"
				+ "    \"GRN\":\"Veg & N Veg Trans. O\",\r\n"
				+ "    \"ProfitCenterCode\":\"53003511\",\r\n"
				+ "    \"GLCode\":\"60620200\",\r\n"
				+ "    \"SubmittedBy\":\"sodexo.india@checkaninvoice.com\",\r\n"
				+ "    \"SubmittedDate\":\""+currentdate+"\"\r\n"
				+ "\r\n"
				+ "}";
	}

}
