package com.slk.DAO;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.slk.model.*;
@RestController
public interface CustomerDAO {
	List<Customer> getallcustomers() throws Exception;

}
