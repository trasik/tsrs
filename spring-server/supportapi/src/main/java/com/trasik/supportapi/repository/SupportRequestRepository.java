package com.trasik.supportapi.repository;


import com.trasik.supportapi.model.SupportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportRequestRepository extends JpaRepository<SupportRequest, Integer> {

    public List<SupportRequest> findAllByOrderByDueDateAsc();
}
