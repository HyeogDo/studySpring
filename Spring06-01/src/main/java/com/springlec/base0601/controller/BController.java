package com.springlec.base0601.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0601.command.BCommand;
import com.springlec.base0601.command.BContentCommand;
import com.springlec.base0601.command.BDeleteCommand;
import com.springlec.base0601.command.BListCommand;
import com.springlec.base0601.command.BUpdateCommand;
import com.springlec.base0601.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		//------
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String mvWriteView() {
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request ,Model model) {
		
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		return "redirect:list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		return "redirect:list";
		
	}

}
