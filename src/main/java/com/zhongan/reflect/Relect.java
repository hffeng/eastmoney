package com.zhongan.reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Relect {
	
	
	public static void main(String[] args) throws Exception{
	   FemaleInfo fi = new FemaleInfo();
	   MaleInfo mi = new MaleInfo();
	   
	   fi.setAge(23);
	   fi.setName("female");

	   mi.setAge(28);
	   mi.setName("male");
	   
	   String test="name";
	   printInfo(test,fi,mi);
	   
	}
   public static void printInfo(String cont,Object... objects) throws Exception{
	
	   Map<String,Map<Method,Object>> objMap = new HashMap<String,Map<Method,Object>>();
//	   Map<Method,Object> methodMap = new HashMap<Method,Object>();
	    for(Object obj:objects){
	    	Class<?> clz = obj.getClass();
	    	Map<Method,Object> methodMap = new HashMap<Method,Object>();
	        Method[] methods = clz.getDeclaredMethods();
	        for(Method me:methods){
	        	methodMap.put(me, obj);
	        }
	        
	        objMap.put(clz.getSimpleName(), methodMap);
	        
	    }
	    
	    
	    for(Entry<String,Map<Method,Object>> en:objMap.entrySet()){
	    	String className = en.getKey();
	    	Map<Method,Object> tempMap = en.getValue();
		    for(Entry<Method,Object> entry:tempMap.entrySet()){
		    	if(entry.getKey().getName().equals("get"+"Age") && className.equals("MaleInfo")){
		    		System.out.println(entry.getKey().invoke(entry.getValue()));
		    	}
		    	
		    }
	    }
	    
	    
	    
	}
	

}
