package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductListForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nameTxt;
	private JTextField companyTxt;
	private JTextField priceTxt;
	private int id=0;
	private JTextField searchTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductListForm frame = new ProductListForm();
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
	public ProductListForm() {
		setTitle("ProductList ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 897, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(506, 12, 184, 47);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(378, 64, 483, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Company", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "select any row");
					return;
					
				}
				
				int row=table.getSelectedRow();
				int id=(int) table.getModel().getValueAt(row, 0);
				
				ProductService ps=new ProductServiceImpl();
				
				ps.deleteProduct(id);
				JOptionPane.showMessageDialog(null, "deleted success");
				displayData();
				
			}
		});
		btnNewButton.setBounds(656, 360, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add new");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ProductForm().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(735, 30, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					
					e1.printStackTrace();
				}
			}
			
			
		});
		btnNewButton_2.setBounds(544, 360, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 101, 76, 37);
		contentPane.add(lblNewLabel_1);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(129, 107, 144, 31);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Company");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 171, 89, 31);
		contentPane.add(lblNewLabel_2);
		
		companyTxt = new JTextField();
		companyTxt.setBounds(129, 174, 144, 31);
		contentPane.add(companyTxt);
		companyTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 244, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		priceTxt = new JTextField();
		priceTxt.setBounds(129, 233, 144, 37);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p=new Product();
				
				p.setId(id);
				p.setName(nameTxt.getText());
				p.setCompany(companyTxt.getText());
				p.setPrice(Integer.parseInt(priceTxt.getText()));
				
				ProductService ps=new ProductServiceImpl();
				ps.updateProduct(p);
				JOptionPane.showMessageDialog(nameTxt, "update product");
				
				displayData();
				
				//clear update form
				nameTxt.setText("");
				companyTxt.setText("");
				priceTxt.setText("");
				
			}
		});
		btnNewButton_3.setBounds(158, 318, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Edit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "select any row");
					return;
				}
				int row =table.getSelectedRow();
				 id=(int) table.getModel().getValueAt(row, 0);
				
				nameTxt.setText(table.getModel().getValueAt(row, 1).toString());
				companyTxt.setText(table.getModel().getValueAt(row, 2).toString());
				priceTxt.setText(table.getModel().getValueAt(row, 3).toString());
				
				
				
				
						
			}
			
		});
		btnNewButton_4.setBounds(421, 360, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("Search");
		lblNewLabel_4.setBounds(342, 34, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		searchTxt = new JTextField();
		searchTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sdata=searchTxt.getText().trim();
				
				ProductService ps=new ProductServiceImpl();
				List<Product> plist=ps.searchProduct(sdata);
				DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
				tmodel.setRowCount(0);
				
				for(Product pd:plist) {
					tmodel.addRow(new Object[] {pd.getId(),pd.getName(),pd.getCompany(),pd.getPrice()});
				}
			}
		});
		searchTxt.setBounds(398, 31, 86, 20);
		contentPane.add(searchTxt);
		searchTxt.setColumns(10);
		displayData();
	}
	
	//display data in JTable from database
	private void displayData() {
	ProductService ps=new ProductServiceImpl();
	List<Product> plist=ps.getAllProducts();
	DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
	tmodel.setRowCount(0);
	
	for(Product pd:plist) {
		tmodel.addRow(new Object[] {pd.getId(),pd.getName(),pd.getCompany(),pd.getPrice()});
	}
		
	}
}
