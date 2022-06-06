package com.demo.model;

public class TinyUrl {
	
	private String url;
	private String shortcode;

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

	public TinyUrl() {
		// TODO Auto-generated constructor stub
	}
	
	public TinyUrl(String url, String shortcode){
		this.url = url;
		this.shortcode = shortcode;
	}

	@Override
	public String toString() {
		return "TinyUrl [url=" + url + ", shortcode=" + shortcode + "]";
	}

}
