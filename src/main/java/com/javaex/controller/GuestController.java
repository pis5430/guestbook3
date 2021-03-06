package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Controller   //import도 시켜줘야함 , 어너테이션? 주석의 개념
@RequestMapping(value="/guest")
public class GuestController {
	
	
	//필드
	
	//생성자
	
	//메소드g/s
	
	/**메소드 일반**메소드마다 기능 1개씩 --> 기능마다url 부여**/

	//addList
	@RequestMapping(value="/addList", method= {RequestMethod.GET ,RequestMethod.POST})
	public String addList(Model model){ //Model도 import
		System.out.println("addList");
		
		GuestDao guestDao = new GuestDao();
		List<GuestVo> guestList = guestDao.getGuestList();
		System.out.println(guestList.toString());
		
		//model
		model.addAttribute("gList",guestList);
		
		
		return "addList";
	}
	
	@RequestMapping(value="/add", method= {RequestMethod.GET ,RequestMethod.POST})	
	public String add (@ModelAttribute GuestVo guestVo) {
		
		System.out.println("add");
		System.out.println(guestVo);
		
		GuestDao guestDao = new GuestDao();
		guestDao.guestInsert(guestVo);
		
		return "redirect:/guest/addList";
		
	}
	
	@RequestMapping(value="/deform", method= {RequestMethod.GET ,RequestMethod.POST})	
	public String deform () {		
		
		System.out.println("삭제폼");			
		return "deleteForm";	
		
	}
	
	//시도해보기
	@RequestMapping(value="/deform2/{no}", method= {RequestMethod.GET ,RequestMethod.POST})	
	public String deform2 (@PathVariable("no") int no) {		
		
		System.out.println("삭제폼2");	
		System.out.println(no); //여기로는 넘어오는데 deleteForm에서 param.no값으로 안불러와짐
		return "deleteForm";	
		
	}
	
	@RequestMapping(value="/delete2", method= {RequestMethod.GET ,RequestMethod.POST})
	public String delete2(@RequestParam("password") String password,
						@RequestParam("no") int no) {
		System.out.println("삭제2");
		//System.out.println(guestVo);
		
		GuestVo guestVo = new GuestVo(no ,password);
		
		//delete불러오기위한 dao선언
		GuestDao guestDao = new GuestDao();
		int count = guestDao.guestDelete(guestVo); //count 0일때 비밀번호 틀림, 1일때 삭제성공
		System.out.println("count:"+count);
		
		if(count == 0) { //삭제실패
			 System.out.println("비밀번호가 틀립니다.");
			 //포워드를 유틸에 넣어서 포워드 메소드로 이용하기
			 return "deleteForm";			 
		}else {//삭제성공
			
			return "redirect:/guest/addList";
		} 
		
	}
	
	
	//삭제 다른방법
	@RequestMapping(value="/delete", method= {RequestMethod.GET ,RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		
		System.out.println("삭제");
		System.out.println(guestVo);
		
		//delete불러오기위한 dao선언
		GuestDao guestDao = new GuestDao();
		int count = guestDao.guestDelete(guestVo); //count 0일때 비밀번호 틀림, 1일때 삭제성공
		System.out.println("count:"+count);
		
		if(count == 0) { //삭제실패
			 System.out.println("비밀번호가 틀립니다.");
			 //포워드를 유틸에 넣어서 포워드 메소드로 이용하기
			 return "deleteForm";			 
		}else {//삭제성공
			
			return "redirect:/guest/addList";
		} 
		
	}
	
	
	
}
