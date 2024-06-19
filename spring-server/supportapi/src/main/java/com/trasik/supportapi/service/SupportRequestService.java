package com.trasik.supportapi.service;

import com.trasik.supportapi.model.SupportRequest;
import com.trasik.supportapi.repository.SupportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public SupportRequest saveSupportRequest(SupportRequest sr) {
        return supportRequestRepository.save(sr);
    }
}
