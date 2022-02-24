import java.util.HashSet;
import java.util.Set;

/**
 * The DBInteraction class contains various methods necessary
 * for interacting with the database.  You do not need to (AND
 * SHOULD NOT) change this class in any way, though you will
 * need to call some methods here in the setup() and tearDown()
 * methods of your Test Case!
 * 
 * @author Peter Ohmann
 */
public class DBInteraction {
	// the database!?
	private static Set<User> users = new HashSet<User>();

	/**
	 * Add the specified user into the database.
	 * 
	 * @param id the ID to add
	 * @param password the password to assign to this user
	 * @param startingBalance the initial wallet balance for the user
	 * @return true if successfully added, false otherwise
	 */
	public static boolean addUser(int id, String password, double startingBalance) {
		User newUser = new User(id, password, startingBalance);
		if (users.contains(newUser))
			return false;
		else {
			users.add(newUser);
			return true;
		}
	}
	
	/**
	 * Remove the specified user from the database.
	 * 
	 * @param id the ID of the user to remove
	 * @return true if the user was in the database (and is now removed),
	 *              and false otherwise
	 */
	public static boolean removeUser(int id) {
		User found = getById(id);
		if (found != null)
			return users.remove(found);
		else
			return false;
	}
	
	/**
	 * Check if the database contains the specified user ID.
	 * 
	 * @param id the ID to search for
	 * @return true if this ID is in the database, and false otherwise
	 */
	public static boolean contains(int id) {
		return getById(id) != null;
	}
	
	/**
	 * Get the amount of money in the wallet for the user id.
	 * 
	 * @param id the ID of the user's wallet
	 * @return the amount of money present, or 0.0 if the user is not
	 *         in the database
	 */
	public static double getMoney(int id) {
		User u = getById(id);
		if (u == null)
			return 0.0;
		else
			return u.getBalance();
	}
	
	/**
	 * Update the user's wallet balance for the user ID to the specified
	 * amount.
	 * 
	 * @param id the ID of the user to update
	 * @param amount the new amount of money in their wallet
	 * @return true if the update was successful (the user ID exists in the
	 *              database) or false otherwise
	 */
	public static boolean setMoney(int id, double amount) {
		User u = getById(id);
		if (u == null)
			return false;
		else {
			u.setBalance(amount);
			return true;
		}
	}
	
	/**
	 * Update the user's password.
	 * 
	 * @param id the ID of the user to update
	 * @param oldPassword the old password (must match!)
	 * @param newPassword the new password (no requirements)
	 * @return true if the password was updated successfully (the user ID and old
	 *              password match) or false otherwise
	 */
	public static boolean updatePassword(int id, String oldPassword, String newPassword) {
		User u = getById(id);
		if (u == null || u.getPassword() != oldPassword)
			return false;
		else {
			u.setPassword(newPassword);
			return true;
		}
	}
	
	/**
	 * Get the User associated with the specified ID.
	 * 
	 * @param id the ID to search for
	 * @return the User object if in the database, or null otherwise
	 */
	private static User getById(int id) {
		for (User u : users) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}

	// ----------------------------------------------------- //
	// ---- DO NOT LOOK BELOW THIS LINE!  IT WON'T HELP! --- //
	// ----------------------------------------------------- //

	private static class User {
		private int id;
		private String password;
		private double balance;

		public User(int id, String password, double balance) {
			super();
			this.id = id;
			this.password = password;
			this.balance = balance;
		}

		public int getId() {
			return id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}

		@Override
		public boolean equals(Object other) {
			return (other instanceof User && this.id == ((User)other).id);
		}
	}
}
