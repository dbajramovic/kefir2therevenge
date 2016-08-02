package ba.utic.isssgrupe.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ba.utic.isssgrupe.model.UserGroup;
import ba.utic.isssgrupe.model.GroupUserLink;

@RepositoryRestResource(collectionResourceRel = "grupuser", path = "grupusers")
public interface GrupUserRepository extends PagingAndSortingRepository<GroupUserLink, String>  {

	List<GroupUserLink> findByUsername(@Param("username") String username);
	
}
