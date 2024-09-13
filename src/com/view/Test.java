package com.view;


	import java.util.List;
	import java.util.Scanner;

	import com.model.Product;
	import com.service.ProductService;
	import com.service.ProductServiceImpl;

	public class Test {
		public static void main(String[] args) {
			
			add();
			//getAll();
			//delete();
			//getAll();
			
			
		}
		
		//add product
		static void add() {
			
			
			ProductService ps=new ProductServiceImpl();
			char flag='y';
			Scanner sc=new Scanner(System.in);
			do {
			Product p=new Product();
			System.out.println("Enter id");
			p.setId(sc.nextInt());
			
			System.out.println("Enter name");
			p.setName(sc.next());
			
			System.out.println("Enter company");
			p.setCompany(sc.next());
			
			System.out.println("Enter price");
			p.setPrice(sc.nextInt());
			
			ps.addProduct(p);
			
			System.out.println("Do you want to add more[y/n]");
			flag=sc.next().charAt(0);
		}while(flag=='y');
		}
			//getAll
			
			static void getAll() {
				ProductService ps=new ProductServiceImpl();
				
				Product p=new Product();
				List<Product> plist= ps.getAllProducts();
				System.out.println(plist);
				
			}
			
			//delete
			
			static void delete() {
				ProductService ps=new ProductServiceImpl();
				
				ps.deleteProduct(3);
				
			}
		
			
		}





