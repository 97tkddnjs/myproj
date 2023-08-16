package com.dboard.myproj.mysite.admin.controller;


import com.dboard.myproj.data.dto.AdminMemberDTO;
import com.dboard.myproj.mysite.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mysite/admin/rest")
public class RestAdminController {

    private final AdminService service;


//    @PostMapping (value = "/meber/update")
//    Map<String, String> updateMember(@RequestBody AdminMemberDTO member) {
//
//        log.info("rest check "+member);
//        int flag = service.updateMemberByEmail(member);
//
//        Map<String, String> response = new HashMap<>();
//        response.put("result","ok" );
//
//        return response;
//    }


}
