
/**
 * The UserWallet class tracks users within our system, and the amount
 * of money they have in their wallets.
 * 
 * @author Peter Ohmann
 */
public class UserWallet {

	/**
	 * Create a new user based on the provided information,
	 * and store them into the database.
	 * @param userId the requested user ID number.  Not necessarily unique.
	 *               Any number greater than 0 is a valid ID.  The ID 0 and
	 *               all negative numbers are invalid.
	 * @param password the user's password.  A null or empty-string password
	 *                 is missing and, hence, not allowed.  Any password
	 *                 containing spaces is invalid.  All other passwords
	 *                 are valid.
	 * @return 0 on successful add.
	 *         -1 if the userId is invalid, -2 if the password is missing, or
	 *         -3 if the password is invalid (contains spaces).
	 */
	public static int createUser(int userId, String password) {
		if (userId < 0)
			return -1;
		else if (password == null || password.isEmpty())
			return -2;
		else if (password.contains(" \t\n"))
			return -3;
		else {
			DBInteraction.addUser(userId, password, 0.0);
			return 0;
		}
	}

	/**
	 * Add the specified amount of money into the wallet for the
	 * userId specified.
	 * 
	 * @param userId the user's wallet to add to
	 * @param amount the amount of money to add
	 * @return true if the money was successfully added, false otherwise.
	 */
	public static boolean addMoney(int userId, double amount) {
		if (DBInteraction.contains(userId)) {
			double currentAmount = DBInteraction.getMoney(userId);
			if (amount < 0.0) {
				return false;
			}
			else {
				currentAmount += amount;
				DBInteraction.setMoney(userId, currentAmount);
				return true;
			}
		}
		else {
			return false;
		}
	}
}
