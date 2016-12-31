package org.arindam.reflection;

import java.lang.reflect.Method;
// This Class uses Reflection to call java method of the class AppTest.java at runtime .
public class ReflectApp{
 
	public static void main(String[] args) {
 
	//no paramater
	Class noparams[] = {};
 
	//String parameter
	Class[] paramString = new Class[1];	
	paramString[0] = String.class;
 
	//int parameter
	Class[] paramInt = new Class[1];	
	paramInt[0] = Integer.TYPE;
 
	try{
	        //load the AppTest at runtime
		Class cls = Class.forName("org.arindam.reflection.AppTest");
		Object obj = cls.newInstance();
 
		//call the print method
		Method method = cls.getDeclaredMethod("print", noparams);
		method.invoke(obj, null);
 
		//call the printString method, pass a String param 
		method = cls.getDeclaredMethod("printString", paramString);
		method.invoke(obj, new String("arindam"));
 
		//call the printInt method, pass a int param
		method = cls.getDeclaredMethod("printInt", paramInt);
		method.invoke(obj, 1230);
 
		//call the setCounter method, pass a int param
		method = cls.getDeclaredMethod("setCounter", paramInt);
		method.invoke(obj, 777);
 
		//call the printCounter method
		method = cls.getDeclaredMethod("printCounter", noparams);
		method.invoke(obj, null);
 
	}catch(Exception ex){
		ex.printStackTrace();
	}
   }
}
