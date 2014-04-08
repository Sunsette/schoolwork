package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.Product;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.createproduct;
import views.html.products;
import views.html.updateproduct;

public class ProductController extends Controller{
	
	public static Result viewAllProducts(){
		
		List<Product> foundProducts = Ebean.find(Product.class).findList();
		
		return ok(Json.toJson(foundProducts));
	}
	
	public static Result createProduct(){
		
		Product form = Form.form(Product.class).bindFromRequest().get();
		
    	Product newProduct = new Product(form.name, form.description);
    	
    	Ebean.save(newProduct);
    	
		return ok(products.render(""));
	}
	
	public static Result createProductForm(){
		return ok(createproduct.render(""));
	}
	
	public static Result readProduct(int id){
		
		Product foundProduct = Ebean.find(Product.class, id);
		
		return ok(Json.toJson(foundProduct));
	}
	
	public static Result updateProduct(int id){
		
		Product foundProduct = Ebean.find(Product.class, id);


		Product form = Form.form(Product.class).bindFromRequest().get();


		foundProduct.name = form.name;

		foundProduct.description = form.description;


		Ebean.update(foundProduct);
		
		return ok(products.render(""));
	}
	
	public static Result updateProductForm(int id){
		
		Product foundProduct = Ebean.find(Product.class, id);
		
		return ok(updateproduct.render(foundProduct));
	}
	
	public static Result deleteProduct(int id){
		
		Product foundProduct = Ebean.find(Product.class, id);
		
		Ebean.delete(foundProduct);
		
		return ok();
	}

}
