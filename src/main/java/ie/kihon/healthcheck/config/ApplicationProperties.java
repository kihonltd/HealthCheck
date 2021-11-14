package ie.kihon.healthcheck.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import ie.kihon.healthcheck.model.Host;

@Component
@ConfigurationProperties(prefix = "host-configuration")
public class ApplicationProperties {
	private List<Host> servers;

	public List<Host> getServers() {
		return servers;
	}

	public void setServers(List<Host> servers) {
		this.servers = servers;
	}

}
