package uz.pdp.dao;



//Asilbek Fayzullayev 25.02.2022 8:59

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.dto.AuthorDto;
import uz.pdp.dto.BookDto;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {

    @Autowired
    JdbcTemplate template;

//    public int addCourseToDb(BookDto bookDto) {
//        String name = bookDto.getName();
//        String description = bookDto.getDescription();
//        Integer[] authorsIds = bookDto.getAuthorsIds();
//        String insertQuery = "insert into books (name, description) values ('" + name + "', '" + description + "' ) returning id";
//        int addedCourseId = template.queryForObject(insertQuery, (rs, rowNum) -> rs.getInt("id"));
//        int res = 0;
//        for (Integer authorsId : authorsIds) {
//            res = template.update("insert into books_authors values (" + addedCourseId + ", " + authorsId + ")");
//        }
//        return res;
//    }
//
//    public List<BookDto> getBooks() {
//        String queryStr = "select * from get_courses";
//        List<BookDto> list = template.query(queryStr, (rs, row) -> {
//            BookDto courseDto = new BookDto();
//            courseDto.setId(rs.getInt(1));
//            courseDto.setName(rs.getString(2));
//            courseDto.setDescription(rs.getString(3));
//            Array array = rs.getArray(4);
//            String authorListStr = array.toString();
//            List<AuthorDto> authorList = new Gson().fromJson(authorListStr, new TypeToken<ArrayList<AuthorDto>>() {
//            }.getType());
//            courseDto.setAuthors(authorList);
//
//            return courseDto;
//        });
//        return list;
//    }
//
//    public boolean addBooks(BookDto bookDto) {
//        if (bookDto.getName() != null && !bookDto.getName().isEmpty()) {
//            String sqlQuery = "insert into books (name,description) values ('" + bookDto.getName() + "'," +
//                    "'" + bookDto.getDescription() + "') returning id";
//
//            int addedCourseId = template.queryForObject(sqlQuery, (rs, rowNum) -> rs.getInt("id"));
//            for (Integer authorsId : bookDto.getAuthorsIds()) {
//                template.update("insert into books_authors" +
//                        " (books_id,author_id) values(" + authorsId + "," + addedCourseId + ")");
//            }
//            return true;
//        }
//        return false;
//
//    }

















    //==================================================================




    public List<BookDto> getBook() {
        String queryStr = "select id,name,description,price from books";
        List<BookDto> list = template.query(queryStr, (rs, row) -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(rs.getInt(1));
            bookDto.setName(rs.getString(2));
            bookDto.setDescription(rs.getString(3));
            bookDto.setPrice(rs.getString(4));
            return bookDto;
        });
        return list;
    }


    public BookDto getBooksById(String i_id) {
        String queryStr = "select * from books where id=" + i_id + " ;";
        return template.queryForObject(queryStr, (rs, row) -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(rs.getInt(1));
            bookDto.setName(rs.getString(2));
            bookDto.setDescription(rs.getString(3));
            bookDto.setPrice(rs.getString(4));
            return bookDto;
        });
    }





    public boolean addBooks(String name, String description, String price) {
        if (name != null && !name.isEmpty()) {
            String sqlQuery = "insert into books ( name,description,price) values ('" + name + "','" + description + "','" + price + "')";

            template.update(sqlQuery);

            return true;
        }
        return false;
    }



    public int deleteBooks(int id) {
        String sql = "delete from books where id=" + id + "";
        return template.update(sql);
    }

    public boolean editBook(BookDto bookDto) {

        String sqlQuery = "update books set name = '" + bookDto.getName() +
                "' ,description ='" + bookDto.getDescription() + "' , price='" + bookDto.getPrice() + "' where id="
                + bookDto.getId();

        if (template.update(sqlQuery) == 1) {
            return true;
        } else {
            return false;
        }
    }


    public List<BookDto> getSearchedBooks(String name) {
        String queryStr = "select b.id,b.name,b.description,b.price from books b where b.name like '%"+name+"%'" +
                "GROUP BY b.id, b.name, b.description, b.price";
        List<BookDto> list = template.query(queryStr, (rs, row) -> {
            BookDto bookDto = new BookDto();
            bookDto.setId(rs.getInt(1));
            bookDto.setName(rs.getString(2));
            bookDto.setDescription(rs.getString(3));
            bookDto.setPrice(rs.getString(4));

            return bookDto;
        });
        return list;
    }
}
