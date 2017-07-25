package com.example.williamgong.test2;


import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import android.content.Context;
/**
 * Created by William Gong on 7/8/2017.
 */
@DynamoDBTable(tableName = "contactList")
public class Contact {


    public Contact() {

    }

    public static UserTable getUser(int id, Context context) {
        AmazonClientManager manager = new AmazonClientManager(context);
        DynamoDBMapper mapper = new DynamoDBMapper(manager.ddb());
        return mapper.load(UserTable.class, id);
    }

    public static UserTable getUserTable() {

        return new UserTable();
    }

    public static void insertUser(UserTable user, Context context ) {

        AmazonClientManager manager = new AmazonClientManager(context);
        DynamoDBMapper mapper = new DynamoDBMapper(manager.ddb());
        mapper.save(user);
    }

    public static void deleteUser(UserTable user, Context context) {

        AmazonClientManager manager = new AmazonClientManager(context);
        DynamoDBMapper mapper = new DynamoDBMapper(manager.ddb());
        mapper.save(user);
    }

    @DynamoDBTable(tableName = "contactList")
    public static class UserTable {
        private int id;
        private String phoneNumber;
        private String user;

        @DynamoDBRangeKey(attributeName = "ID")
        public Integer getID() {
            return id;
        }

        public void setID(Integer id) {
            this.id = id;
        }

        @DynamoDBHashKey(attributeName = "Phone Numbers")
        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setNumber(String phone) {
            phoneNumber = phone;
        }

        @DynamoDBAttribute(attributeName = "Names")
        public String getUser(){
            return user;
        }

        public void setUser(String name){
            user = name;
        }
    }

}

