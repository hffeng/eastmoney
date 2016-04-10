package com.feng.eastmoney;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
       
        
        Elements trList = doc.getElementsByClass("tbody");
        
        Elements tbody = doc.select("table").select("tbody").select("tr");
        
        for(Element e:tbody){
        	Elements el = e.select("td");
        	
        	for(Element t:el){
        		System.out.println(t.select("td").text());
        	}
        }
    }
    
    
}
