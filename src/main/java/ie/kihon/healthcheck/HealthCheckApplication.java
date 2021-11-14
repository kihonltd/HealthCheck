package ie.kihon.healthcheck;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

import ie.kihon.healthcheck.config.ApplicationConfiguration;
import ie.kihon.healthcheck.config.ApplicationProperties;
import ie.kihon.healthcheck.model.Host;
import ie.kihon.healthcheck.model.HostResult;
import ie.kihon.healthcheck.repository.HostRepository;
import ie.kihon.healthcheck.repository.HostResultRepository;
import ie.kihon.healthcheck.service.HealthCheckService;

@EnableRetry
@SpringBootApplication
public class HealthCheckApplication implements CommandLineRunner {
	@Autowired
	private ApplicationConfiguration config;
	@Autowired
	private HealthCheckService healthCheckService;
	@Autowired
	private ApplicationProperties applicationProperties;
	@Autowired
	private HostRepository hostRepo;
	@Autowired
	private HostResultRepository resultRepo;
	
	private static Logger LOG = LoggerFactory.getLogger(HealthCheckApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LOG.debug("Retries: {}", config.getRetry());
		LOG.debug("Timeout: {}", config.getTimeout());
		for (Host server: applicationProperties.getServers()) {
			Host host = hostRepo.save(new Host(server.getHostname(), server.getPort()));
			try {
				healthCheckService.check(host);
			} catch (IOException e) {
				LOG.error("Unexpected IO error: {}", e.getMessage(), e);
			}
		}
	}
	
	public void printResults() {
		for (HostResult hr : resultRepo.findAll()) {
	        LOG.info("Host: {}:{}\tResult: {}", hr.getHost().getHostname(), hr.getHost().getPort(), hr.getResult());
	    }		
	}
}
