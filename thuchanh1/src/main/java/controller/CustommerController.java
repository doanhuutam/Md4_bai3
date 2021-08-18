package controller;

import Service.CustomerService;
import Service.ICustomerService;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustommerController {
    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("cus", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("cus", new Customer());
        return "/create";
    }
    @PostMapping("/save")
    public ModelAndView save(Customer customer){
        ModelAndView modelAndView=new ModelAndView("/index");
        customer.setId((int)(Math.random()*10000));
        customerService.save(customer);
        List<Customer> customerList = customerService.findAll();
        modelAndView.addObject("cus", customerList);
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("cus",customerService.findByid(id));
        return "/edit";
    }
    @PostMapping("update")
    public String update(Customer customer){
        customerService.update(customer.getId(),customer);
        return "redirect:/customer";

    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id ,Model model){
        model.addAttribute("cus",customerService.findByid(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes){
        customerService.delete(customer.getId());
        redirectAttributes.addFlashAttribute("success","remove..");
        return "redirect:/customer";
    }
}
