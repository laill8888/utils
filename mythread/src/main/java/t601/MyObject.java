package t601;

public class MyObject {
	/*
	 * 立即加载
	 * private static MyObject myObject=new MyObject();
	public MyObject() {
		// TODO Auto-generated constructor stub
	}

	public static MyObject getInstance(){
		return myObject;
	}*/
	private static MyObject myObject;

	public MyObject() {

	}
	/*//同步方法或者同步代码块的效率是非常低下的
	synchronized public static MyObject getInstance(){
		if(myObject==null){
			myObject=new MyObject();
		}
		return myObject;
	}*/

	/*//dcl 双重检验锁 大部分会采取这种方式解决单例模式线程安全问题
	public static MyObject getInstance(){
			if(myObject!=null){

			}
			else{
				synchronized (MyObject.class) {
					if(myObject==null){
						myObject=new MyObject();
					}
				}
			}

		return myObject;
	}*/


	//静态内部类
	private static class MyObjectHandler{
		private static MyObject myObject=new MyObject();
	}
	public static MyObject getInstance(){
		return MyObjectHandler.myObject;
	}

}