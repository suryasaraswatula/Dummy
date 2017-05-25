package poc.me.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import poc.me.model.Company;
import poc.me.service.CompanyServiceInter;

@RestController
public class CompanyController {

	CompanyServiceInter companyService;
	
	@Autowired
	public void setCompanyService(CompanyServiceInter companyService) {
		this.companyService = companyService;
	}

	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String testMethod(){
		if(companyService != null)
			return "Test Passed... Go ahead";
		else
			return "you fool try again";
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public @ResponseBody List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	@RequestMapping (value="/getCompany/{id}", method=RequestMethod.GET)
	public @ResponseBody Company getCmpanyById(@PathVariable int id){
		return companyService.getComapnyById(id);
	}
		
	@RequestMapping (value="/deleteCompany/{id}", method=RequestMethod.GET)
	public int deleteCmpanyById(@PathVariable int id){
		return companyService.deleteCompany(id);
	}
	
	@RequestMapping (value="/addCompany", method=RequestMethod.POST)
	public @ResponseBody void addCompany(@RequestBody Company company){
		companyService.addCompany(company);
		
	}
	
	@RequestMapping (value="/addShares/{companyId}/{addValue}",method=RequestMethod.GET)
	public Long addShares(@PathVariable int companyId,@PathVariable Long addValue){
		return companyService.addShares(companyId, addValue);
	}
	
	@RequestMapping (value="/decreaseShares/{companyId}/{decreaseValue}",method=RequestMethod.GET)
	public Long decreaseShares(@PathVariable int companyId,@PathVariable Long decreaseValue){
		return companyService.diminishShares(companyId, decreaseValue);
	}

	@RequestMapping (value="/increseSharePrice/{companyId}/{incValue}",method=RequestMethod.GET)
	public Long increseSharePrice(@PathVariable int companyId,@PathVariable Long incValue){
		return companyService.increseSharePrice(companyId, incValue);
	}

	@RequestMapping (value="/decreaseSharePrice/{companyId}/{decValue}",method=RequestMethod.GET)
	public Long decreaseSharePrice(@PathVariable int companyId,@PathVariable Long decValue){
		return companyService.decreaseSharePrice(companyId, decValue);
	}

}
