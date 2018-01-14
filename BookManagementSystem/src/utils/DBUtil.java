package utils;

import model.Book;
import model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    private static List<User> userDb = new ArrayList<>();
    private static List<Map<String, String>> categoryDb = new ArrayList<>();
    private static List<Book> bookDb = new ArrayList<>();

    public static Map<String, String> form_post_handle(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        System.out.println(request.getParameterMap());
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            map.put(entry.getKey(), entry.getValue()[0]);
        }
        return map;
    }

    public static void addCategory(Map<String, String> category_message) {
        categoryDb.add(category_message);
    }

    public static void addBook(Book book) {
        bookDb.add(book);
    }

    public static Book mapToBook(Map<String, String> book_message) {
        Book book = new Book();
        book.setId(book_message.get("id"));
        book.setBookName(book_message.get("bookName"));
        book.setCatgoryName(book_message.get("catgoryName"));
        book.setPrice(book_message.get("price"));
        book.setDescription(book_message.get("description"));
        return book;
    }

    public static List<Book> getBooksByCondition(String bookID, String bookName, String catgoryNam) {
        List<Book> conditionBook = new ArrayList<>();
        for (Book book : bookDb) {
            if ("".equals(bookID) && "".equals(bookName) && "".equals(catgoryNam)){
                conditionBook.add(book);
                continue;
            }
            if ("".equals(bookID) && "".equals(bookName)) {
                if (catgoryNam.equals(book.getCatgoryName()))
                    conditionBook.add(book);
                    continue;
            }
            if (!"".equals(bookID) && !"".equals(bookName)) {
                if ("".equals(catgoryNam)){
                    if (bookID.equals(book.getId()) && bookName.equals(book.getBookName())){
                        conditionBook.add(book);
                        continue;
                    }
                }else {
                    if (bookID.equals(book.getId()) && bookName.equals(book.getBookName()) &&
                            catgoryNam.equals(book.getCatgoryName())){
                        conditionBook.add(book);
                        continue;
                    }
                }
            }
            if (!"".equals(bookID) || !"".equals(bookName)){
                if ("".equals(bookID)){
                    if (bookName.equals(book.getBookName())){
                        conditionBook.add(book);
                    }
                }else {
                    if (bookID.equals(book.getId())){
                        conditionBook.add(book);
                    }
                }
            }

        }
        return conditionBook;
    }

    public static List<Map<String, String>> getCategoryDb() {
        return categoryDb;
    }

    public static List<Book> getBookDb() {
        return bookDb;
    }

}
