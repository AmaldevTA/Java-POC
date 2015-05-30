package generaltest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;

public class DynamicClassCreation {
	Date today = new Date();
	String todayMessage = "ok it works";
	String todayClass = "CrazyClassCreation";
	String todaySource = todayClass + ".java";

	public static void main(String args[]) {
		DynamicClassCreation mtc = new DynamicClassCreation();
		mtc.createIt();
		mtc.compileIt();
		System.out.println("Running " + mtc.todayClass + ":\n\n");
		mtc.runIt();

	}

	public void createIt() {
		try {
			FileWriter aWriter = new FileWriter(todaySource, true);
			aWriter.write("public class " + todayClass + "{");
			aWriter.write(" public void doit() {");
			aWriter.write(" System.out.println(\"" + todayMessage + "\");");
			aWriter.write(" }}\n");
			aWriter.flush();
			aWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void compileIt() {
		String[] source = { new String(todaySource) };
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		new sun.tools.javac.Main(baos, source[0]).compile(source);
		// if using JDK >= 1.3 then use
		// public static int com.sun.tools.javac.Main.compile(source);
		// return (baos.toString().indexOf("error")==-1);
	}

	public void runIt() {
		try {
			Class params[] = {};
			Object paramsObj[] = {};
			File file = new File(todaySource);

			URL url = file.toURI().toURL();
			String temp = url.toString().replace(todaySource, "").trim();
			URL newurl = new URL(temp);
			URL[] classUrls = { newurl };
			URLClassLoader ucl = new URLClassLoader(classUrls);
			Class thisClass = ucl.loadClass(todayClass);

			Object iClass = thisClass.newInstance();
			Method thisMethod = thisClass.getDeclaredMethod("doit", params);
			thisMethod.invoke(iClass, paramsObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}