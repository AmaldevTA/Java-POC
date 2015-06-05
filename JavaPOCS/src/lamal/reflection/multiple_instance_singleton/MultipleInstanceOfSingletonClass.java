package lamal.reflection.multiple_instance_singleton;



import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MultipleInstanceOfSingletonClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySingleton obj1 = MySingleton.getMySingleton();
		MySingleton obj2 = null;
		try {
			
			
			Constructor<MySingleton> constructor = MySingleton.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			obj2 = constructor.newInstance();
			System.out.println("Second object being created");
			
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (obj1 != obj2) {
			if (obj2 != null) {
				System.out.println("two objects are created");
			}
		}
	}

}

class MySingleton {
	private static MySingleton myInstance;

	private MySingleton() {
		if (myInstance != null) {
			//throw new UnsupportedOperationException();
		}
	}

	public synchronized static MySingleton getMySingleton() {
		if (myInstance == null) {
			myInstance = new MySingleton();
		}
		return myInstance;
	}
}
