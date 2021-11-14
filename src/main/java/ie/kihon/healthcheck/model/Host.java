package ie.kihon.healthcheck.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Host {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String hostname;
	private int port;

	protected Host() {}
	
	public Host(String hostname, int port) {
		this.hostname = hostname;
		this.port = port;
	}
	
	public Long getId() {
		return id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Host [hostname=" + hostname + ", port=" + port + "]";
	}

	
}
