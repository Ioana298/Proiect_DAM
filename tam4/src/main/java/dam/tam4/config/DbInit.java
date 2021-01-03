package dam.tam4.config;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dam.tam4.domain.Role;

@Component
@Transactional
public class DbInit {

	@PersistenceContext
	private EntityManager em;

	@EventListener(ApplicationReadyEvent.class)
	public void init(ApplicationEvent event) throws SQLException {
		for (EntityType<?> entity : em.getMetamodel().getEntities()) {
			if (countRows(entity.getName()) == 0)
				switch (entity.getName()) {
				case "Role":
					fillRoles();
					break;
				}
		}
	}

	private int countRows(String tableName) {
		return Integer.parseInt(em.createQuery("SELECT COUNT(*) FROM " + tableName).getResultList().get(0).toString());
	}

	private void fillRoles() {
		for (Role role : roles) {
			em.merge(role);
		}
	}

	@SuppressWarnings("serial")
	ArrayList<Role> roles = new ArrayList<Role>() {
		{
			add(new Role("ROLE_USER"));
			add(new Role("ROLE_MANAGER"));
			add(new Role("ROLE_HR"));
			add(new Role("ROLE_TEAMLIDER"));
			add(new Role("ROLE_CANDIDATE"));
		}
	};
}
