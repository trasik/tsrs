package com.trasik.supportapi.repository;


import com.trasik.supportapi.model.SupportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SupportRequestRepository extends JpaRepository<SupportRequest, Integer> {

    // Uses JPA functionality to find all requests and order them by the due date column
    // SELECT * FROM SUPPORTREQUEST ORDER BY DUE_DATE ASC;
    public List<SupportRequest> findAllByOrderByDueDateAsc();

    public SupportRequest findByEmailAndDescriptionAndDueDate(String email, String description, LocalDate dueDate);
}
