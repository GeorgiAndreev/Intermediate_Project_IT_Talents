package intermediateProject.allClasses;

import java.io.*;
import java.util.*;

import intermediateProject.allExceptions.ProductException;
import sun.security.util.PendingException;

public class Product {

	private static final int MAX_QUANTITY_OF_THE_SAME_PRODUCT = 1000;

	private String name;
	private String description;
	private float price;
	private LoggedAccount seller;
	private int quantity;

	
	public Product(String name, String description, float price, LoggedAccount seller, int quantity) throws ProductException {
		if (name!=null&&name.length()>1){
			this.name = name;
		}else{
			throw new ProductException("Wrong input for product name!");
		}
		if (description!=null&&description.length()>1){
			this.description = description;
		}else{
			throw new ProductException("Wrong input for product description!");
		}
		if (price>0){
			this.price = price;
		}else{
			throw new ProductException("Wrong input for product price!");
		}
		if (seller!=null){
			this.seller = seller;
		}else{
			throw new ProductException("Wrong input for seller!");
		}
		if (quantity>0){
			this.quantity = quantity;
		}else{
			throw new PendingException("Wrong input fir product quantity!");
		}
	}

	public void decreaseQuantity(int quantity) throws ProductException {
		if (quantity<this.quantity&&quantity>0){
			this.quantity-=quantity;
		}else{
			throw new ProductException("The quantity of the products you want to purchase must be less then does in the shop!");
		}
	}

	public void increaseQuantity(int quantity) throws ProductException {
		if (quantity<MAX_QUANTITY_OF_THE_SAME_PRODUCT&&quantity>0){
			this.quantity+=quantity;
		}else{
			throw new ProductException("The quantity of the products you want to purchase must be less then does in the shop!");
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + quantity;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	
}
