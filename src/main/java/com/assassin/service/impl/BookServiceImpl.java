package com.assassin.service.impl;

import com.assassin.dao.AppointmentDao;
import com.assassin.dao.BookDao;
import com.assassin.dto.AppointExecution;
import com.assassin.entity.Appointment;
import com.assassin.entity.Book;
import com.assassin.enums.AppointStateEnum;
import com.assassin.exception.AppointException;
import com.assassin.exception.NoNumberException;
import com.assassin.exception.RepeatAppointException;
import com.assassin.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ray on 2017/4/14.
 */
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Book getById(long bookId) {
        return bookDao.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookDao.queryAll(0, 1000);
    }

    @Override
    @Transactional
    public AppointExecution appoint(long bookId, long studentId) {
        try {
            int reduce = bookDao.reduceNumber(bookId);
            if (reduce <= 0) {
                throw new NoNumberException("no number");
            } else {
                int appoint = appointmentDao.insertAppointment(bookId, studentId);
                if (appoint <= 0) {
                    throw new RepeatAppointException("repeat appoint");
                } else {
                    Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
                }
            }
        } catch (NoNumberException e1) {
            logger.error(e1.getMessage(), e1);
            throw e1;
        } catch (RepeatAppointException e2) {
            logger.error(e2.getMessage(), e2);
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new AppointException("appoint error:" + e.getMessage());
        }
    }
}
