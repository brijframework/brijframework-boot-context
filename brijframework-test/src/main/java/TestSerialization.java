import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("abc.ser");
		try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
			B obj = new B();
		    oos.writeObject(obj);
		}
		FileInputStream fis = new FileInputStream("abc.ser");
		try(ObjectInputStream ois = new ObjectInputStream(fis)){
			B obj1 = (B) ois.readObject();
			System.out.println("value of i is : " + obj1.i + " & value of j is : " + obj1.j);
		}
		
	}
}

class A implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i = 10;
}

class B extends A {
	int j = 20;
	

	// implementing writeObject method, 
	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("colling....");
		//throw new NotSerializableException();
	}

	// implementing readObject method,   
	private void readObject(ObjectInputStream in) throws IOException { 
		System.out.println("colling....");
	   // throw new NotSerializableException(); 
	}
}
