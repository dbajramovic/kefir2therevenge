package ba.utic.isssgrupe;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EntityScan(basePackages = {
		  "ba.utic.isssgrupe.model"
		  })
@EnableJpaRepositories(basePackages = {
		  "ba.utic.isssgrupe.controller"
		  })
@RequestMapping("/resource")
public class ISSSGrupeResource {

}
