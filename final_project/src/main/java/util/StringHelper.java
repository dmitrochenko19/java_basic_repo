package util;

public class StringHelper {
     public static String replaceLast(String origin, String old, String newPart){
        old = new StringBuilder(old).reverse().toString();
        origin = new StringBuilder(origin).reverse().toString();
       newPart = new StringBuilder(newPart).reverse().toString();
       return new StringBuilder(origin.replaceFirst(old,newPart)).reverse().toString();
    }
}
