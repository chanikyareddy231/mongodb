package steve;


import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test4 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//create a database
		MongoDatabase db=mc.getDatabase("indiadb");
		//create a collection
		MongoCollection<Document> col=db.getCollection("people");
		Document doc1=new Document("name","rahul").append("age","50").append("designation","upcoming pm")
				                  .append("url","http//www.rahulgandhi.com");
		Document doc2=new Document("name","anuska").append("age","27").append("designation","heroin")
                .append("url","http//www.anuska setty.com");
		Document doc3=new Document("name","kohli").append("age","50").append("designation","captain of indian cricket")
                .append("url","http//www.anushka sharma.com");
		ArrayList<Document> l=new ArrayList<Document>();
		l.add(doc1);
		l.add(doc2);
		l.add(doc3);
	    col.insertMany(l);
		

	}

}
