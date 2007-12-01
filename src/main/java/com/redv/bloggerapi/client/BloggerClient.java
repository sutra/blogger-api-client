/**
 * Created on 2007-4-11 下午11:19:08
 */
package com.redv.bloggerapi.client;

/**
 * A Blogger wrapper with username and password.
 * 
 * <pre>
 * BloggerClient bc = new BloggerClient(new BloggerImpl(
 * 		&quot;http://example.com/xmlrpc&quot;), &quot;username&quot;, &quot;password&quot;);
 * bc.getUsersBlogs();
 * </pre>
 * 
 * @see Blogger
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * @since 1.1
 */
public class BloggerClient {
	private Blogger blogger;

	private String appkey = "dummy";

	private String username;

	private String password;

	public BloggerClient(Blogger blogger, String username, String password) {
		this.blogger = blogger;
		this.username = username;
		this.password = password;
	}

	/**
	 * @see Blogger#editPost(String, String, String, String, String, boolean)
	 */
	public boolean editPost(String postid, String content, boolean publish)
			throws Fault {
		return blogger.editPost(appkey, postid, username, password, content,
				publish);
	}

	/**
	 * @see Blogger#getTemplate(String, String, String, String, String)
	 */
	public String getTemplate(String blogid, String templateType) throws Fault {
		return blogger.getTemplate(appkey, blogid, username, password,
				templateType);
	}

	/**
	 * @see Blogger#getUserInfo(String, String, String)
	 */
	public User getUserInfo() throws Fault {
		return blogger.getUserInfo(appkey, username, password);
	}

	/**
	 * @see Blogger#getUsersBlogs(String, String, String)
	 */
	public Blog[] getUsersBlogs() throws Fault {
		return blogger.getUsersBlogs(appkey, username, password);
	}

	/**
	 * @see Blogger#newPost(String, String, String, String, String, boolean)
	 */
	public String newPost(String blogid, String content, boolean publish)
			throws Fault {
		return blogger.newPost(appkey, blogid, username, password, content,
				publish);
	}

	/**
	 * @see Blogger#setTemplate(String, String, String, String, String, String)
	 */
	public boolean setTemplate(String blogid, String template,
			String templateType) throws Fault {
		return blogger.setTemplate(appkey, blogid, username, password,
				template, templateType);
	}
}
