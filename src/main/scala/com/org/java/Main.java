package com.org.java;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Main {

    public static void printjsonarraykeys(Object obj, String parentpath)
    {
        JSONArray arrayobj = (JSONArray)obj;

        for(int i =0; i<arrayobj.size(); i++)
        {
            JSONObject jo = (JSONObject)arrayobj.get(i);
            if(jo instanceof JSONObject){

                printjsonkeys(jo, parentpath+i);
            }
        }

    }
    public static void printjsonkeys(Object obj,String parentPath){
        try {


            JSONObject jsonObject = (JSONObject) obj;
            //String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
            for(Object key : jsonObject.keySet())
            {
                Object keyValue = jsonObject.get((String)key);


                if(keyValue instanceof JSONObject){

                    printjsonkeys(keyValue,parentPath.isEmpty() ? key.toString(): parentPath + "." + key.toString() );
                }
                else if (keyValue instanceof JSONArray){
                    printjsonarraykeys(keyValue,parentPath.isEmpty() ? key.toString(): parentPath + "." + key.toString() );
                }
                System.out.print(parentPath +"." + key + "--------");

            }


//            JsonReader jsonReader = Json.createReader(new FileReader("D:\\de\\onlinerealtime.json"));
//            JsonObject jsonObject1 = jsonReader.readObject();
//            jsonReader.close();

            // JsonArray ja = jsonObject1.("_links");


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static String currentPath = "";
    public static void main(String[] args)  {

        String command = "\"C:\\Program Files (x86)\\PDFConvert\\pdfconvert.exe\" /cs 10000 /i \"c:\\pdf\\demo.pdf\" /o \"c:\\word\" /pwo 2";
        System.out.println(command);
        try {

            JSONParser parser = new JSONParser();
            System.out.println("Hello World!");
            String filePath="/Users/thirupathi.c/Downloads/onlinerealtime.json";
            Object obj = parser.parse(new FileReader(filePath));
            printjsonkeys(obj,"");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
