package com.assassin.dao;

import com.assassin.entity.Appointment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by work on 2017/4/12.
 */
public interface AppointmentDao {
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
}
