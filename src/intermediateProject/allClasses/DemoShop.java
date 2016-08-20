package src.intermediateProject.allClasses;

import src.intermediateProject.allExceptions.CartException;
import src.intermediateProject.allExceptions.ProductException;
import src.intermediateProject.allExceptions.ShopException;
import src.intermediateProject.allExceptions.UserException;

public class DemoShop {

	public static void main(String[] args) {
		Shop shop=new Shop();
		LoggedAccount acc=new LoggedAccount("gosho",shop,500.50f);
		LoggedAccount acc1=new LoggedAccount("pesho",shop,450.50f);
		try {
			Product product =new Product("Chesan" , "za qdene", 2.50f , acc, 100);
			shop.addItemToShop(Categories.ACCESOARES, product);
			acc1.addToCart(product, 20);
			acc1.getCart().printCart();
			System.out.println(product.toString());
			acc1.removeFromCart(product, 20);
			acc1.getCart().printCart();
			System.out.println(product.toString());			
			acc1.addToCart(product, 20);
			acc1.getCart().printCart();
			System.out.println(product.toString());
			acc1.pay();
			System.out.println(acc1.toString());
			System.out.println(acc.toString());
			shop.print();
		} catch (ProductException | ShopException | CartException | UserException e) {
			System.out.println("Smth went wrong!");
			e.printStackTrace();
		}			
	}

}
