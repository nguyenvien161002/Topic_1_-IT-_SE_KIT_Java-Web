package nvv.dev.programingcourse.services;

import nvv.dev.programingcourse.model.User;
import nvv.dev.programingcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll() {
        return (List<User>) repository.findAll();
    }
}

