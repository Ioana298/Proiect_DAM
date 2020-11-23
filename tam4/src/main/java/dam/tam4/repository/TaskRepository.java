package dam.tam4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sun.xml.bind.v2.model.core.ID;

import dam.tam4.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, ID> {

	void update(Task newTask);

}
