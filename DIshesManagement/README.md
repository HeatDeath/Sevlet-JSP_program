一、语言和环境

     l  实现技术

        Java  Web技术

     l  环境要求及开发工具

        JDK1.7以上、Eclipse或IntelliJ IDEA、Tomcat 8.0以上

二、程序整体要求

     主要功能：

l  菜品添加：菜品包括菜品ID、菜名、口味、菜品图片、价格、菜品描述，要将菜品信息保存到集合中，同时菜品图片上传到服务器

l  菜品信息查询：包括显示所有菜品信息和根据菜名查询菜品信息并显示

l  菜品修改：根据菜品id进行菜品修改，如果不存在该菜品则在页面中显示id不存在的提示

l  菜品删除：根据菜品id进行菜品删除，如果不存在该菜品则在页面中显示id不存在的提示

注意：

       l  数据存储到集合中（使用ArrayList、HashSet和HashMap集合均可）

三、思路分析：

由场景和运行效果，可以分析出项目中可以抽取如下类：

l  菜品类Food：

    类型描述：能够描述菜品ID、菜名、口味、图片地址、价格、描述等

    方法：构造方法、get和set方法，toString()方法

l  处理上传相关的类UploadUtils：

    类型描述：存储添加页面中所有参数的集合Map<String, Object> params; 其中key值是表单中控件的名称，value是表单控件对应的值

    方法：

    文件上传的工具方法：public static Map<String, Object> UploadFile(HttpServletRequest request, String uploadDirectory) 

    提示：该方法负责将表单中的信息存储到集合中，并完成图片的上传 

l  菜品数据处理类FoodDaoImpl：

    类型描述：

    存放菜品信息的List：private static final List<Map<String, Object>> db;

    提示：Map中存储的就是一条菜品的信息，也就是UploadUtils中的Map

    方法：

    添加菜品：public void addFood(Map<String, Object> food)

    查询所有菜品信息：public List<Map<String, Object>> getAllFood()

    根据菜品名称查询菜品信息：public List<Map<String, Object>> getFoodByName(String foodName)

    菜品修改：public void updateFood(Map<String, Object> food

    根据菜品ID进行删除：public void deleteFoodById(String id)

        l  Servlet相关类：

           根据需要自行定义，如对应增删改查功能的Servlet

        l  JSP页面：

            素材中已提供部分所需的静态页面，可以改成jsp页面
