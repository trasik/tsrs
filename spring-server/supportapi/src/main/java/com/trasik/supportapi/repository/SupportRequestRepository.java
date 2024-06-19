package com.trasik.supportapi.repository;


import com.trasik.supportapi.model.SupportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportRequestRepository extends JpaRepository<SupportRequest, Integer> {

    // Uses JPA functionality to find all requests and order them by the due date column
    public List<SupportRequest> findAllByOrderByDueDateAsc();
}
