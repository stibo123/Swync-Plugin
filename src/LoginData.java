
public class LoginData {
	long userid;
	String authtoken;
	UserData userData;
	String itemid;
	long type;
    long itemproviderid;
    long detailtype;
	public LoginData(long userid, String authtoken, UserData userData, String itemid, long type, long itemproviderid,
			long detailtype) {
		super();
		this.userid = userid;
		this.authtoken = authtoken;
		this.userData = userData;
		this.itemid = itemid;
		this.type = type;
		this.itemproviderid = itemproviderid;
		this.detailtype = detailtype;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getAuthtoken() {
		return authtoken;
	}
	public void setAuthtoken(String authtoken) {
		this.authtoken = authtoken;
	}
	public UserData getUserData() {
		return userData;
	}
	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public long getItemproviderid() {
		return itemproviderid;
	}
	public void setItemproviderid(long itemproviderid) {
		this.itemproviderid = itemproviderid;
	}
	public long getDetailtype() {
		return detailtype;
	}
	public void setDetailtype(long detailtype) {
		this.detailtype = detailtype;
	}

	
}
