package com.assassin.dao;

import com.assassin.BaseTest;
import com.assassin.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by work on 2017/4/12.
 */
public class BookDaoTest extends BaseTest {
    @Autowired
    private BookDao bookDao;

    @Test
    public void testQueryAll() throws Exception {
        List<Book> books = bookDao.queryAll(0, 10);
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }
}
