package steve;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class Test10 {

	public static void main(String[] args) throws Exception
	{
		//Open Excel File
		File f=new File("src\\test\\resources\\Book1.xlsx");
		//Take Read Permision
		FileInputStream fi=new FileInputStream(f);
		//access that file as an Excel Work book
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();//count of used rows
		int nouc=sh.getLastRowNum(); //count of used columns
		//create result column(next to last column)with 
		//current date and column
		SimpleDateFormat sf=new SimpleDateFormat("DD-MMM-yyyy-hh-mm-ss");
	    Date dt=new Date();
	    sh.getRow(0).createCell(nouc).setCellValue("Result on "+sf.format(dt));
	    MongoClient mc=new MongoClient("localhost",27017);
	    MongoDatabase db=mc.getDatabase("mydb");
	    MongoCollection<Document> col=db.getCollection("posts");  
	    for(int i=1;i<nour;i++)
	    {
	    	DataFormatter df=new DataFormatter();
	    	String x=df.formatCellValue(sh.getRow(i).getCell(0));
	    	String y=df.formatCellValue(sh.getRow(i).getCell(1));
	    	String z=df.formatCellValue(sh.getRow(i).getCell(2));
	    	String w=df.formatCellValue(sh.getRow(i).getCell(3));
	    	try
	    	{
	    		Document doc=new Document ("name",x).append("age",y).append("designation",z).append("url",w);
	    		col.insertOne(doc);
	    		sh.getRow(i).createCell(nouc).setCellValue("Correct insertion");
	    	}
	    	catch (Exception ex)
	    	{
	    		sh.getRow(i).createCell(nouc).setCellValue(ex.getMessage()+"Wrong insertion");
	    	}
	    }
	    sh.autoSizeColumn(nouc);
	    FileOutputStream fo=new FileOutputStream(f);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
	}
}
