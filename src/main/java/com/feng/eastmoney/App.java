package com.feng.eastmoney;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main ( String[] args ) throws Exception
    {
        Document doc = Jsoup.connect("http://data.eastmoney.com/stock/traderstatistic.html").get();
        
        Elements elements = doc.select("dt_1");
        
        System.out.println(elements.size());
    }
    
    
}
