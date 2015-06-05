package lamal.reflection.accessing_private_member;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Dummy {

	private void foo() {
		System.out.println("hello from foo()");
	}

	public int test(int i, int j) {
		return i + j;
	}

	private int i = 10;
	private static int j = 25;
}

public class AccessingPrivateFunction {

	public static void main(String[] args) throws Exception {
		Dummy d = new Dummy();

		/*---  [INVOKING PRIVATE METHOD]  ---*/
		Method m = Dummy.class.getDeclaredMethod("foo");
		m.setAccessible(true);
		m.invoke(d);

		/*---  [SETTING VALUE OF PRIVATE FIELD]  ---*/
		Field f2 = Dummy.class.getDeclaredField("i");
		f2.setAccessible(true);
		f2.set(d, 20);

		/*---  [GETING VALUE FROM PRIVATE FIELD]  ---*/
		Field f = Dummy.class.getDeclaredField("i");
		f.setAccessible(true);
		System.out.println(f.get(d));

		/*---  [INVOKING METHOD WITH PARAMS AND RETURN STATEMENT]  ---*/
		Method testMethod = Dummy.class.getDeclaredMethod("test", int.class,
				int.class);
		int result = (Integer) testMethod.invoke(new Dummy(), 100, 200);
		System.out.println(result);

		for (Method method : Dummy.class.getDeclaredMethods()) {
			System.out.println(method.getName());
		}

		for (Field fields : Dummy.class.getDeclaredFields()) {
			System.out.println(fields.getName());
		}
	}

}
