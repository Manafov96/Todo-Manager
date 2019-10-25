
package com.springBootMVC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springBootMVC.models.Todos;
import com.springBootMVC.services.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService service; 
	
/*	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		model.put("name", "user");
		
		return "index";
	}	
*/	
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		List<Todos> listTodos = service.listAll();
		model.addAttribute("listTodos", listTodos);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewTodoPage(Model model) {
		Todos todo = new Todos();
		model.addAttribute("todo", todo);
		
		return "new_todo";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todos todo) {
		service.save(todo);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditTodoPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_todo");
		Todos todo = service.get(id);
		mav.addObject("todo", todo);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteTodo(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/index";		
	}
}
