package controllers.DTOs;

import models.entity.User;
import org.jspecify.annotations.NonNull;

public record UserDTO(
    Long id,
    String name,
    String email
) {

  public static @NonNull UserDTO fromEntity(@NonNull User user) {
    return new UserDTO(
        user.getId(),
        user.getName(),
        user.getEmail()
    );
  }

  public @NonNull User toEntity() {
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    return user;
  }

}

