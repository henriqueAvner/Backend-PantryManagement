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
@Table(name = "T_PRODUCTS")
@NoArgsConstructor
@Getter
@Setter
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productId;
  private String name;
  private String brand;

  private int categoryId;

  public Product(int productId, String name, String brand, int categoryId) {
    this.productId = productId;
    this.name = name;
    this.brand = brand;
    this.categoryId = categoryId;
  }
}
