package steve;



import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;



public class Test6 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//access the database
		MongoDatabase db=mc.getDatabase("indiadb");
		//delete macthing document form collection
		MongoCollection<Document> col=db.getCollection("people");
		col.deleteMany(Filters.eq("name","rahul gandhi"));
	}
}
