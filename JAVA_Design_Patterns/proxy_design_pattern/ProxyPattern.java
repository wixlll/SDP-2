package proxy_design_pattern; // Package declaration

// Interface for database execution
interface DatabaseExecuter {
	public void executeDatabase(String query) throws Exception;
}

// Concrete class for executing database queries
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

// Proxy class for controlling database execution based on user permissions
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true; // Check if the user is an admin
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			dbExecuter.executeDatabase(query); // Execute any query if the user is an admin
		} else {
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user"); // Prevent non-admins from deleting
			} else {
				dbExecuter.executeDatabase(query); // Execute other queries for non-admin users
			}
		}
	}
}

public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Incorrect query, non-admin user

		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE"); // Attempt to delete, non-admin user (throws an exception)

		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE"); // Admin user executing a DELETE query
	}
}
