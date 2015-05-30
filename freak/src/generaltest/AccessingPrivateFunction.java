package generaltest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Dummy{
    private void foo(){
        System.out.println("hello foo()");
    }
    private int i=10;
    private static int j =25;
}

public class AccessingPrivateFunction {
	
	 public static void main(String[] args) throws Exception {
	        Dummy d=new Dummy();

	        /*---  [INVOKING PRIVATE METHOD]  ---*/
	        Method m=Dummy.class.getDeclaredMethod("foo");
	        //m.invoke(d);//exception java.lang.IllegalAccessException
	        m.setAccessible(true);//Abracadabra 
	        m.invoke(d);//now its ok

	        /*---  [GETING VALUE FROM PRIVATE FIELD]  ---*/
	        Field f=Dummy.class.getDeclaredField("i");
	        //System.out.println(f.get(d));//not accessible now
	        f.setAccessible(true);//Abracadabra 
	        System.out.println(f.get(d));//now its ok

	        /*---  [SETTING VALUE OF PRIVATE FIELD]  ---*/
	        Field f2=Dummy.class.getDeclaredField("i");
	        //f2.set(d,20);//not accessible now
	        f2.setAccessible(true);//Abracadabra 
	        f2.set(d,20);//now its ok
	        System.out.println(f2.get(d));
	        System.out.println(Dummy.class.getDeclaredFields()[0]+"\n"+Dummy.class.getDeclaredFields()[1]);
	        System.out.println(Dummy.class.getDeclaredFields()[0].toString().split("generaltest.Dummy.", 2)[1]);
	    }
	

}
