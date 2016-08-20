package src.intermediateProject.allClasses;

import java.io.*;
import java.util.*;

import src.intermediateProject.allExceptions.ProductException;
import src.intermediateProject.allExceptions.ShopException;
import src.intermediateProject.allExceptions.UserException;

public class Shop {

	private Map <Categories, HashSet<Product>> add=new HashMap<Categories, HashSet<Product>>();
	private Map <Categories, HashSet<Product>> unautorizedAdd=new HashMap<Categories, HashSet<Product>>();

	public void addUnaotorizedItem(Categories category,Product product) throws ShopException {
		if (category!=null && product!=null){
			if (this.unautorizedAdd.containsKey(category)){
				this.unautorizedAdd.get(category).add(product);
			}else{
				HashSet<Product> products=new HashSet<Product>();
				products.add(product);
				this.unautorizedAdd.put(category, products);
			}
		}else{
			throw new ShopException("Wrong input for a product entry!");
		}
	}

	public void removeUnautorizedItem(Product product) throws ShopException {
		boolean flag=false;
		if (product!=null){
			for (Categories category : unautorizedAdd.keySet()){
				if (unautorizedAdd.get(category).contains(product)){
					unautorizedAdd.get(category).remove(product);
					flag=true;
					break;
				}
			}
			if (!flag){
				System.out.println("Product not found!");
			}
		}else{
			throw new ShopException("Wrong inpur for removing product!");
		}
	}

	public void addItemToShop(Categories category ,Product product) throws ShopException{
		if (category!=null && product!=null){
			if (this.add.containsKey(category)){
				this.add.get(category).add(product);
			}else{
				HashSet<Product> products=new HashSet<Product>();
				products.add(product);
				this.add.put(category, products);
			}
		}else{
			throw new ShopException("Wrong input for a product entry!");
		}
	}
	
	public boolean hasProduct(Product product){
		for (Categories category : add.keySet()){
			if(add.get(category).contains(product)){
				return true;
			}
		}
		return false;
	}
	
	public void print(){
		for (Categories categorie :unautorizedAdd.keySet()){
			System.out.println("Key: " + categorie.toString());
			System.out.println("Value: " + unautorizedAdd.get(categorie).toString());
		}
		for (Categories categorie :add.keySet()){
			System.out.println("Key: " + categorie.toString());
			System.out.println("Value: " + add.get(categorie).toString());
		}
	}
}
