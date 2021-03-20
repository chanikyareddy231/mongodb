package steve;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Test5 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//access the database
		MongoDatabase db=mc.getDatabase("indiadb");
		//update matching document in collection
		MongoCollection<Document> col=db.getCollection("people");
		col.updateMany(Filters.eq("name","rahul"),Updates.set("name","rahul gandhi"));
		

	}

}
