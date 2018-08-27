package libs;

import org.aeonbits.owner.Config;

public interface ConfigProperties extends Config {
	String base_url();
	String password();
	String login();
}