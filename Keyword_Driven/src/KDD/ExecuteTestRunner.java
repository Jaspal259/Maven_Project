package KDD;

import java.io.IOException;

public class ExecuteTestRunner {

	public static void main(String[] args) throws IOException {

		resusableFuction func = new resusableFuction();
		
		String[][] KeywordsData = func.fetchDataFromExcel();
		
		int rownum = KeywordsData.length;
		int colnum = KeywordsData[0].length;
		
		String TC_Name = KeywordsData[0][0];
		String TC_Step_No = KeywordsData[0][1];
		String TC_Step_Name = KeywordsData[0][2];
		String TC_func = KeywordsData[0][3];
		String TC_location = KeywordsData[0][4];
		String TC_LV = KeywordsData[0][5];
		String TC_param = KeywordsData[0][6];
		String TC_Execute= KeywordsData[0][7];
		
		
		for(int column=1;column < rownum;column++)
		{
			String function = KeywordsData[column][3];
			String LocatorBy = KeywordsData[column][4];
		//	String LocatorElement = func.fetchprop(KeywordsData[column][5]);
			String LocatorElement = KeywordsData[column][5];

			String content_param = KeywordsData[column][6];
			String execute = KeywordsData[column][7];
			
			System.out.println(execute);

			
			System.out.println(function +"\t"+ LocatorBy +"\t"+ LocatorElement +"\t"+ content_param );
			if(execute.equals("Y"))
			{
			switch (function) {
			case "launchAppl":
				func.launchAppl();
				break;
			case "filltext":
				func.filltext(LocatorBy, LocatorElement, content_param);
				break;	
			case "click":
				func.click(LocatorBy, LocatorElement);

			default:
				break;
			}


		}
		}

		

		
		
	}

}
