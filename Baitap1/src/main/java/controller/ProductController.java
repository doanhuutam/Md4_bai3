package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
public class ProductController {
    ProductService productService=new ProductService();
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView=new ModelAndView("/home");
        modelAndView.addObject("list",productService.list);
        return modelAndView;

    }
    @GetMapping("/create")
    public ModelAndView save(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("list",new Product());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView create(@ModelAttribute Product product){
        productService.save(product);
        return new ModelAndView("redirect:/home");

    }
    @GetMapping("/edit/{index}")
    public ModelAndView edit(@PathVariable int index){
        ModelAndView modelAndView=new ModelAndView("/edit");
        modelAndView.addObject("list",productService.list.get(index));
        return modelAndView;
    }
    @PostMapping("/edit/{index}")
    public ModelAndView editpost(@ModelAttribute Product product, @PathVariable int index){
        productService.edit(product,index);
        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/delete/{index}")
    public ModelAndView delete(@PathVariable int index){
        ModelAndView modelAndView=new ModelAndView("/delete");
        modelAndView.addObject("list",productService.list.get(index));
        return modelAndView;
    }
    @PostMapping("/delete/{index}")
    public ModelAndView deletepost(@PathVariable int index){
        productService.delete(index);
        return new ModelAndView("redirect:/home");
    }
}
