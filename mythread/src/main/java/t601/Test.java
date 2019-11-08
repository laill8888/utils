package t601;

/**
 * 单例模式与多线程
 *
 * 如何是单例模式在多线程的环境下是安全的正确的？？
 *
 *
 * @author laili
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a.start();

		A a2=new A();
		a2.start();
		A a3=new A();
		a3.start();
	}

}

