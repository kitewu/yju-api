package com.guanshan.phoenix.service;

import com.guanshan.phoenix.error.ApplicationErrorException;
import com.guanshan.phoenix.webdomain.ResHomeworkDetail;

public interface HomeworkService {
    ResHomeworkDetail getHomeworkDetail(int homeworkID) throws ApplicationErrorException;
}
