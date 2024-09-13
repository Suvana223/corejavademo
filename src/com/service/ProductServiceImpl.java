package com.service;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.model.Product;

	public class ProductServiceImpl implements ProductService {
		
		//static List<Product> plist=new ArrayList<>();

		@Override
		public void addProduct(Product p) {
			//plist.add(p);
			//System.out.println("------added success-----size="+plist.size());
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testtb", "root", "12345");
			String sql="insert into product(name,company,price)values('"+p.getName()+"','"+p.getCompany()+"','"+p.getPrice()+"')";
			Statement stm=con.createStatement();
			stm.execute(sql);
			System.out.println("insert success");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
					
		}

		@Override
		public void deleteProduct(int id) {
			//plist.remove(index);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testtb", "root", "12345");
				String sql="delete from product where id="+id;
				Statement stm=con.createStatement();
				stm.execute(sql);
				System.out.println("deleted success");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		@Override
		public List<Product> getAllProducts() {
			List<Product> plist=new ArrayList<>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testtb", "root", "12345");
				String sql="select* from product";
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next()) {
					Product p=new Product();
					
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCompany(rs.getString("company"));
				p.setPrice(rs.getInt("price"));
				plist.add(p);
					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			
		
			return plist;
		}

		@Override
		public void updateProduct(Product p) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testtb", "root", "12345");
			String sql="update  product set name='"+p.getName()+"',company='"+p.getCompany()+"',price='"+p.getPrice()+"' where id="+p.getId();
			Statement stm=con.createStatement();
			stm.execute(sql);
			System.out.println("insert success");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			
			
		}

		@Override
		public List<Product> searchProduct(String sdata) {
			List<Product> plist=new ArrayList<>();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/testtb", "root", "12345");
				String sql="select* from product where name like '%"+sdata+"%' OR company like '%"+sdata+"%' ";
				Statement stm=con.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next()) {
					Product p=new Product();
					
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCompany(rs.getString("company"));
				p.setPrice(rs.getInt("price"));
				
				plist.add(p);
					
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			
			return plist;
		}

	}



