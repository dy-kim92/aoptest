package com.example.aoptest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect		//	횡단 관심 객체
@Component
public class MyAspect {
	
	//	관점 지향 프로그래밍
	//	횡단 관심 수행을 위해 원래 코드에 어떠한 명시적인 코드도 작성하지 않음 : 중요 !
	//	로그, 보안 모듈 -> 횡단 모듈로 분리, Aspect를 이용하여 필요한 시점, 위치에 횡단 관심 모듈 삽입

	//	명시된 메소드 실행 이전에
	@Before("execution(public ProductVo com.example.aoptest.ProductService.findProduct(..))")
	public void before() {
		System.out.println("call [before advice]");
	}
	
	//	조건을 만족하는 메소드 실행 이후
	//	첫번째 * : 접근제한자를 가리지 않음
	//	두번째 * : 모든 클래스
	@After("execution(* com.example.aoptest.*.findProduct(String))")
	public void after() {
		System.out.println("call [after advice]");
	}
	
	//	메소드 수행 이후에 해당 메소드의 결과 객체 확인할 때 (예외 없이 정상적으로 수행 종료 시)
	//	메소드 수행 결과 객체 -> returning 에 명시한 이름으로 할당
	//	* *.. : 패키지는 가리지 않음
	//	(..) : 매개변수를 가리지 않음
	@AfterReturning(value="execution(* *..ProductService.findProduct(..))", returning="vo")
	public void afterReturning(ProductVo vo) {
		System.out.println("call [afterReturning advice]");
		System.out.println("메소드의 결과 객체 : " + vo);
	}
	
	//	메소드 수행 시 예외가 발생했을 때 예외 객체 확인
	//	메소드 수행 시 발생한 예외 -> throwing에 명시한 이름을 할당
	@AfterThrowing(value="execution(* findProduct(String))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.err.println("call [afterThrowing advice]");
		System.err.println("발생한 예외 정보 : " + ex.getMessage());
	}
	
}
