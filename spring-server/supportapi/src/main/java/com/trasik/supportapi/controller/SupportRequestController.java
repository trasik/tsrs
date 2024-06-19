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

    // Takes in a request parameter to check which data should be returned
    @GetMapping("supportrequests")
    @ResponseStatus(HttpStatus.OK)
    private List<SupportRequest> getAllRequests(@RequestParam String option) {
        //If the selection from the client is relevant, just get all requests
        if(option.equals("relevant")) {
            return supportRequestService.getAllSupportRequests();
        // Else if the option is earliestDueDate then return the requests ordered by due date
        } else if(option.equals("earliestDueDate")) {
            return supportRequestService.getAllSupportRequestsOrderByDateAsc();
        } else {
        // If an unknown option is given then just return all requests
            return supportRequestService.getAllSupportRequests();
        }
    }

    @PostMapping("supportrequests/add")
    @ResponseStatus(HttpStatus.CREATED)
    private SupportRequest createAndSaveRequest(@Valid @RequestBody SupportRequest sr) {
        return supportRequestService.saveSupportRequest(sr);
    }

}
