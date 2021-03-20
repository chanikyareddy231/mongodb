package steve;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Test3 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//create a database
		MongoDatabase db=mc.getDatabase("indiadb");
		//create a collection
		MongoCollection<Document> col=db.getCollection("people");
		Document doc=new Document("name","rahul").append("age","53").append("designation","pm")
				                  .append("url","http//www.rahul gandhi.com");
		col.insertOne(doc);
		

	}

}
