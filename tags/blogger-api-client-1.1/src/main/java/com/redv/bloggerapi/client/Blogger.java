/**
 * Created on 2006-9-29 下午10:01:03
 */
package com.redv.bloggerapi.client;

import java.io.Serializable;

/**
 * An implementation of Blogger API for Java.
 * 
 * @see <a href="http://www.blogger.com/developers/api/1_docs/">Blogger API</a>
 * @author <a href="mailto:zhoushuqun@gmail.com">Sutra Zhou</a>
 * 
 */
public interface Blogger extends Serializable {
	/**
	 * Makes a new post to a designated blog. Optionally, will publish the blog
	 * after making the post.
	 * <p>
	 * blogger.newPost makes a new post to a designated blog. Optionally, will
	 * publish the blog after making the post. On success, it returns the unique
	 * ID of the new post (usually a seven-digit number at this time). On error,
	 * it will return some error message.
	 * </p>
	 * 
	 * @param appkey
	 *            Unique identifier/passcode of the application sending the
	 *            post.
	 * @param blogid
	 *            Unique identifier of the blog the post will be added to.
	 * @param username
	 *            Login for a Blogger user who has permission to post to the
	 *            blog.
	 * @param password
	 *            Password for said username.
	 * @param content
	 *            Contents of the post.
	 * @param publish
	 *            If true, the blog will be published immediately after the post
	 *            is made.
	 * @return
	 * @see <a
	 *      href="http://www.blogger.com/developers/api/1_docs/xmlrpc_newPost.html">http://www.blogger.com/developers/api/1_docs/xmlrpc_newPost.html</a>
	 */
	String newPost(String appkey, String blogid, String username,
			String password, String content, boolean publish) throws Fault;

	/**
	 * Edits a given post. Optionally, will publish the blog after making the
	 * edit.
	 * <p>
	 * blogger.editPost changes the contents of a given post. Optionally, will
	 * publish the blog the post belongs to after changing the post. On success,
	 * it returns a boolean true value. On error, it will return a fault with an
	 * error message.
	 * </p>
	 * 
	 * @param appkey
	 *            Unique identifier/passcode of the application sending the
	 *            post.
	 * @param postid
	 *            Unique identifier of the post to be changed.
	 * @param username
	 *            Login for a Blogger user who has permission to edit the given
	 *            post (either the user who originally created it or an admin of
	 *            the blog).
	 * @param password
	 *            Password for said username.
	 * @param content
	 *            New content of the post.
	 * @param publish
	 * @return If true, the blog will be published immediately after the post is
	 *         made.
	 * @see <a
	 *      href="http://www.blogger.com/developers/api/1_docs/xmlrpc_editPost.html">blogger.editPost
	 *      via XML-RPC</a>
	 */
	boolean editPost(String appkey, String postid, String username,
			String password, String content, boolean publish) throws Fault;

	/**
	 * Returns information on all the blogs a given user is a member of.
	 * <p>
	 * blogger.getUsersBlogs returns information about all the blogs a given
	 * user is a member of. Data is returned as an array of <struct>'s
	 * containing the ID (blogid), name (blogName), and URL (url) of each blog.
	 * </p>
	 * 
	 * @param appkey
	 *            Unique identifier/passcode of the application sending the
	 *            post.
	 * @param username
	 *            Login for the Blogger user who's blogs will be retrieved.
	 * @param password
	 *            Password for said username.
	 * @return
	 * @see <a
	 *      href="http://www.blogger.com/developers/api/1_docs/xmlrpc_getUsersBlogs.html">blogger.getUsersBlogs
	 *      via XML-RPC</a>
	 */
	Blog[] getUsersBlogs(String appkey, String username, String password)
			throws Fault;

	/**
	 * Authenticates a user and returns basic user info (name, email, userid,
	 * etc.).
	 * <p>
	 * blogger.getUserInfo returns returns a struct containing user's userid,
	 * firstname, lastname, nickname, email, and url.
	 * </p>
	 * 
	 * @param appkey
	 *            Unique identifier/passcode of the application sending the
	 *            post.
	 * @param username
	 *            Login for the Blogger user who's blogs will be retrieved.
	 * @param password
	 *            Password for said username.
	 * @return
	 * @see <a
	 *      href="http://www.blogger.com/developers/api/1_docs/xmlrpc_getUserInfo.html">blogger.getUserInfo
	 *      via XML-RPC</a>
	 */
	User getUserInfo(String appkey, String username, String password)
			throws Fault;

	/**
	 * Returns the main or archive index template of a given blog.
	 * <p>
	 * blogger.getTemplate returns text of the main or archive index template
	 * for a given blog.
	 * </p>
	 * 
	 * @param appkey
	 *            Unique identifier/passcode of the application sending the
	 *            post.
	 * @param blogid
	 *            Unique identifier of the blog who's template is to be
	 *            returned.
	 * @param username
	 *            Login for a Blogger who has admin permission on give blog.
	 * @param password
	 *            Password for said username.
	 * @param templateType
	 *            Determines which of the blog's templates will be returned.
	 *            Currently, either "main" or "archiveIndex".
	 * @return
	 * @see <a
	 *      href="http://www.blogger.com/developers/api/1_docs/xmlrpc_getTemplate.html">blogger.getTemplate
	 *      via XML-RPC</a>
	 */
	String getTemplate(String appkey, String blogid, String username,
			String password, String templateType) throws Fault;

	/**
	 * Edits the main or archive index template of a given blog.
	 * <p>
	 * blogger.setTemplate changes the template for a given blog. Can change
	 * either main or archive index template.
	 * </p>
	 * 
	 * @param appkey
	 *            Unique identifier/passcode of the application sending the
	 *            post.
	 * @param blogid
	 *            Unique identifier of the blog who's template is to be
	 *            returned.
	 * @param username
	 *            Login for a Blogger who has admin permission on give blog.
	 * @param password
	 *            Password for said username.
	 * @param template
	 *            The text for the new template (usually mostly HTML). Must
	 *            contain opening and closing <Blogger> tags, since they're
	 *            needed to publish.
	 * @param templateType
	 *            Determines which of the blog's templates will be returned.
	 *            Currently, either "main" or "archiveIndex".
	 * @return
	 * @see <a
	 *      href="http://www.blogger.com/developers/api/1_docs/xmlrpc_setTemplate.html">blogger.setTemplate
	 *      via XML-RPC</a>
	 */
	boolean setTemplate(String appkey, String blogid, String username,
			String password, String template, String templateType) throws Fault;
}
