package com.example.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//	Spring Context 얻기
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("config/applicationContext.xml");
		
		//	Bean 검색
		ProductService ps = ac.getBean(ProductService.class);	//	type 으로 검색
//		ProductService ps = ac.getBean("productService");		//	id로 검색
		
		//	서비스 실행
		ProductVo vo = ps.findProduct("NoteBook");
		System.out.println("Found : " + vo);
		
		//	예외 발생
		ProductVo vo2 = ps.findProduct(null);
		
	}
	
}
