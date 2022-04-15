package com.springlec.base0602.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BContentCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BUpdateCommand;
import com.springlec.base0602.command.BWriteCommand;

@Controller
public class BController {
	
	private BCommand listCommand, writeCommand, contentCommand, updateCommand, deleteCommand = null;
	
	@Autowired
	public void auto(BCommand list, BCommand write, BCommand content, BCommand update, BCommand delete) {
		this.listCommand = list;
		this.writeCommand = write;
		this.contentCommand = content;
		this.updateCommand = update;
		this.deleteCommand = delete;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		//------
//		command = new BListCommand();
//		command.execute(model);
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String mvWriteView() {
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
//		command = new BWriteCommand();
//		command.execute(model);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request ,Model model) {
		
		model.addAttribute("request",request);
//		command = new BContentCommand();
//		command.execute(model);
		contentCommand.execute(model);
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
//		command = new BUpdateCommand();
//		command.execute(model);
		
		updateCommand.execute(model);
		return "redirect:list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
//		command = new BDeleteCommand();
//		command.execute(model);
		
		deleteCommand.execute(model);
		return "redirect:list";
		
	}

}
