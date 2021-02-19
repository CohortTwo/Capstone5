package springauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class department {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 4, nullable = false)
	private Integer deptid;
	
	@Column(length = 30, nullable = false, unique=true)
	private String deptname;
	@Column(length = 6, nullable = false)
	private Integer mgrid;
	@Column(length = 4, nullable = false)
	private Integer locid;
	
	public department(Integer deptid, String deptname, Integer mgrid, Integer locid) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.mgrid = mgrid;
		this.locid = locid;
	}
	
	public department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public Integer getMgrid() {
		return mgrid;
	}

	public void setMgrid(Integer mgrid) {
		this.mgrid = mgrid;
	}

	public Integer getLocid() {
		return locid;
	}

	public void setLocid(Integer locid) {
		this.locid = locid;
	}

	@Override
	public String toString() {
		return "department [deptid=" + deptid + ", deptname=" + deptname + ", mgrid=" + mgrid + ", locid=" + locid
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptid == null) ? 0 : deptid.hashCode());
		result = prime * result + ((deptname == null) ? 0 : deptname.hashCode());
		result = prime * result + ((locid == null) ? 0 : locid.hashCode());
		result = prime * result + ((mgrid == null) ? 0 : mgrid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		department other = (department) obj;
		if (deptid == null) {
			if (other.deptid != null)
				return false;
		} else if (!deptid.equals(other.deptid))
			return false;
		if (deptname == null) {
			if (other.deptname != null)
				return false;
		} else if (!deptname.equals(other.deptname))
			return false;
		if (locid == null) {
			if (other.locid != null)
				return false;
		} else if (!locid.equals(other.locid))
			return false;
		if (mgrid == null) {
			if (other.mgrid != null)
				return false;
		} else if (!mgrid.equals(other.mgrid))
			return false;
		return true;
	}
	
	
	
	
	
	
}


