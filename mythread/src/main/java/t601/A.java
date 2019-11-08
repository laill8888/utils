package t601;

public class A extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(MyObject.getInstance().hashCode());
	}
}
