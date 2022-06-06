package com.demo.model;

public class TinyUrlStats {

	private String url;
	private String shortcode;

	private String created;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getLastRedirect() {
		return lastRedirect;
	}

	public void setLastRedirect(String lastRedirect) {
		this.lastRedirect = lastRedirect;
	}

	public String getRedirectCount() {
		return redirectCount;
	}

	public void setRedirectCount(String redirectCount) {
		this.redirectCount = redirectCount;
	}

	private String lastRedirect;

	private String redirectCount;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public TinyUrlStats() {
		// TODO Auto-generated constructor stub
	}

	public TinyUrlStats(String url, String shortcode,String created, String lastRedirect, String redirectCount){
		this.url = url;
		this.shortcode = shortcode;
		this.redirectCount=redirectCount;
		this.lastRedirect=lastRedirect;
		this.created=created;
	}

	@Override
	public String toString() {
		return "TinyUrlStats [created=" + created + ",lastRedirect=" + lastRedirect + "" +
				", redirectCount=" + redirectCount + "]";

	}

}
