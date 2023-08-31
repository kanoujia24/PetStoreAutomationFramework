package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class TestDataProvider {
@DataProvider(name="Data")

public String[][]getAllData() throws IOException{//this method return whole data
String path=System.getProperty("user.dir")+"//TestData//user.data.xlsx";
XLUtils xl=new XLUtils(path);
int rownum=xl.getRowCount("Sheet1");
int colnum=xl.getCellCount("Sheet1", 1);
String apiData[][]=new String[rownum][colnum];
for(int i=1;i<=rownum;i++) {
	for(int j=0;j<colnum;j++) {
		apiData[i-1][j]=xl.getCellData("Sheet1", i, j);
	}
}
  return apiData;

}

@DataProvider(name="userName")
public String[] getUserName() throws IOException {
	String path=System.getProperty("user.dir")+"//TestData//user.data.xlsx";
	XLUtils xl=new XLUtils(path);
	int rownum=xl.getRowCount("Sheet1");
	String apiData[]=new String[rownum];
	for(int i=1;i<=rownum;i++) {
		apiData[i-1]=xl.getCellData("Sheet1",i,1);
	}
	return apiData;
}
}