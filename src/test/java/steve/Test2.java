package steve;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Test2 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//create a database
		MongoDatabase db=mc.getDatabase("indiadb");
		//create a collection
		db.createCollection("people");
		

	}

}
