package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

import src.intermediateProject.allExceptions.CartException;
import src.intermediateProject.allExceptions.ProductException;

public class Cart {

	private Set<Product> products=new HashSet<Product>();
	private float moneyToPay;
	
	
	public Cart() {
		this.moneyToPay = 0;
	}

	public void addToCart(Product productFromShop, int quantity) throws ProductException, CartException {
		if (productFromShop!=null){
			if (!this.products.contains(productFromShop)){
				this.products.add(new Product(productFromShop.getName(),productFromShop.getPrice(),productFromShop.getSeller(),quantity));
				this.increaseMoneyToPay(productFromShop.getPrice()*quantity);
			}else{
				if (this.getProduct(productFromShop)!=null){
					this.getProduct(productFromShop).increaseQuantity(quantity);
					this.increaseMoneyToPay(productFromShop.getPrice()*quantity);
				}
			}
		}else{
			throw new CartException("Product you are trying to add is invalid!");
		}
	}

	public void removeFromCart(Product productFromCart,int quantity) throws CartException, ProductException {
		if (productFromCart!=null&&this.products.contains(productFromCart)&&productFromCart.getQuantity()>=quantity){
			if(productFromCart.getQuantity()==quantity){
				this.decreaseMoneyToPay(productFromCart.getPrice()*quantity);
				this.products.remove(productFromCart);
			}else{
				this.decreaseMoneyToPay(productFromCart.getPrice()*quantity);
				this.getProduct(productFromCart).decreaseQuantity(quantity);
			}
		}else{
			throw new CartException("Product you are trying to remove is invalid!");
		}
	}

	public void increaseMoneyToPay(float money) throws CartException{
		if (money>0){
			this.moneyToPay+=money;
		}else{
			throw new CartException("The amount of the payment money must be a positive a positive amount!");
		}
	}
	
	public void decreaseMoneyToPay(float money) throws CartException{
		if (money>0&&money<=this.moneyToPay){
			this.moneyToPay-=money;
		}else{
			throw new CartException("The payment money you whant to decrese with must be a positive amount!");
		}
	}

	
	public float getMoneyToPay() {
		return moneyToPay;
	}

	
	public Set<Product> getProducts() {
		return products;
	}

	public Product getProduct(Product product) throws CartException{
		if (this.products.contains(product)){
			for (Product obj : this.products){
				if (obj.equals(product)){
					return obj;
				}
			}
			return null;
		}else{
			throw new CartException("No such product found!");
		}
	}
	
	public void printCart(){
		System.out.println("Products in cart!");
		for (Product product : products){
			System.out.println(product.toString());
		}
		System.out.println("money " + moneyToPay);
		System.out.println("End!");
	}
}
