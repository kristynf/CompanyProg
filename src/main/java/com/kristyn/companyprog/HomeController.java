package com.kristyn.companyprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("companies", companyRepository.findAll());
        return "index";
    }

    @GetMapping("/addcompany")
    public String newCompany(Model model) {

        model.addAttribute("company", new Company());

        return "companyform";
    }

    @PostMapping("/processcompany")
    public String processCompany(@ModelAttribute Company company) {
        companyRepository.save(company);
        return "redirect:/";
    }

    @GetMapping("/addemployee")
    public String newEmployee(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

    @PostMapping("/processemployee")
    public String processEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }
}
//    @RequestMapping("/detail/{id}")
//    public String showCompany(@PathVariable("id") long id, Model model){
//        model.addAttribute("company", companyRepository.findById(id).get());
//        return "list";
//    }

