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

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("companySearch", companyRepository.findByName(search));
        model.addAttribute("employeeFNSearch", employeeRepository.findByFirstNameIgnoreCase(search));
        model.addAttribute("employeeLNSearch", employeeRepository.findByLastNameIgnoreCase(search));
        return "list";
    }

    @RequestMapping("detailc/{id}")
    public String showCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("company", companyRepository.findById(id).get());
        return "showcompany";
    }

    @RequestMapping("detaile/{id}")
    public String showEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "showemployee";
    }

    @RequestMapping("updatec/{id}")
    public String updateCompany(@PathVariable("id") long id, Model model) {
        model.addAttribute("company", companyRepository.findById(id).get());
        return "showcompany";
    }

    @RequestMapping("updatee/{id}")
    public String updateEmployee(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "showemployee";
    }

    @RequestMapping("deletec/{id}")
    public String deleteCompany(@PathVariable("id") long id, Model model) {
        companyRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("deletee/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/listcomp")
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "showcompanies";
    }

    @RequestMapping("/listemp")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "showemployees";
    }

    @RequestMapping("/showemps")
    public String showEmps() {
        return "showemployees";
    }

    @RequestMapping("/showcomps")
    public String showComps() {
        return "showcompanies";
    }

    @RequestMapping("/showemp")
    public String showEmp() {
        return "showemployee";
    }

    @RequestMapping("/showcomp")
    public String showComp() {
        return "showcompany";
    }

}
