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
@Table(name = "T_SHOPPINGLIST")
@Getter
@Setter
@NoArgsConstructor
public class ShoppingList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int product_id;
  private int quantity;
  private boolean is_bougth;

  public ShoppingList(Long id, int product_id, int quantity, boolean is_bougth) {
    this.id = id;
    this.product_id = product_id;
    this.quantity = quantity;
    this.is_bougth = is_bougth;
  }
}
