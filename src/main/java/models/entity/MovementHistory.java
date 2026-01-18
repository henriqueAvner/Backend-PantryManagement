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
  private int user_id;
  private int product_id;

  public MovementHistory(Long id, int quantity, int user_id, int product_id) {
    this.id = id;
    this.quantity = quantity;
    this.user_id = user_id;
    this.product_id = product_id;
  }
}
