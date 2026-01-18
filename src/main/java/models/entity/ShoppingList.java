package models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
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

  @OneToOne(optional = false)
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "shoppingList")
  private List<Product> products;


  public ShoppingList(Long id, int productId, int quantity, boolean isBougth, User user) {
    this.id = id;
    this.productId = productId;
    this.quantity = quantity;
    this.isBougth = isBougth;
    this.user = user;
  }
}
