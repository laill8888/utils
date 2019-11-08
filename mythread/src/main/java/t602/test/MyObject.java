package t602.test;

public enum MyObject {
	connectionFactory2;

	//private Connection connection;

	private MyObject() {
		try {
			System.out.println("调用了MyObject的构造");
//			String url = "jdbc:postgresql://58.213.165.248:5432/prjmng";
//			String username = "postgres";
//			String password = "";
//			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//			Class.forName(driverName);
//			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getConnection() {
		return "err";
	}
}