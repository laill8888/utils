package t701;

public class A extends Thread {
	public A() {
		System.out.println("构造方法的状态"+Thread.currentThread().getState());
	}

	@Override
	public void run() {
		super.run();

		System.out.println("run 方法中的状态"+Thread.currentThread().getState());

		try {
			Thread.sleep(2000);
			System.out.println("run 方法中的状态"+Thread.currentThread().getState());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

