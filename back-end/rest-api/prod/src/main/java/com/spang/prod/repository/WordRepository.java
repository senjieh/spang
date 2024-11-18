package com.spang.prod.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.spang.prod.model.Word;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class WordRepository {

    @Autowired
    private MongoClient mongoClient;

    private static final String DATABASE_NAME = "spang_prod";

    public Word findWord(String lang_setting, String word) {

        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(lang_setting);
        
        Document result = collection.find(Filters.eq("word", word)).first();

        // Map the MongoDB document to a Word object
        Word foundWord = new Word();
        foundWord.setWord(result.getString("word"));
        foundWord.setId(result.getInteger("_id"));
        // Retrieve the "def" field as a list of strings
        List<String> defDocument = result.getList("def", String.class);

        // Use an empty list if "def" is null or not present
        List<String> defMap = defDocument != null ? defDocument : new ArrayList<>();

        foundWord.setDef(defMap);

        return foundWord;
    }
}