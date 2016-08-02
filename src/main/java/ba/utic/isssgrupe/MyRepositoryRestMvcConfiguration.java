package ba.utic.isssgrupe;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import ba.utic.isssgrupe.model.UserGroup;
import ba.utic.isssgrupe.model.GroupUserLink;

@Configuration
public class MyRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {
 
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setBasePath("/resource");
        config.exposeIdsFor(UserGroup.class);
        config.exposeIdsFor(GroupUserLink.class);
    }
}
