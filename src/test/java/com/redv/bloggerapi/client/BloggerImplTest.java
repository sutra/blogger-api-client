/**
 * Created on 2006-9-30 上午12:15:48
 */
package com.redv.bloggerapi.client;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.redv.bloggerapi.client.Blog;
import com.redv.bloggerapi.client.Blogger;
import com.redv.bloggerapi.client.BloggerImpl;
import com.redv.bloggerapi.client.Fault;
import com.redv.bloggerapi.client.User;

/**
 * @author Shutra
 * 
 */
public class BloggerImplTest {
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#BloggerImpl(java.lang.String)}.
	 */
	@Test
	public void testBloggerImpl() {

	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#editPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	public void testEditPost() {
	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#getTemplate(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetTemplate() {
	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#getUserInfo(java.lang.String, java.lang.String, java.lang.String)}.
	 * 
	 * @throws Fault
	 * @throws MalformedURLException
	 */
	@Test
	public void testGetUserInfo() throws Fault, MalformedURLException {
		Blogger blogger = new BloggerImpl("http://www.bokeland.com/xmlrpc.php");
		User user = blogger.getUserInfo("dummy", "blogmover", "xpert.cn");
		assertEquals(user.getUserid(), "");
		assertEquals(user.getEmail(), "");
		assertEquals(user.getFirstname(), "");
		assertEquals(user.getLastname(), "");
		assertEquals(user.getNickname(), "");
		assertEquals(user.getUrl(), "");
	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#getUsersBlogs(java.lang.String, java.lang.String, java.lang.String)}.
	 * 
	 * @throws Fault
	 * @throws MalformedURLException
	 */
	@Test
	public void testGetUsersBlogs() throws Fault, MalformedURLException {
		Blogger blogger = new BloggerImpl("http://www.bokeland.com/xmlrpc.php");
		Blog[] blogs = blogger.getUsersBlogs("dummy", "blogmover", "xpert.cn");
		assertEquals(blogs.length, 1);
		assertEquals(blogs[0].getBlogid(), "722");
		assertEquals(blogs[0].getBlogName(), "Blog Mover");
		assertEquals(blogs[0].getUrl(), "http://blogmover.bokeland.com");
	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#newPost(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	public void testNewPost() {
	}

	/**
	 * Test method for
	 * {@link com.redv.bloggerapi.client.BloggerImpl#setTemplate(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSetTemplate() {
	}

}
