package dam.tam4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;

import dam.tam4.domain.Team;

@Repository
public interface TeamRepository<T> extends JpaRepository<T, ID> {

	void update(Team tm);

}
