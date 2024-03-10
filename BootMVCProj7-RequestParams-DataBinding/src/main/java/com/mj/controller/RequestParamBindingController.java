package com.mj.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamBindingController {
	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind?sno=1001&sname=manoj

	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam("sno")Integer sno,@RequestParam("sname") String sname)
	{
		System.out.println("sno:"+sno+" "+"sname:"+sname);
		return "show_data"; 
	}*/

	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam Integer sno,@RequestParam String sname)
	{
		System.out.println("sno:"+sno+" "+"sname:"+sname);
		return "show_data"; 
	}*/

	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind?sno=1001
	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam Integer sno,@RequestParam(required = false) String sname)
	{
		System.out.println("sno:"+sno+" "+"sname:"+sname);
		return "show_data"; 
	}*/

	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind?sno=1001
	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind?sno=1002&sname=
	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam Integer sno,@RequestParam(defaultValue = "MJ Kumar") String sname)
	{
		System.out.println("sno:"+sno+" "+"sname:"+sname);
		return "show_data"; 
	}*/

	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind
	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam(defaultValue = "100") int sno,@RequestParam(defaultValue = "MJ Kumar") String sname)
	{
		System.out.println("sno:"+sno+" "+"sname:"+sname);
		return "show_data"; 
	}*/

	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind
	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam(required = false) Integer sno,@RequestParam(defaultValue = "MJ Kumar") String sname)
	{
		System.out.println("sno:"+sno+" "+"sname:"+sname);
		return "show_data"; 
	}*/
	
	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind?sname=mj&sname=kumar
	/*@GetMapping("/bind")
	public String bind(Map<String, Object> map,@RequestParam(required = false) Integer sno,
			@RequestParam("sname") String[] snameArr,
			@RequestParam("sname") List<String> snameList,
			@RequestParam("sname") Set<String> snameSet,
			@RequestParam("sname") String... snameVarg)
	{
		System.out.println("sno:"+sno+" "+"snames:"+Arrays.toString(snameArr)+" "+snameList+" "+snameSet+" "+Arrays.toString(snameVarg));
		return "show_data"; 
	}*/
	
	//http://localhost:4043/BootMVCProj7-RequestParams-DataBinding/bind?sname=mj&sname=kumar
		@GetMapping("/bind")
		public String bind(Map<String, Object> map,@RequestParam(required = false) Integer sno,
				@RequestParam String sname)
		{
			System.out.println("sno:"+sno+" "+"snames:"+sname);
			return "show_data"; 
		}
}
