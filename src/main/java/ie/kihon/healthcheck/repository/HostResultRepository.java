package ie.kihon.healthcheck.repository;

import org.springframework.data.repository.CrudRepository;

import ie.kihon.healthcheck.model.HostResult;

public interface HostResultRepository extends CrudRepository<HostResult, Long> {

}
