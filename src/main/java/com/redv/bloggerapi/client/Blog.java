/**
 * Created on 2006-9-29 下午10:22:04
 */
package com.redv.bloggerapi.client;

import java.io.Serializable;

/**
 * @author Shutra
 * 
 */
public class Blog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String blogid;

	private String url;

	private String blogName;

	/**
	 * @return the blogid
	 */
	public String getBlogid() {
		return blogid;
	}

	/**
	 * @param blogid
	 *            the blogid to set
	 */
	public void setBlogid(String blogid) {
		this.blogid = blogid;
	}

	/**
	 * @return the blogName
	 */
	public String getBlogName() {
		return blogName;
	}

	/**
	 * @param blogName
	 *            the blogName to set
	 */
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
