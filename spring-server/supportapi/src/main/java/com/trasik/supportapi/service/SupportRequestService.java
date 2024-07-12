package com.trasik.supportapi.service;

import com.trasik.supportapi.model.SupportRequest;
import com.trasik.supportapi.repository.SupportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SupportRequestService {

    @Autowired
    private SupportRequestRepository supportRequestRepository;

    public List<SupportRequest> getAllSupportRequests() {
        return supportRequestRepository.findAll();
    }

    public List<SupportRequest> getAllSupportRequestsOrderByDateAsc() {
        return supportRequestRepository.findAllByOrderByDueDateAsc();
    }

    public ResponseEntity<String> saveSupportRequest(SupportRequest sr) {
        if(isDuplicate(sr)) {
            return new ResponseEntity<>("Cannot be duplicate request", HttpStatusCode.valueOf(409));
        } else {
            try {
                supportRequestRepository.save(sr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return new ResponseEntity<>("Ticket failed to save, please try again.", HttpStatusCode.valueOf(409));
            }
            return new ResponseEntity<>("Support request ticket successfully completed!", HttpStatus.CREATED);
        }
    }

    private boolean isDuplicate(SupportRequest sr) {
        SupportRequest found = supportRequestRepository.findByEmailAndDescriptionAndDueDate(sr.getEmail(), sr.getDescription(), sr.getDueDate());
        return found != null;
    }
}
