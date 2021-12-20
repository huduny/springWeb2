package kr.or.ddit.vo;

import java.io.Serializable;

public class BtsVO implements Serializable{

	public BtsVO() {
		super();
	}
	
	public BtsVO(String id, String name, String contentPage) {
		super();
		this.id = id;
		this.name = name;
		this.contentPage = contentPage;
	}

	private String id;
	private String name;
	private String contentPage;
	private String cookie;
	
	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContentPage() {
		return contentPage;
	}
	public void setContentPage(String contentPage) {
		this.contentPage = contentPage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BtsVO [id=" + id + ", contentPage=" + contentPage + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BtsVO other = (BtsVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
