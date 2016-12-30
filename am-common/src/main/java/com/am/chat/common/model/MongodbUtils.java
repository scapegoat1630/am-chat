package com.chat.utils;


import java.util.List;

import org.apache.log4j.Logger;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/*
 * 后期在完善
 * 余
 * 
 * */
public class MongodbUtils {
    private static Logger logger = Logger.getLogger(MongodbUtils.class);
	
	private static MongoCredential credential;
	private static MongoClient mongoClient;
	private static MongoClient copyClient;
	private static MongoDatabase mongoDatabase;
	public static MongoCollection<Document> mongoCollection;
	
	
	@Value("${user}")
	private static String user = "root";
	@Value("${password}")
	private static String password = "root";
	@Value("${database}")
	private static String database = "data";
	@Value("${host}")
	private static String host = "127.0.0.1";
	@Value("${collectionName}")
	private static String collectionName = "test";
	@Value("${port}")
	private static int port = 27017;

	static {
		try {
//			credential = MongoCredential.createCredential(user, database,password.toCharArray());
			mongoClient = new MongoClient(new ServerAddress(host, port));
			mongoDatabase = mongoClient.getDatabase(database);
			
		} catch (Exception e) {
			  logger.error(e.getMessage(), e);
		}
	
	}
//	public void getMongoDatabase(String puser,String pdatabase,String ppassword,String phost,int pport) {
//
//		
//		credential = MongoCredential.createCredential(user, database,password.toCharArray());
//		mongoClient = new MongoClient(new ServerAddress(host, port),Arrays.asList(credential));
//		mongoDatabase = mongoClient.getDatabase(database);
//	}
//	连接复制集
//	public void connectionCopy() {
//		copyClient = new MongoClient(
//		          Arrays.asList(new ServerAddress("localhost", 27017),
//		                        new ServerAddress("localhost", 27018)),
//		          Arrays.asList(MongoCredential.createCredential(user, database, password.toCharArray())));
//	}
//	
//	
	public static MongoCollection<Document> getCollection(String name) {
		try {
		       if (collectionName.equals(name)) {
			        if (mongoCollection==null) {
			        	mongoCollection =  mongoDatabase.getCollection(collectionName);
					} 
		        }else {
		        	mongoCollection =  mongoDatabase.getCollection(name);
		        	collectionName=name;
				}	
			
		} catch (Exception e) {
			  logger.error(e.getMessage(), e);
		}

	    	return mongoCollection;
	}
	public static void insert(String json ) {
		mongoCollection =  getCollection(collectionName);
		Document document= JSONObject.parseObject(json, Document.class);
		mongoCollection.insertOne(document);
	}
	public static void insert(String json,String collectionName) {
		mongoCollection =  getCollection(collectionName);
		Document document= JSONObject.parseObject(json, Document.class);
		mongoCollection.insertOne(document);
	}
	public static void insert(Document document,String collectionName) {
		mongoCollection =  getCollection(collectionName);
		mongoCollection.insertOne(document);
	}


	public static void insertList(String json,String collectionName) {
		mongoCollection =  getCollection(collectionName);
		List<Document> list = JSONObject.parseArray(json, Document.class); 
		mongoCollection.insertMany(list);	
	}
	public static void insertList(List<Document> list,String collectionName) {
		mongoCollection =  getCollection(collectionName);
		mongoCollection.insertMany(list);	
	}
	
    public static void delect(Bson filter, String collectionName) {
    	mongoCollection =  getCollection(collectionName);
    	mongoCollection.deleteMany (filter);  
		
	}
    
    public static void update(Bson filter,Document document, String collectionName) {
    	mongoCollection =  getCollection(collectionName);
    	mongoCollection.updateMany(filter, new Document("$set",document));  	
	}

    

    public static MongoCursor<Document> quary(String collectionName) {
          return  quary(collectionName, 0, 0);
	}
    
    public static MongoCursor<Document> quary(Bson filter,String collectionName) {
        return  quary(filter,collectionName, 0, 0);
	}
    
    public static MongoCursor<Document> quary(String collectionName,int limit) {
  	  return quary(new BsonDocument(), collectionName, limit, 0);
	}
    
    public static MongoCursor<Document> quary(String collectionName,int limit,int skip) {
    	  return quary(new BsonDocument(), collectionName, limit, skip);
	}
    
    public static MongoCursor<Document> quary(Bson filter, String collectionName,int limit,int skip) {
    	mongoCollection =  getCollection(collectionName);
    	MongoCursor<Document> cursor;
    	if (limit==0) {
    	   cursor=mongoCollection.find(filter).iterator();
		}else {
		   cursor=mongoCollection.find(filter).limit(limit).skip(skip).iterator();
		}
    	return cursor;
	}
	
	public static void main(String[] args) {
		
		
//		
//		String json="[{\"username\":\"111\"},{\"username\":\"222\"}]";
//	
//        insert(json, collectionName);

        
//        delect(filerBson, collectionName) ;
        
        MongoCursor<Document>  cursor= quary(collectionName,0,0);
        while (cursor.hasNext()) {
		   Document document = (Document) cursor.next();
		   System.out.println(document.get("username1"));
	    }
		
	}
	
	
}
