package com.cbox.library.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbox.library.domain.form.UserUpdateRequestForm;
import com.cbox.library.domain.repository.UserUpdateRequestRepository;

@Service
public class UserUpdateRequestService {
    @Autowired
    UserUpdateRequestRepository userUpdateRequestRepository;
    
    public int create(UserUpdateRequestForm form, String userAgent, String ipAdress) {
        int userId = form.getUserId();
        String name = form.getName();
        String furigana = form.getFurigana();
        int boardId = form.getBoardId();
        String discription = form.getDiscription();
        return userUpdateRequestRepository.create(userId, name, furigana, boardId, discription, userAgent, ipAdress);
    }
}
