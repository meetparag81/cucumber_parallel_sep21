package DataManupulation;

import java.util.HashMap;
import java.util.Map;

public class CopyReplaceSecurityDomain {
	String roleName;
	String nRoleName;
	String nRoleDesc;
	String nRoleSD;
	Map<Integer, Map<String, String>> perms = new HashMap<Integer, Map<String, String>>();
	public CopyReplaceSecurityDomain(String roleName, String nRoleName, String nRoleDesc, String nRoleSD,
			Map<Integer, Map<String, String>> perms) {
		super();
		this.roleName = roleName;
		this.nRoleName = nRoleName;
		this.nRoleDesc = nRoleDesc;
		this.nRoleSD = nRoleSD;
		this.perms = perms;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getnRoleName() {
		return nRoleName;
	}
	public String getnRoleDesc() {
		return nRoleDesc;
	}
	public String getnRoleSD() {
		return nRoleSD;
	}
	public Map<Integer, Map<String, String>> getPerms() {
		return perms;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setnRoleName(String nRoleName) {
		this.nRoleName = nRoleName;
	}
	public void setnRoleDesc(String nRoleDesc) {
		this.nRoleDesc = nRoleDesc;
	}
	public void setnRoleSD(String nRoleSD) {
		this.nRoleSD = nRoleSD;
	}
	public void setPerms(Map<Integer, Map<String, String>> perms) {
		this.perms = perms;
	}
}
