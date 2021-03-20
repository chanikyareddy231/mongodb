package steve;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class Test8 {

	public static void main(String[] args)
	{
		//create a mongo client
		MongoClient mc=new MongoClient("localhost",27017);
		//access the database
		MongoDatabase db=mc.getDatabase("indiadb");
		//COLLECT and Display all documents in collection
		MongoCollection<Document> col=db.getCollection("people");
		FindIterable<Document> docs=col.find();
		Iterator<Document> it=docs.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        mc.close();
		

	}

}
