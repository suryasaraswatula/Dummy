package poc.me.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import poc.me.dao.CompanyDAOInter;
import poc.me.model.Company;

@Component ("companyService")
public class CompanyServiceImpl implements CompanyServiceInter {

	private CompanyDAOInter companyDAO;

	@Autowired
	public void setCompanyDAO(CompanyDAOInter companyDao) {
		this.companyDAO = companyDao;
	}

	public int addCompany(Company company) {
		return companyDAO.addCompany(company);		
	}

	public int deleteCompany(int companyId) {
		return companyDAO.deleteCompany(companyId);
	}

	public List<Company> getAllCompanies() {
		return companyDAO.getAllCompanies();
	}

	public Company getComapnyById(int companyId) {
		return companyDAO.getComapnyById(companyId);
	}

	public Long getComapnyValue(int companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Company> getCompaniesByRank() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long addShares(int companyId, Long addNumber) {
		return companyDAO.addShares(companyId, addNumber);
	}

	public Long diminishShares(int companyId, Long diminshNumber) {
		return companyDAO.diminishShares(companyId, diminshNumber);
	}

	public Long increseSharePrice(int companyId, Long increaseValue) {
		return companyDAO.increseSharePrice(companyId, increaseValue);
	}

	public Long decreaseSharePrice(int companyId, Long decreaseValue) {
		return companyDAO.decreaseSharePrice(companyId, decreaseValue);
	}
	
}
