package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/context-common.xml",
									"classpath:config/context-aspect.xml",
									"classpath:config/context-mybatis.xml",
									"classpath:config/context-transaction.xml"})

public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	//@Test
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		
		product.setProdName("키보드");
		product.setProdDetail("키보드");
		product.setManuDate("121212");
		product.setPrice(1909090);
		product.setFileName("이미지파일");
		
		productService.addProduct(product);
						
		System.out.println(product);
		
		//==> API 확인
		/*Assert.assertEquals("testUserId", product.getUserId());
		Assert.assertEquals("testUserName", product.getUserName());
		Assert.assertEquals("testPasswd", product.getPassword());
		Assert.assertEquals("111-2222-3333", product.getPhone());
		Assert.assertEquals("경기도", product.getAddr());
		Assert.assertEquals("test@test.com", product.getEmail());*/
	}
	//@Test
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
		
		product.setProdNo(10000);
		product = productService.getProduct(10000);
		
		System.out.println(product);
	}
	
	//@Test
	public void testUpdateProduct() throws Exception {
		
		Product product = productService.getProduct(10044);
		
		product.setPrice(60000);
		
		productService.updateProduct(product);
		
		System.out.println(product);
	}
	
	@Test
	public void testGetProductList() throws Exception {
		Search search = new Search();
		
		search.setCurrentPage(1);
		search.setPageSize(3);
		
		search.setSearchCondition("1");
	 	search.setSearchKeyword("키보드");
	 	
		Map<String, Object> map = productService.getProductList(search);
		List<Object> list = (List<Object>) map.get("list");
		
		System.out.println("list : " + list);
		
		Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
		
	 	System.out.println("=======================================");	
	}

}