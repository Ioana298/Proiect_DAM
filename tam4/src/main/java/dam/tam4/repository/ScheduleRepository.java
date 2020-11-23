package dam.tam4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;

@Repository
public interface ScheduleRepository<S> extends JpaRepository<S, ID> {

}
