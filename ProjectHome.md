Blogger API: http://www.blogger.com/developers/api/1_docs/

For [maven](http://maven.apache.org/):
```
<dependency>
    <groupId>com.redv.bloggerapi</groupId>
    <artifactId>blogger-api-client</artifactId>
    <version>1.1</version>
</dependency>
```
Sample:
```
BloggerClient bc = new BloggerClient(new BloggerImpl(serverURL), username, password);
User user = bc.getUserInfo();
```

To know more: http://redv.com/blogger-api-client/