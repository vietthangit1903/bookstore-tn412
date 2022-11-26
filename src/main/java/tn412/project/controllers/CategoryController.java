package tn412.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tn412.project.models.Category;
import tn412.project.models.ResponseObject;
import tn412.project.repositories.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryRepository theloaisachRepository;
	@GetMapping("create")
	 public String themtheloai(Model model) {
       Category theloai = new Category();
        model.addAttribute("category",theloai);
        model.addAttribute("loi", new ResponseObject("",theloai));
        
        return "/category/them";
    }
	@PostMapping("create")
	public String themtheloais(Category theloai, Model model)
	{
		System.out.println(theloai.getName());
		Category tls = theloaisachRepository.findByName(theloai.getName());
		if (tls!=null)
		{
			model.addAttribute("category", tls);
			model.addAttribute("loi",new ResponseObject("Loi trung ten",tls));
			return "/category/them";
		}
		theloaisachRepository.save(theloai);
		return "redirect:/category/create";
	}
	@GetMapping("edit/{id}")
	public String suatls(Model model,@PathVariable Long id)
	{
		Category theloai = theloaisachRepository.findById(id).orElseThrow();
		if(theloai!=null)
		{
			model.addAttribute("category", theloai);
			model.addAttribute("loi", new ResponseObject("",theloai));
			return "/category/sua";
		}
		return "/category/danhsach";
	}
	@PostMapping("edit/{id}")
	public String suatlss(Category theloai,@PathVariable Long id,Model model)
	{
		Category tls = theloaisachRepository.findById(id).orElseThrow();
//		tls.setId(theloai.getId());
		tls.setName(theloai.getName());
		theloaisachRepository.save(tls);
		
		return "redirect:/category/danhsach";
	}
	@GetMapping("delete/{id}")
	public String xoatls(@PathVariable Long id)
	{
		Category tls = theloaisachRepository.findById(id).orElseThrow();
		theloaisachRepository.delete(tls);
		
		return "redirect:/category/danhsach";
		
	}
	@GetMapping("danhsach")
	public String danhsach(Model model)
	{
		model.addAttribute("listloaisach", theloaisachRepository.findAll());
		return "/category/danhsach";
	}
	
	

}
