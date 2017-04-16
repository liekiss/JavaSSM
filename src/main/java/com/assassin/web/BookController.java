package com.assassin.web;

import com.assassin.dto.AppointExecution;
import com.assassin.dto.Result;
import com.assassin.entity.Book;
import com.assassin.enums.AppointStateEnum;
import com.assassin.exception.AppointException;
import com.assassin.exception.NoNumberException;
import com.assassin.exception.RepeatAppointException;
import com.assassin.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by 28929_000 on 2017/4/16.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private String list(Model model) {
        List<Book> bookList = bookService.getList();
        model.addAttribute("list", bookList);
        return "list";
    }

    @RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model) {
        if (bookId == null) {
            return "redirect:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @RequestMapping(value = "/appoint/{bookId}", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
        if (studentId == null || studentId.equals("")) {
            return new Result<AppointExecution>(false, "序号不能为空");
        }
        AppointExecution appointExecution = null;
        try {
            appointExecution = bookService.appoint(bookId, studentId);
        } catch (NoNumberException e1) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
        } catch (RepeatAppointException e2) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
        } catch (AppointException e3) {
            appointExecution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
        }
        return new Result<AppointExecution>(true, appointExecution);
    }
}
