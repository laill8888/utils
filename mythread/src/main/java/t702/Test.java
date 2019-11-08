package t702;

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

	public static void main(String[] args) throws InterruptedException {
//		ThreadA aRunnable = new ThreadA();
//		ThreadB bRunnable = new ThreadB();
//
//		ThreadGroup group = new ThreadGroup("�ߺ��ҵ��߳���");
//		
//		ThreadGroup group2 = new ThreadGroup("laill���߳���");
//		
//
//		Thread aThread = new Thread(group, aRunnable);
//		Thread bThread = new Thread(group2, bRunnable);
//		aThread.start();
//		bThread.start();
//
//		System.out.println("a����߳���Ϊ��" + group.activeCount());
//		System.out.println("a�߳��������Ϊ��" + group.getName());
//		
//		System.out.println("b����߳���Ϊ��" + group2.activeCount());
//		System.out.println("b�߳��������Ϊ��" + group2.getName());
		
//		System.out.println("A���̣߳�"+Thread.currentThread().getName()+" �����߳���������"+Thread.currentThread().getThreadGroup().activeGroupCount());
//		ThreadGroup group=new ThreadGroup("�µ���");
//		System.out.println("A���̣߳�"+Thread.currentThread().getName()+" �����߳���������"+Thread.currentThread().getThreadGroup().activeGroupCount());
//		ThreadGroup[] threadGroup=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
//		
//		//���߳����е����߳���ͨ�����Ƶ���ʽ������ThreadGroup[]��
//		Thread.currentThread().getThreadGroup().enumerate(threadGroup);
//		for (int i = 0; i < threadGroup.length; i++) {
//			System.out.println("��һ���߳�������Ϊ��"+threadGroup[i].getName());
//		}
		
		
		
		
		
	}

}
