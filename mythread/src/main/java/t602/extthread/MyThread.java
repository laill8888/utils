package t602.extthread;


import t602.test.MyObject;

public class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(MyObject.connectionFactory2.getConnection()
					.hashCode());
		}
	}
}
