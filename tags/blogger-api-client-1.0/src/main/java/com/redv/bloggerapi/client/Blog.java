/**
 * Created on 2006-9-29 下午10:22:04
 */
package com.redv.bloggerapi.client;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			if (this == null) {
				return true;
			} else {
				return false;
			}
		}

		if (obj instanceof Blog == false) {
			return false;
		}

		Blog o = (Blog) obj;
		return new EqualsBuilder().append(this.blogid, o.blogid).append(
				this.url, o.url).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.blogid).append(this.blogName)
				.append(this.url).hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
