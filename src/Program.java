import java.io.*;
import java.util.HashMap;
import java.util.*;


public class Program {


    private static String webAdress = "";

    public static void main(String[] args) {


        System.out.println("\nАдрес web-страницы указывается в параметрах приложения. ");
        if (args.length == 1) {

            webAdress = args[0];
            perform();

        } else {
            System.out.println("\nПожалуйста, укажите один параметр: полный адрес web-страницы.");
        }

    }

    public static void perform() {

        try{
            System.out.println("\nАдрес: " + webAdress);
            HTMLDownloader downloader = new HTMLDownloader(webAdress);
            downloader.download();
            HTMLParser parser = new HTMLParser(webAdress);
            HashMap map = parser.parse();
            //System.out.println(map.toString());
            outputMap(map);
        }
        catch (IOException e){

            System.out.println("Ошибка: " + e.getMessage());
        }


    }

    public static void outputMap(HashMap map) {

        System.out.println("\nСтатистика по количеству слов в тексте указанной web-страницы:\n");
        Iterator<Map.Entry<String,Integer>> i = map.entrySet().iterator();

            while ( i.hasNext()){
                Map.Entry<String,Integer> e = i.next();
                String  key = e.getKey();
                Integer value = e.getValue();
                System.out.print( key);
                System.out.print(" - ");
                System.out.print( value+"\n");
            }

    }
}
