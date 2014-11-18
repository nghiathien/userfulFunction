package per.thiennn.myuserfulfunction.utils;

import com.google.gson.Gson;

public class JsonUtils {

    public static String toJson(Object obj) {
        Gson gson = new Gson();
        try{
            return gson.toJson(obj);
        }catch(Exception e){
            return null;
        }
    }

    public static Object fromJson(String json, Class<?> T) {
        Gson gson = new Gson();
        try{
            return gson.fromJson(json, T);
        }catch(Exception e){
            return null;
        }
    }

}
