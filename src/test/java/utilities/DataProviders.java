package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public Object [][] loginData() throws IOException
	{
		ExcelUtility utils = new ExcelUtility("./testdata/test.xlsx");
		int rownum = 	utils.getRowCount("Sheet1");
		System.out.println(rownum);
		int cellnum = utils.getCellCount("Sheet1", 0);
		System.out.println(cellnum);
		Object LoginData [][] = new Object[rownum+1][cellnum];
		for(int i=0;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
			String data = 	utils.getCellData("Sheet1", i, j);
			System.out.println(data);
			LoginData[i][j] = data;
			}
			
		}
		
		return LoginData;
	}

}
