package ie.kihon.healthcheck.repository;

import org.springframework.data.repository.CrudRepository;

import ie.kihon.healthcheck.model.Host;

public interface HostRepository extends CrudRepository<Host, Long> {

}
