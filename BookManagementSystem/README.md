一、语言和环境

     l  实现技术

        Java  Web技术

     l  环境要求及开发工具

        JDK1.7以上、Eclipse或IntelliJ IDEA、Tomcat 8.0以上

二、程序整体要求

     主要功能：

     1、注册登录功能

        l  注册：信息包括用户名、密码、密码确认、手机号码和邮箱，要使用正则表达式进行校验

        l  登录，注册成功直接跳转到登录页面并显示用户名

        l  登录成功后进入管理页面。 

        l  使用过滤器限制不登录不能进入管理页面

2、图书分类管理

  l  分类添加：分类id、名字、描述

3、图书管理

  l  图书添加：内容包括图书id、图书名、图书分类、价格、描述，价格做正则校验

  l  图书查询：列出所有图书完整信息，可以按id、图书名、分类进行查询，使用Ajax局部刷新，显示所有图书时要使用jstl

      备注：静态页面已提供，可以在素材区进行下载使用。


三、思路分析：

由场景和运行效果，可以分析出项目中可以抽取如下类和页面结构：

l  图书类Book：

   类型描述：能够描述图书ID、图书名、图书分类名、价格、描述等

          方法：构造方法、get和set方法，toString()方法

l  用户类User：

    类型描述：能够描述用户名、密码、手机号码和邮箱等

    方法：构造方法、get和set方法，toString()方法

l  数据处理类LibDaoImpl：

    类型描述：能够描述用户表、图书分类和图书表等

    用户表：private static final List<User> userDb

    图书分类：private static final List<Map<String, Object>> 

    图书表：private static final List<Book> books

    注意：此处图书分类并没有单独定义一个类，而是把分类的id、名称、描述存放到了Map中，然后把每个分类，

             也就是一个HashMap的对象存储到List

             此处的List建议使用ArrayList，Map建议使用HashMap

     方法：

     用户注册：public void regist(User user) {}

     用户登录: public int login(String username, String password) {}.

      判断指定的用户名在数据库是否存在: public int isUserExist(String username) {}

      添加图书分类：public void addBookCatgory(Long id, String catgoryName, String description) {}

      根据条件来查询书籍信息：public List<Book> getBooksByCondition(String bookID, String bookName, String catgoryName) {}

l  业务类LibServiceImpl：

类型描述：LibDaoImpl类的对象，用于对该类中的方法进行调用


             方法：

             此类中的方法形式与LibDaoImpl类完全一致，用于对LibDaoImpl中对应方法的调用

             注意：注册时需要判断用户名是否存在，如果存在给出错误提示，否则进行注册

   l  过滤器相关类：

            判断用户是否登录的过滤器：AuthFilter

            处理中文乱码的过滤器：EncodeFilter

   l  Servlet相关类： 

           根据需要自行定义

   l  JSP页面：

           素材中已提供部分所需的静态页面，可以改成jsp页面
