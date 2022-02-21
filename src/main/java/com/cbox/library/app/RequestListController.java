package com.cbox.library.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cbox.library.domain.common.Constants;
import com.cbox.library.domain.mapper.MemberDeleteRequestMapper;
import com.cbox.library.domain.model.DeleteRequest;
import com.cbox.library.domain.model.UpdateRequest;
import com.cbox.library.domain.service.MemberDeleteRequestService;
import com.cbox.library.domain.service.MemberUpdateRequestService;

@Controller
public class RequestListController {
    @Autowired
    MemberUpdateRequestService memberUpdateRequestService;
    
    @Autowired
    MemberDeleteRequestService memberDeleteRequestService;
    
    @Autowired
    MemberDeleteRequestMapper deleteRequestMapper;
    
    @GetMapping("/request/list")
    public String requestList(Model model) {
        List<UpdateRequest> updateList = memberUpdateRequestService.findByDeleteFlag(Constants.Request.FLAG_UNPROCESSED);
//        List<UpdateRequest> updateList = memberUpdateRequestService.findAllByDeleteFlag(Constants.Request.FLAG_UNPROCESSED);
        List<DeleteRequest> deleteList = memberDeleteRequestService.findAllByDeleteFlagWithMemberName(Constants.Request.FLAG_UNPROCESSED);
        model.addAttribute("updateList", updateList);
        model.addAttribute("deleteList", deleteList);
        return "request_list";
    }
}
