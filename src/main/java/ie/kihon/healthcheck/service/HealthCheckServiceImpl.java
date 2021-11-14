package ie.kihon.healthcheck.service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

import ie.kihon.healthcheck.config.ApplicationConfiguration;
import ie.kihon.healthcheck.model.Host;
import ie.kihon.healthcheck.model.HostResult;
import ie.kihon.healthcheck.repository.HostResultRepository;

@Service
public class HealthCheckServiceImpl implements HealthCheckService {
	private static Logger LOG = LoggerFactory.getLogger(HealthCheckServiceImpl.class);

	@Autowired
	private ApplicationConfiguration config;
	@Autowired
	private HostResultRepository repo;

	@Override
	public void check(Host host) throws IOException {
		LOG.debug("Checking {}:{}", host.getHostname(), host.getPort());
		SocketAddress hostAddress = new InetSocketAddress(host.getHostname(), host.getPort());
		try (
			Socket socket = new Socket();
		) {
			socket.connect(hostAddress, config.getTimeout() * 1000);
		}
		repo.save(new HostResult("Success", host));
	}
	
	@Recover
	public void recover(IOException ex, Host host) {
		repo.save(new HostResult("Failure: "+ex.getMessage(), host));
	}
}
