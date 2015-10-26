package com.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;


import java.util.ArrayList;
import java.util.List;

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

       /* for (int i = 0; i <= myDocs.size(); i++) {
            Document d1 = myDocs.get(i);
            Document temp = myDocs.get(i++);
            if ((Double) d1.get("student_id") == (Double) temp.get("student_id")) {
                if ((Double) d1.get("score") < (Double) temp.get("score")) {
                    collection.deleteOne(d1);
                } else {
                    collection.deleteOne(temp);
                }
                i--;
            }*/
        /*for(org.bson.Document d:myDocs){


            Helper.prettyPrintJSON(d);
        }*/
       MongoCursor<Document> cursor = collection.find(filter).iterator();
       // System.out.println(myDocs.size());
        try{
            while (cursor.hasNext()){

                Document cur1 = cursor.next() ;
                //Helper.prettyPrintJSON(cur1);
                Double s = (Double)cur1.get("score");
                System.out.print(s+"***********");
                if(cursor.hasNext()) {

                    Document cur2 = cursor.tryNext();
                    Double s2 = (Double) cur2.get("score");
                    System.out.println(s + "XXXXXXX");
                    /*if ((Double) cur1.get("student_id") == (Double) cur2.get("student_id")) {
                        if ((Double) cur1.get("score") < (Double) cur2.get("score")) {
                            collection.deleteOne(cur1);
                        } else {
                            collection.deleteOne(cur2);
                        }
                    }*/
                }
            }

        }
        finally {
            cursor.close();
        }
          System.out.println("\nCount After Deletion: ");
            System.out.println(myDocs.size());


       /* for(org.bson.Document d:myDocs){


            Helper.prettyPrintJSON(d);
        }*/


        }
    /*public WriteResult remove(DBObject query) {


        return null;


    }*/


    }


