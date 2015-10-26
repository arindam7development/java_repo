package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.*;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;


import java.util.*;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {  // MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(100).build();
        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("students");
        MongoCollection<org.bson.Document> collection = db.getCollection("grades");

        /*collection.deleteMany(gte("student_id", 199));*/
        Bson sort = new Document("student_id", 1).append("score", 1);
        Bson filter = new Document("type", "homework");
        List<org.bson.Document> myDocs = collection.find(filter).sort(sort).into(new ArrayList<org.bson.Document>());
        //collection.deleteMany(lte("score",61));
        System.out.println("\nCount Before Deletion : ");
        System.out.println(myDocs.size());


        List<Double> home_work = new ArrayList<Double>();
        for (int i = 0; i < myDocs.size()-1; i++) {

            //System.out.println(myDocs.get(i).getInteger("student_id"));
            //System.out.println(myDocs.get(i + 1).getInteger("student_id"));
            if (myDocs.get(i).getInteger("student_id").equals(myDocs.get(i + 1).getInteger("student_id"))) {
                //System.out.println("true");

                  if(myDocs.get(i).getDouble("score")<myDocs.get(i + 1).getDouble("score"))
                  {
                      Boolean b = home_work.add(myDocs.get(i).getDouble("score"));
                      //System.out.println("Least HomeWork score " + myDocs.get(i).getDouble("score") + " at Location" + (i));
                      System.out.println("Added "+b);
                  }
                 else {
                      Boolean b = home_work.add(myDocs.get(i + 1).getDouble("score"));
                     // System.out.println("Least HomeWork score " + myDocs.get(i+1).getDouble("score") + " at Location" + (i+1));
                      System.out.println("Added "+b);
                  }




            }

        }

        System.out.println("Least Home Work Scores");
        int c = 0 ;
        Iterator<Double> hw = home_work.iterator();

        while (hw.hasNext()) {


            System.out.println(hw.next());
            //collection.deleteOne(eq("score",hw.next()));

        }

        System.out.println("No of least scores"+c);
        System.out.println("\nCount After Deletion: ");
        System.out.println(myDocs.size());
        System.out.println(home_work.size());
       /* for(org.bson.Document d:myDocs){


            Helper.prettyPrintJSON(d);
        }*/






    }
}
