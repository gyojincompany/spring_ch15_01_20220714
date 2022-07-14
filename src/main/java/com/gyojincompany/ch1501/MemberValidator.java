package com.gyojincompany.ch1501;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Member.class.isAssignableFrom(clazz);
		//검증할 객체의 클래스 타입정보
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Member member = (Member)target;
		
//		String id = member.getId();
//		
//		if(id == null || id.trim().isEmpty()) {
//			System.out.println("id is null!");
//			errors.rejectValue("id", "id is Null!");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id is null!");
		
		String pw = member.getPw();
		if(pw == null || pw.trim().isEmpty()) {
			System.out.println("password is null!");
			errors.rejectValue("pw", "Pw is Null!");
		} 
	}
	
	
}
