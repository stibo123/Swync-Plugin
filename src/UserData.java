
public class UserData {
	String email;
	String name;
	String street;
	String zip;
	String qrlink;
	boolean verified;
	boolean iscontact;
	long type_userdata;
	long itemproviderid_userdata;
	long detailtype_userdata;
	
	
	
	
	public UserData(String email, String name, String street, String zip, String qrlink, boolean verified,
			boolean iscontact, long type_userdata, long itemproviderid_userdata, long detailtype_userdata) {
		super();
		this.email = email;
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.qrlink = qrlink;
		this.verified = verified;
		this.iscontact = iscontact;
		this.type_userdata = type_userdata;
		this.itemproviderid_userdata = itemproviderid_userdata;
		this.detailtype_userdata = detailtype_userdata;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getQrlink() {
		return qrlink;
	}
	public void setQrlink(String qrlink) {
		this.qrlink = qrlink;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public boolean isIscontact() {
		return iscontact;
	}
	public void setIscontact(boolean iscontact) {
		this.iscontact = iscontact;
	}
	public long getType_userdata() {
		return type_userdata;
	}
	public void setType_userdata(long type_userdata) {
		this.type_userdata = type_userdata;
	}
	public long getItemproviderid_userdata() {
		return itemproviderid_userdata;
	}
	public void setItemproviderid_userdata(long itemproviderid_userdata) {
		this.itemproviderid_userdata = itemproviderid_userdata;
	}
	public long getDetailtype_userdata() {
		return detailtype_userdata;
	}
	public void setDetailtype_userdata(long detailtype_userdata) {
		this.detailtype_userdata = detailtype_userdata;
	}
	
}
