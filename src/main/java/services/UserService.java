package services;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import models.entity.User;
import models.repository.UserRepository;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.exception.UserNotFoundException;

@Service
public class UserService {

  public final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(@NonNull User user){
    return userRepository.save(user);
  }

  public List<User> findAllUsers(){
    return userRepository.findAll();
  }

  public User findUserById(@NotEmpty Long id) throws UserNotFoundException {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  public User updateUser(@NotEmpty long userId, @NonNull User user) throws UserNotFoundException {
    User findUser = findUserById(userId);

    findUser.setEmail(user.getEmail());
    findUser.setName(user.getName());
    findUser.setPassword(user.getPassword());
    userRepository.save(findUser);

    return findUser;

  }

  public String deleteUser(Long userId) throws UserNotFoundException {
    User userToDelete = findUserById(userId);
    userRepository.delete(userToDelete);

    return "Usuário" + userToDelete.getEmail() + "Deletado";
  }


}
