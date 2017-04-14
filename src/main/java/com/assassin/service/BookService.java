package com.assassin.service;

import com.assassin.dto.AppointExecution;
import com.assassin.entity.Book;

import java.util.List;

/**
 * Created by Ray on 2017/4/14.
 */
public interface BookService {
    Book getById(long bookId);

    /**
     * 获取图书列表
     * @return 返回图书列表
     */
    List<Book> getList();

    /**
     * 预约图书
     * @param bookId 图书id
     * @param studentId 学生id
     * @return 预约信息
     */
    AppointExecution appoint(long bookId,long studentId);

}
