package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField companyTxt;
	private JTextField priceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductForm() {
		setTitle("Product Form");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(72, 111, 81, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Product Detail");
		lblNewLabel.setBounds(189, 10, 144, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(204, 106, 191, 34);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Company");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(72, 166, 95, 25);
		contentPane.add(lblNewLabel_2);
		
		companyTxt = new JTextField();
		companyTxt.setBounds(204, 164, 191, 34);
		contentPane.add(companyTxt);
		companyTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(79, 238, 74, 25);
		contentPane.add(lblNewLabel_3);
		
		priceTxt = new JTextField();
		priceTxt.setBounds(208, 224, 187, 36);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get data from product form
				String name=nameTxt.getText();
				String company=companyTxt.getText();
				int price=Integer.parseInt(priceTxt.getText());
				
				//set value to product object
				Product p=new Product();
				
				p.setName(name);
				p.setCompany(company);
				p.setPrice(price);
				
				ProductService ps=new ProductServiceImpl();
				ps.addProduct(p);
				JOptionPane.showMessageDialog(null, "added success");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(253, 305, 89, 23);
		contentPane.add(btnNewButton);
	}
}
