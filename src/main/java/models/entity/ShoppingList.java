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
  private int productId;
  private int quantity;
  private boolean isBougth;

  public ShoppingList(Long id, int productId, int quantity, boolean isBougth) {
    this.id = id;
    this.productId = productId;
    this.quantity = quantity;
    this.isBougth = isBougth;
  }
}
