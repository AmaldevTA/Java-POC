package generaltest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Date;

public class DynamicClassCreation {
	  Date today = new Date();
	  String todayMillis = Long.toString(today.getTime());
	  String todayClass = "CrazyClassCreation";//"z_" + todayMillis;
	  String todaySource = todayClass + ".java";

	  public static void main (String args[]){
		  DynamicClassCreation mtc = new DynamicClassCreation();
	    mtc.createIt();
	    if (mtc.compileIt()) {
	       System.out.println("Running " + mtc.todayClass + ":\n\n");
	       mtc.runIt();
	       }
	    else
	       System.out.println(mtc.todaySource + " is bad.");
	    }

	  public void createIt() {
	    try {
	      FileWriter aWriter = new FileWriter(todaySource, true);
	      aWriter.write("public class "+ todayClass + "{");
	      aWriter.write(" public void doit() {");
	      aWriter.write(" System.out.println(\""+todayMillis+"\");");
	      aWriter.write(" }}\n");
	      aWriter.flush();      
	      aWriter.close();
	      }
	    catch(Exception e){
	      e.printStackTrace();
	      }
	    }

	  public boolean compileIt() {
	    String [] source = { new String(todaySource)};
	    ByteArrayOutputStream baos= new ByteArrayOutputStream();

	    new sun.tools.javac.Main(baos,source[0]).compile(source);
	    // if using JDK >= 1.3 then use
	    //   public static int com.sun.tools.javac.Main.compile(source);    
	    return (baos.toString().indexOf("error")==-1);
	    }

	  public void runIt() {
	    try {
	      Class params[] = {};
	      Object paramsObj[] = {};
/*	      String str = todaySource.replaceAll(".java", ".class");
	      File file = new File(str);
	      String path = file.getAbsolutePath();
	      path = path.replace(".class", "");
	      System.out.println(path+ "***"+ str);
	      ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
	      Class thisClass = myClassLoader.loadClass(path); */
	      
	      Class thisClass = Class.forName(todayClass);
	      Object iClass = thisClass.newInstance();
	      Method thisMethod = thisClass.getDeclaredMethod("doit", params);
	      thisMethod.invoke(iClass, paramsObj);
	      }
	    catch (Exception e) {
	      e.printStackTrace();
	      }
	    }
	}