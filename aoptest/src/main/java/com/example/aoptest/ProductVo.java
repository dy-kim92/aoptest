package com.example.aoptest;

public class ProductVo {
	
	private String name;
	
	//	생성자
	public ProductVo(String name) {
		this.name = name;
	}

	//	Getter / Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//	toString
	@Override
	public String toString() {
		return "ProductVo [name=" + name + "]";
	}

}
