package com.assassin.entity;

import java.util.Date;

/**
 * Created by work on 2017/4/11.
 */
public class Appointment {
    private long bookId;//图书id
    private long studentId;//学号
    private Date appointTime;//预约时间
    private Book book;//图书

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
