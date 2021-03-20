package steve;



import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;



public class Test7 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//access the database
		MongoDatabase db=mc.getDatabase("indiadb");
		//collect and display names of all collections in database
		MongoIterable<String> l=db.listCollectionNames();
		for(String n:l)
		{
			System.out.println(n);
		}
		//close mongo site
		mc.close();
		
	}

}
