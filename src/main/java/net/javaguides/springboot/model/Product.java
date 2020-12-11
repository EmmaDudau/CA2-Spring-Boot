package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_modified")
	private String productModified;

	@Column(name = "product_created")
	private String productCreated;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "productBarcode")
	private String productBarcode;


	public Product() {
		
	}

	public Product(String productName, int productQuantity, String productModified, String productCreated, double productPrice, String productBarcode) {
		super();
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productModified = productModified;
		this.productCreated = productCreated;
		this.productPrice = productPrice;
		this.productBarcode = productBarcode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductModified() {
		return productModified;
	}

	public void setProductModified(String productModified) {
		this.productModified = productModified;
	}

	public String getProductCreated() {
		return productCreated;
	}

	public void setProductCreated(String productCreated) {
		this.productCreated = productCreated;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(String barcode) {
		this.productBarcode = barcode;
	}

}
