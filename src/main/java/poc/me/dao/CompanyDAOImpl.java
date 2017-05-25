package poc.me.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;


import poc.me.model.Company;

@Component ("companyDao")
public class CompanyDAOImpl extends Object implements CompanyDAOInter {
	
	NamedParameterJdbcTemplate template;
	Map<String, Object> params = new HashMap<String, Object>();
	String add_query="insert into company values(:id,:name,:location,:shareCount,:shareValue)";
	String delete_query="delete from company where companyId=:companyId";
	String get_all_query="select * from company";
	String get_company_by_id_query="select * from company where companyId=:companyId";
	String update_shares_query="update company set companyShares=:companyShares where companyId=:companyId";
	String update_share_price_query="update company set companySharePrice=:companySharePrice where companyId=:companyId";
	String get_shares_by_id_query="select companyShares from company where companyId=:companyId";
	String get_share_price_by_id_query="select companySharePrice from company where companyId=:companyId";
	String get_company_value_qry="select companyShares*companysharePrice from company where companyId=:companyId";
//	String get_company_ranks_qry="select companyName from company companyId=:companyId";
//	with companyRank as(select rank )
	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	public int addCompany(Company company) {
		// TODO Auto-generated method stub
		params.put("id", company.getCompanyId());
		params.put("name", company.getCompanyName());
		params.put("location", company.getCompanyLocation());
		params.put("shareCount", company.getShareNumber());
		params.put("shareValue", company.getShareUnitPrice());
		System.out.println("saving");
		int result=template.update(add_query, params);
		System.out.println("saved"+result);
		return result;
	}

	public int deleteCompany(int companyId) {
		params.put("companyId", companyId);
		int result=template.update(delete_query, params);
		return result;
	}

	public Long addShares(int companyId,Long addNumber) {
		params.put("companyId", companyId);
		Long shares=template.queryForLong(get_shares_by_id_query, params);
		params.put("companyShares", shares+addNumber);
		int updateFlag=template.update(update_shares_query, params);
		if(updateFlag == 1)
			return shares+addNumber;
		else
			return new Long(updateFlag);
	}

	public Long diminishShares(int companyId,Long diminshNumber) {
		params.put("companyId", companyId);
		Long shares=template.queryForLong(get_shares_by_id_query, params);
		if(shares>=diminshNumber){
			params.put("companyShares", shares-diminshNumber);
			int updateFlag=template.update(update_shares_query, params);
			if(updateFlag == 1)
				return shares-diminshNumber;
			else
				return new Long(updateFlag);
		}
		return null;
	}

	public Long increseSharePrice(int companyId,Long increaseValue) {
		params.put("companyId", companyId);
		Long sharePrice=template.queryForLong(get_share_price_by_id_query, params);
		params.put("companySharePrice", sharePrice+increaseValue);
		int updateFlag=template.update(update_share_price_query, params);
		if(updateFlag == 1)
			return sharePrice+increaseValue;
		else
			return new Long(updateFlag);
		
	}

	public Long decreaseSharePrice(int companyId,Long decreaseValue) {
		params.put("companyId", companyId);
		Long sharePrice=template.queryForLong(get_share_price_by_id_query, params);
		if(sharePrice>=decreaseValue){
			params.put("companySharePrice", sharePrice-decreaseValue);
			int updateFlag=template.update(update_share_price_query, params);
			if(updateFlag == 1)
				return sharePrice-decreaseValue;
			else
				return new Long(updateFlag);
		}
		return null;
	}

	public List<Company> getAllCompanies() {
		List<Company> result=(List<Company>) template.queryForObject(get_all_query, params, new CompanyListMapper());
		return result;
	}

	public Company getComapnyById(int companyId) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyId", companyId);
        
		String sql = "SELECT * FROM company WHERE companyId=:companyId";
		
        Company result = template.queryForObject(
                    sql,
                    params,
                    new CompanyMapper());
                    
        //new BeanPropertyRowMapper(Customer.class));
    
		return result;
	}

	public Long getComapnyValue(int companyId) {
		
		return null;
	}

	public List<Company> getCompaniesByRank() {
		// TODO Auto-generated method stub
		return null;
	}

}

class CompanyMapper implements RowMapper<Company>{
	
	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Company company=new Company();
		company.setCompanyName(rs.getString("companyName"));
		company.setCompanyLocation(rs.getString("companyLocation"));
		company.setCompanyId(rs.getInt("companyId"));
		company.setShareNumber(new Long(rs.getInt("companyShares")));
		company.setShareUnitPrice(new Long(rs.getInt("companySharePrice")));
		return company;
	}
}

class CompanyListMapper implements RowMapper<List<Company>>{
	
	public List<Company> mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		List<Company> companiesList=null;
		if(rs != null){
			companiesList=new ArrayList<Company>();
			do{
				Company company=new Company();
				company.setCompanyName(rs.getString("companyName"));
				company.setCompanyLocation(rs.getString("companyLocation"));
				company.setCompanyId(rs.getInt("companyId"));
				company.setShareNumber(new Long(rs.getInt("companyShares")));
				company.setShareUnitPrice(rs.getLong("companySharePrice"));
				companiesList.add(company);
			} while(rs.next());
		}
		return companiesList;
	}
}
