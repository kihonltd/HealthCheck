package ie.kihon.healthcheck.service;

import java.io.IOException;

import org.springframework.retry.annotation.Retryable;

import ie.kihon.healthcheck.model.Host;

public interface HealthCheckService {
	@Retryable( value = {IOException.class}, maxAttemptsExpression = "${settings.retry}")
	public void check(Host host) throws IOException;
}
