package nvv.dev.programingcourse.repository;

import nvv.dev.programingcourse.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
