package ba.utic.isssgrupe.controller;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ba.utic.isssgrupe.model.UserGroup;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends PagingAndSortingRepository<UserGroup, Long>  {

	List<UserGroup> findByName(@Param("name") String name);

	List<UserGroup> findByCreatorusername(@Param("creatorusername") String creatorusername);
	
}
