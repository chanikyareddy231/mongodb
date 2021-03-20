package steve;

import com.mongodb.MongoClient;

public class Test1 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//create a database
		mc.getDatabase("andhradb");
		

	}

}
