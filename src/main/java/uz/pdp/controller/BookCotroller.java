package uz.pdp.controller;



//Asilbek Fayzullayev 25.02.2022 8:55

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.pdp.dto.AuthorDto;
import uz.pdp.dto.BookDto;
import uz.pdp.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/books")
@Controller
public class BookCotroller {

    @Autowired
    BookService bookService;

    @GetMapping
    public String getBooks(Model model) {
        List<BookDto> allBook = bookService.getBooks();

        model.addAttribute("BookList", allBook);
        return "view-books";
    }

    @GetMapping("/addBooks")
    public String addBooks() {
        return "addBooks";
    }

    @PostMapping("/postCourse")
    public String postCourse(HttpServletRequest request, Model model) {

        String name = (String) request.getParameter("name");
        String description = (String) request.getParameter("description");
        String  price = (String) request.getParameter("price");


        boolean isAdded = bookService.addBooks(name,description,price);

        String isAdd = null;
        if (isAdded) {
            isAdd="Successfully added !";
        } else {
            isAdd="Sorry not added !";
        }

        model.addAttribute("isAdd", isAdd);

        return "redirect:/books";
    }

    @GetMapping("/delete/{bookId}")
    public String deleteCourse(@PathVariable Integer bookId, RedirectAttributes ra) {
        try {
            bookService.deleteBooks(bookId);
            ra.addFlashAttribute("course_message", "Book successfully deleted " + bookId);
            return "redirect:/books";

        } catch (Exception e) {
            ra.addFlashAttribute("error_message", "Book not found");
            return "redirect:/books";
        }
    }

    @GetMapping("/editBook")
    public String editBook(Model model, HttpServletRequest request){
        String id = request.getParameter("id");

        BookDto bookDto = bookService.getBookById(id);

        model.addAttribute("book", bookDto);

        return "edit-book";

    }

    @PostMapping("/editBook")
    public String editBook(HttpServletRequest request ,Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setName(name);
        bookDto.setDescription(description);
        bookDto.setPrice(price);


        if (bookService.editBook(bookDto)) {
            model.addAttribute("message", "Book successfully edit !!!");
        } else {
            model.addAttribute("message", "Book not edit !!!");
        }
        return "redirect:/books";
    }

    @RequestMapping(value = "/searched", method = RequestMethod.POST)
    public String search(@RequestParam String s,Model model){
        List<BookDto> allBooks = bookService.getSearched(s);
        model.addAttribute("Booklist", allBooks);
        return "view-books";
    }
}
