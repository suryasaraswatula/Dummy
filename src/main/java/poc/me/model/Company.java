package poc.me.model;

public class Company {
	private int companyId;
	private String companyName;
	private String companyLocation;
	private Long shareNumber;
	private Long shareUnitPrice;
	
	public Company(int companyId, String companyName, String companyLocation, Long shareNumber, Long shareUnitPrice) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyLocation = companyLocation;
		this.shareNumber = shareNumber;
		this.shareUnitPrice = shareUnitPrice;
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyLocation() {
		return companyLocation;
	}
	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}
	public Long getShareNumber() {
		return shareNumber;
	}
	public void setShareNumber(Long shareNumber) {
		this.shareNumber = shareNumber;
	}
	public Long getShareUnitPrice() {
		return shareUnitPrice;
	}
	public void setShareUnitPrice(Long shareUnitPrice) {
		this.shareUnitPrice = shareUnitPrice;
	}
}
