package t701;

/**
 * 线程的状态：
 * new:实例化时的状态
 * runnable：可运行的状态
 * TERMINATED:被销毁时的状态
 * TIMED_WAITING:线程执行了sleep方法，呈等待状态
 * BLOCKED：阻塞状态，线程在等待锁的状态
 * WAITING：线程执行object.wait()方法所处的状态
 * @author laili
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		A a=new A();
		System.out.println("main 方法的状态"+a.getState());

		Thread.sleep(1000);

		a.start();

		Thread.sleep(1000);

		System.out.println("main 方法的状态2"+a.getState());
	}

}
