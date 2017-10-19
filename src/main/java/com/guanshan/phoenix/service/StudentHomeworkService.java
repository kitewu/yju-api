package com.guanshan.phoenix.service;

import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.webdomain.ReqHomeworkSubmission;

public interface StudentHomeworkService {
    void submitStudentHomework(ReqHomeworkSubmission homeworkSubmission) throws ApplicationErrorException;

    void validStudentHomeWork(int studentId, int homeworkId) throws ApplicationErrorException;
}