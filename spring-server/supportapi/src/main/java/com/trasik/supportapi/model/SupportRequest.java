package com.trasik.supportapi.model;

import com.trasik.supportapi.utils.IsBeforeAYear;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "supportrequest")
@Valid
public class SupportRequest {

    @Id
    @GeneratedValue
    private int requestID;

    @Email(message = "Invalid email address.")
    @Size(max = 320, message = "Email address cannot exceed 320 characters.")
    private String email;

    @Column(length = 1000)
    @Size(min = 100, message = "Description cannot be less than 100 characters.")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters.")
    private String description;

    @FutureOrPresent(message = "Due Date cannot be in the past")
    @IsBeforeAYear(message = "Date is too far in the future. The request due date cannot be more than a year from today.")
    private LocalDate dueDate;

    @CreatedDate
    private LocalDate createdDate;

    protected SupportRequest() {
    }

    public SupportRequest(String email, String description, LocalDate dueDate) {
        this.email = email;
        this.description = description;
        this.dueDate = dueDate;
    }

    public int getRequestID() {
        return requestID;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
