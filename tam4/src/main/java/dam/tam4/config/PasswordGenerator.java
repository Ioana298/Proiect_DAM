package dam.tam4.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static String getEncoddedPass(String rawPass) {
		return new BCryptPasswordEncoder().encode(rawPass);
	}
}
