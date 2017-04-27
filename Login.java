public class Login {
	
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
		// need to be replace by db access queries
        if (username.equals("bob") && password.equals("secret")) {
            return true;
        }
        return false;
    }
}
