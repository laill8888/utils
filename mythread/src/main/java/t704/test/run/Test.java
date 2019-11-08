package t704.test.run;

import t704.extthread.MyThread;

import java.text.SimpleDateFormat;



/**
 * 线程的状态：
 * new:实例化时的状态
 * runnable：可运行的状态
 * TERMINATED:被销毁时的状态
 * TIMED_WAITING:线程执行了sleep方法，呈等待状态
 * BLOCKED：阻塞状态，线程在等待锁的状态
 * WAITING：线程执行object.wait()方法所处的状态
 *
 *
 * 线程组：
 * 线程对象关联线程组对象：1级关联，父对象中有子对象，但没有子孙对象
 * 线程组自动归属特性：自动归到当前线程组中
 * jvm线程组就是system
 *
 * SimpleDateFormat:线程不安全
 *
 *
 *
 *
 * @author laili
 *
 */

public class Test {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String[] dateStringArray = new String[] { "2000-01-01", "2000-01-02",
				"2000-01-03", "2000-01-04", "2000-01-05", "2000-01-06",
				"2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10" };

		MyThread[] threadArray = new MyThread[10];
		for (int i = 0; i < 10; i++) {
			threadArray[i] = new MyThread(sdf, dateStringArray[i]);
		}
		for (int i = 0; i < 10; i++) {
			threadArray[i].start();
		}

	}
}
