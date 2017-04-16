package com.assassin.service.impl;

import com.assassin.BaseTest;
import com.assassin.dto.AppointExecution;
import com.assassin.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 28929_000 on 2017/4/15.
 */
public class BookServiceImplTest extends BaseTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint(){
        long bookId=1001,studentId=123456789L;
        AppointExecution appoint = bookService.appoint(bookId, studentId);
        System.out.println(appoint);
    }

}
