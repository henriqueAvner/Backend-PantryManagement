package controllers;

import controllers.DTOs.UserDTO;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;
import services.exception.UserNotFoundException;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  public ResponseEntity<List<UserDTO>> findAll(){

    List<UserDTO> listUsers = userService.findAllUsers()
        .stream()
        .map(UserDTO::fromEntity)
        .toList();

    return ResponseEntity.status(HttpStatus.OK).body(listUsers);

  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> findById(@PathVariable Long userId) throws UserNotFoundException {
    UserDTO currUser = UserDTO.fromEntity(userService.findUserById(userId));

    return ResponseEntity.status(HttpStatus.OK).body(currUser);
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody @NotNull User user)
      throws UserNotFoundException {

    UserDTO createUser = UserDTO.fromEntity(userService.createUser(user));
    return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody User user)
      throws UserNotFoundException {

    UserDTO updatedUser = UserDTO.fromEntity(userService.updateUser(userId, user));

    return ResponseEntity.status(HttpStatus.OK).body(updatedUser);

  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable Long userId) throws UserNotFoundException {
    UserDTO findUser = findById(userId).getBody();
    assert findUser != null;
    userService.deleteUser(findUser.id());
    return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário deletado com sucesso");
  }




}
