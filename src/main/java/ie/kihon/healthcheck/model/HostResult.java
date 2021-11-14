package ie.kihon.healthcheck.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class HostResult {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String result;
	@OneToOne
	private Host host;
	
	protected HostResult() {}
	
	public HostResult(String result, Host host) {
		super();
		this.result = result;
		this.host = host;
	}
	
	public Long getId() {
		return id;
	}
	public String getResult() {
		return result;
	}

	public Host getHost() {
		return host;
	}

	public void setHost(Host host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "HostResult [id=" + id + ", result=" + result + ", host=" + host + "]";
	}

	
}
