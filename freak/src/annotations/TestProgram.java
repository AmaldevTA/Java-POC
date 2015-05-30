package annotations;


import java.lang.reflect.Method;

public class TestProgram {
	
	public static void main(String[] args) {
		
		try {
			
			A obj = new B();
			Class c = obj.getClass();
			Method m = c.getMethod("f3");
			
			if(m.isAnnotationPresent(SomeKindOfAnnotation.class))
			{
				SomeKindOfAnnotation x = m.getAnnotation(SomeKindOfAnnotation.class);
				System.out.println("level of  security is " +x.typeOfSecurityNeeded() );
			}
			else
			{
				System.out.println("no security ");
			}
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
