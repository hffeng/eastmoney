package com.feng.eastmoney;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
  crawler the information from web
  @Author fenghf
  @Date 2021/1/27
  
*/
public class FileAccess {

	 private static Logger logger = LoggerFactory.getLogger(FileAccess.class);
	 public static void method1(String file, String conent) {
	 	    if(logger.isDebugEnabled()){
	 	    	logger.debug("begin to run the [{}]",FileAccess.class.toString());
			}
	        BufferedWriter out = null;     
	        try {     
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));     
	            out.write(conent);   
	            out.flush();
	            out.newLine();
	        } catch (Exception e) {     
	            e.printStackTrace();     
	        } finally {     
	            try {     
	                if(out != null){  
	                    out.close();     
	                }  
	            } catch (IOException e) {     
	                e.printStackTrace();     
	            }     
	        }     
	    } 
	 
	 public static void method2(String fileName, String content) {   
	        FileWriter writer = null;  
	        try {     
	            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件     
	            writer = new FileWriter(fileName, true);     
	            writer.write(content);     
	            writer.flush();
	            
	        } catch (IOException e) {     
	            e.printStackTrace();     
	        } finally {     
	            try {     
	                if(writer != null){  
	                    writer.close();     
	                }  
	            } catch (IOException e) {     
	                e.printStackTrace();     
	            }     
	        }   
	    }     

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date d = new Date();
    	System.out.println(df.format(d));
	}

}
