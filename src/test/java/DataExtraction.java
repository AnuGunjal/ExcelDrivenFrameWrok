import java.io.IOException;
import java.util.ArrayList;

public class DataExtraction {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataDriven d = new DataDriven();
		
	  ArrayList<String> at=	d.getData("Buy");
	  
	  System.out.println(at.get(0));
	  System.out.println(at.get(1));
	 System.out.println(at.get(2));
	 System.out.println(at.get(3));
	  

	}

}
