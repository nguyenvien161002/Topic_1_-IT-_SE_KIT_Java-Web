package nvv.dev.programingcourse.services;

import nvv.dev.programingcourse.exception.UserNotFoundException;
import nvv.dev.programingcourse.model.User;
import nvv.dev.programingcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll() {
        return (List<User>) repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("Could not find any user with ID: " + id);
    }
    public void delete(Integer id) throws UserNotFoundException {
        Long count = repository.countById(id);
        if(count == null || count == 0) {
            throw new UserNotFoundException("Could not find any user with ID: " + id);
        }
        repository.deleteById(id);
    }
}

