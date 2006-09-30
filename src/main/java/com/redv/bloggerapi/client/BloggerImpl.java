/**
 * Created on 2006-9-29 23:53:24
 */
package com.redv.bloggerapi.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

/**
 * @author Shutra
 * 
 */
public class BloggerImpl implements Blogger {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2766246309255144312L;

	private XmlRpcClient client;

	public BloggerImpl(String serverURL) throws MalformedURLException {
		this.client = new XmlRpcClient();
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL(serverURL));
		config.setEnabledForExtensions(false);
		client.setConfig(config);
		client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.bloggerapiclient.Blogger#editPost(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, boolean)
	 */
	public boolean editPost(String appkey, String postid, String username,
			String password, String content, boolean publish) throws Fault {
		Object[] params = new Object[] { appkey, postid, username, password,
				content, publish };
		return (Boolean) this.execute("blogger.editPost", params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.bloggerapiclient.Blogger#getTemplate(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String)
	 */
	public String getTemplate(String appkey, String blogid, String username,
			String password, String templateType) throws Fault {
		Object[] params = new Object[] { appkey, blogid, username, password,
				templateType };
		return (String) this.execute("blogger.getTemplate", params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.bloggerapiclient.Blogger#getUserInfo(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public User getUserInfo(String appkey, String username, String password)
			throws Fault {
		Object[] params = new Object[] { appkey, username, password };
		Object object = this.execute("blogger.getUserInfo", params);
		Map<String, String> m = (Map<String, String>) object;
		User user = new User();
		user.setNickname(m.get("nickname"));
		user.setUserid(m.get("userid"));
		user.setUrl(m.get("url"));
		user.setEmail(m.get("email"));
		user.setLastname(m.get("lastname"));
		user.setFirstname(m.get("firstname"));
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.bloggerapiclient.Blogger#getUsersBlogs(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Blog[] getUsersBlogs(String appkey, String username, String password)
			throws Fault {
		Object[] params = new Object[] { appkey, username, password };
		Object o = this.execute("blogger.getUsersBlogs", params);
		Object[] result = (Object[]) o;
		int len = result.length;
		Blog[] blogs = new Blog[len];
		for (int i = 0; i < len; i++) {
			Map<String, String> m = (Map<String, String>) result[i];
			blogs[i] = new Blog();
			blogs[i].setBlogid(m.get("blogid"));
			blogs[i].setBlogName(m.get("blogName"));
			blogs[i].setUrl(m.get("url"));
		}
		return blogs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.bloggerapiclient.Blogger#newPost(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, boolean)
	 */
	public String newPost(String appkey, String blogid, String username,
			String password, String content, boolean publish) throws Fault {
		Object[] params = new Object[] { appkey, blogid, username, password,
				content, publish };
		return (String) this.execute("blogger.newPost", params);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.redv.bloggerapiclient.Blogger#setTemplate(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	public boolean setTemplate(String appkey, String blogid, String username,
			String password, String template, String templateType) throws Fault {
		Object[] params = new Object[] { appkey, blogid, username, password,
				template, templateType };
		return (Boolean) this.execute("blogger.setTemplate", params);
	}

	private Object execute(String methodName, Object[] params) throws Fault {
		try {
			return client.execute(methodName, params);
		} catch (XmlRpcException e) {
			Fault fault = new Fault(e.getMessage(), e);
			fault.setCode(e.code);
			throw fault;
		}

	}

}
