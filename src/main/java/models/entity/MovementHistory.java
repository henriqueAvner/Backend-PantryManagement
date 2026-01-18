package models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_HISTORY")
@Getter
@Setter
@NoArgsConstructor
public class MovementHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int quantity;
  private int userId;
  private int productId;

  public MovementHistory(Long id, int quantity, int userId, int productId) {
    this.id = id;
    this.quantity = quantity;
    this.userId = userId;
    this.productId = productId;
  }
}
