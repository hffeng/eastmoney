package com.feng.eastmoney;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {

		System.out.println("asdfa");
		try {
			String cont = "";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date d = new Date();
			while (d.getHours() < 24 && d.getHours() > 6) {

				Document doc = Jsoup.connect("http://www.jiayuan.com/113296714").get();
				Element ele = doc.select("div.my_info.yh.not_online").first();
				Element ele1 = doc.select("div.on_line.yh").first();
				if (ele != null) {
					cont = ele.text();
				} else if (ele1 != null) {
					cont = ele1.text();
				}

				if (cont.contains("在线") && cont.indexOf("不在线") <= 0) {
					System.out.println(df.format(new Date()));
					FileAccess.method2("I://info2.txt", df.format(new Date()) + "\r\n");
				}
				Thread.sleep(200000);
			}
		} catch (Exception e) {
			try{
			  Thread.sleep(300000);
			}catch(Exception ce){
				App.main(new String[] {});
			}
			e.printStackTrace();
			App.main(new String[] {});
		}
	}
}
