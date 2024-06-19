package com.trasik.supportapi.controller;

import com.trasik.supportapi.model.SupportRequest;
import com.trasik.supportapi.service.SupportRequestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/")
@RestController
@RequestMapping("/api/v1/")
public class SupportRequestController {

    @Autowired
    private SupportRequestService supportRequestService;

    @GetMapping("supportrequests")
    @ResponseStatus(HttpStatus.OK)
    private List<SupportRequest> getAllRequests() {
        return supportRequestService.getAllSupportRequests();
    }

    @GetMapping("supportrequests/order")
    @ResponseStatus(HttpStatus.OK)
    private List<SupportRequest> getAllRequests2() {
        return supportRequestService.getAllSupportRequestsOrderByDateAsc();
    }

    @PostMapping("supportrequests/add")
    @ResponseStatus(HttpStatus.CREATED)
    private SupportRequest createAndSaveRequest(@Valid @RequestBody SupportRequest sr) {
        return supportRequestService.saveSupportRequest(sr);
    }

}
