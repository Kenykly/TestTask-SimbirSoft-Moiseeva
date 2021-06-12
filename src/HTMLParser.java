
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.*;
import java.util.*;


public class HTMLParser {

    private HashMap<String, Integer> map = new HashMap<>();
    private String webAdress;

    private  HashMap getMap(){
        return  map;
    }


    private  String getWebAdress(){
        return  webAdress;
    }

    public void setWebAdress(String webAdress)  {
        this.webAdress = webAdress;

    }

    public HTMLParser(String webAdress) {
        this.webAdress = webAdress;
    }

    public HTMLParser() {
    }


    public HashMap<String, Integer> parse() throws IOException {

        Document doc = Jsoup.connect(webAdress).get();
        String text = doc.text();
        text = text.toLowerCase();

        //к примеру списка из задания были добавлены лит. кавычки, тире, цифры и такой символ - ©
        String regex = "(—)|(©)|(-)|(\")|(\\s)|(,)|(!)|(\\?)|(;)|([)|(])|(\\()(\\))|(\\.)|(')|(:)|(»)|(«)|(\\n)|" +
                "(\\r)|(\\t)|(0)|(1)|(2)|(3)|(4)|(5)|(6)|(7)|(8)|(9)";

        for(String word : text.split(regex)){

            if(map.containsKey(word))
            {
                Integer i=map.get(word);
                i++;
                map.put(word,i);
            }
            else{
                map.put(word,1);
            }
        }
        map.remove("");

        return map;
    }



}
