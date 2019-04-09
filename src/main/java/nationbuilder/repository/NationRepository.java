package nationbuilder.repository;

import org.springframework.data.repository.CrudRepository;

import nationbuilder.nation.Nation;

public interface NationRepository extends CrudRepository<Nation, Integer> {

}
