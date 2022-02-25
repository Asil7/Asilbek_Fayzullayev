package uz.pdp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.dao.BookDao;
import uz.pdp.dto.AuthorDto;
import uz.pdp.dto.BookDto;

import java.util.List;

//Asilbek Fayzullayev 25.02.2022 9:00
@Service
public class BookService {

    @Autowired
    BookDao bookDao;


    public List<BookDto> getBooks(){
        return bookDao.getBook();
    }

    public BookDto getBookById(String courseId){
        return bookDao.getBooksById(courseId);
    }

    public boolean addBooks(String name,String description,String  price) {
        return bookDao.addBooks(name,description,price);
    }

    public String deleteBooks(@PathVariable int id) {
        bookDao.deleteBooks(id);
        return "redirect:/books";
    }

    public boolean editBook(BookDto bookDto){
        return bookDao.editBook(bookDto);
    }

    public List<BookDto> getSearched(String name){
        return bookDao.getSearchedBooks (name);}

}
