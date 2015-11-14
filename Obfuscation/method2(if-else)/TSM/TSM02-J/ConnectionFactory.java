//TSM02-J. Do not use background threads during class initialization


import java.sql.*;

	public final class ConnectionFactory {
		  private static Connection dbConnection;
		  // Other fields ...
		 
		  static {
			  Thread dbInitializerThread = new Thread(new Runnable() {
				  @Override public void run() {
					  try {
						  dbConnection = DriverManager.getConnection("connection string");
					  } catch (SQLException e) {
						  dbConnection = null;
					  }
				  }
			  });
		 
		    // Other initialization, for example, start other threads
		 
			  dbInitializerThread.start();
			  try {
				  dbInitializerThread.join();
			  } catch (InterruptedException ie) {
				  throw new AssertionError(ie);
		    }
		  }
		private int flag=0;
		  public static Connection getConnection() {
			if(flag==0){
				if (dbConnection == null) {
			      		throw new IllegalStateException("Error initializing connection");
			    	}}
			else{
				if (dbConnection == null) {
			      		throw new IllegalStateException("Error initializing connection");
			    	}
			}
			return dbConnection;
		  }

		  public static void main(String[] args) {
		    // ...
		    Connection connection = getConnection();
		  }
		}

