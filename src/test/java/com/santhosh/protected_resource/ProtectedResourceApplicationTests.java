package com.santhosh.protected_resource;

import com.santhosh.protected_resource.Controller.MainController;
import com.santhosh.protected_resource.Model.Inventory;
import com.santhosh.protected_resource.Model.Order;
import com.santhosh.protected_resource.Repository.OrderRepository;
import com.santhosh.protected_resource.Repository.ProductsRespository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

class ProtectedResourceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MainController mainController;


	@Test
	public void get(){
		String result = mainController.check();
		Assert.assertEquals(result,"you have the authority");
	}
	@Test
	public void send(){
		String result = mainController.send();
		Assert.assertEquals(result," You have the write access to this resource");
	}
	ProductsRespository productsRespository = mock(ProductsRespository.class);

	@Test
	public void listall(){

		when(productsRespository.findAll()).thenReturn(Stream.of(new Inventory("Laptop","macbook",20,20000)).collect(Collectors.toList()));
		List<Inventory> inv = productsRespository.findAll();
		Assert.assertEquals(1,inv.size());
	}

	List<Inventory> list;
	@Test
	public void insert(){
		Inventory inv = new Inventory("mobile","lenovo",30,37979);
		when(productsRespository.save(inv)).thenReturn(inv);
		inv.setId("12");
		Assert.assertEquals(inv,inv);

	}

	@Test
	public void delete(){
		productsRespository.deleteById("12");
		verify(productsRespository,times(1)).deleteById("12");
	}
	@Test
	public void delete1(){
		productsRespository.deleteById("13");
		verify(productsRespository,times(2)).deleteById("13");
	}


	OrderRepository orderRepository = mock(OrderRepository.class);

	@Test
	public void order(){
		Date date = new Date();
		Order order = new Order("santhosh","lenovo",date);
		when(orderRepository.save(order)).thenReturn(order);
		Assert.assertEquals(order,order);
	}


}
