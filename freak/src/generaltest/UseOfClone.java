package generaltest;


class Testclass implements Cloneable{
	Integer var;
	void set(int x){
		var=x;
	}
	int print(){
		return var;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}


public class UseOfClone {

	public static void main(String[] args) {
		
				
		Testclass obj =  new Testclass();
		
		obj.set(23);
		
		System.out.println(obj.print());
		
		Testclass obj1 = null;
		try {
			obj1 = (Testclass) obj.clone();
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		obj.set(25);
		
		System.out.println(obj.print()+"   "+obj1.print());
		
		System.out.println(obj.print() == obj1.print());
		
		try {
			trytochange(obj.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(obj.print());
		
		
	}

	private static void trytochange(Object object) {
		// TODO Auto-generated method stub
		Testclass obj=(Testclass)object;
		obj.set(26);
		
				
	}
	
}
