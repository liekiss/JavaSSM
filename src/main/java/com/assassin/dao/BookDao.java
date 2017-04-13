package com.assassin.dao;

import com.assassin.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by work on 2017/4/11.
 */
public interface BookDao {

    Book queryById(long id);

    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int reduceNumber(long bookId);
}
