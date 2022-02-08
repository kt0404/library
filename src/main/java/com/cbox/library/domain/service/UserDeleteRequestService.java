package com.cbox.library.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.UserDeleteRequestForm;
import com.cbox.library.domain.repository.UserDeleteRequestRepository;

@Service
public class UserDeleteRequestService {
    @Autowired
    UserDeleteRequestRepository userDeleteRequestRepository;
    
    public int create(UserDeleteRequestForm form, String userAgent, String ipAddress) {
        int userId = form.getUserId();
        String deleteReason = form.getDeleteReason();
        return userDeleteRequestRepository.create(userId, deleteReason, userAgent, ipAddress);
    }
}
