package poc.me.dao;

import java.util.List;

import poc.me.model.Company;

public interface CompanyDAOInter {
	public int addCompany(Company company);
	public int deleteCompany(int companyId);
	public Long addShares(int companyId,Long addNumber);
	public Long diminishShares(int companyId,Long diminshNumber);
	public Long increseSharePrice(int companyId,Long increaseValue);
	public Long decreaseSharePrice(int companyId,Long decreaseValue);
	public List<Company> getAllCompanies();
	public Company getComapnyById(int companyId);
	public Long getComapnyValue(int companyId);
	public List<Company> getCompaniesByRank();
}
