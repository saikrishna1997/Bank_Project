package com.slk.DAO;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.slk.model.Customer;
import com.slk.util.*;
@RestController
public class CustomerDAOimpl implements CustomerDAO {

	Connection connection = null;

	public CustomerDAOimpl() {
		connection = DButil.getConnection();
		System.out.println("connection" + connection);
	}

	@Override
	public List<Customer> getallcustomers() throws Exception {

		List<Customer> cst = new ArrayList<Customer>();

		try {
			String statement = "select * from customer";
			//PreparedStatement stmt = connection.prepareStatement("select distinct customer.cust_id,name,dob,contact,address,aadhar_card,pan_card,branch_id,customer_Acc_no,balance,account_id from customer,customer_account where customer.cust_id=customer_account.cust_id;");
			PreparedStatement stmt = connection.prepareStatement(statement);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Customer cst1 = new Customer();
				cst1.setCust_id(rs.getString(1));
				cst1.setName(rs.getString(2));
				cst1.setDob(rs.getString(3));
				cst1.setContact(rs.getLong(4));
				cst1.setAddress(rs.getString(5));
				cst1.setAadhar_card(rs.getLong(8));
				cst1.setPan_card(rs.getString(9));
				//cst1.setBranch_id(rs.getString(8));
				//cst1.setCustomer_Acc_no(rs.getString(9));
				//cst1.setBalance(rs.getFloat(10));
				//cst1.setAccount_id(rs.getString(11));

				System.out.println(rs.getInt(1) + " " + rs.getString(2));

				cst.add(cst1);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return cst;
	}

}
