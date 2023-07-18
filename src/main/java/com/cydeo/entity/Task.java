package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "tasks")
@Data
@NoArgsConstructor
@Where(clause = "is_deleted=false")
public class Task extends BaseEntity{

    private String taskSubject;
    private String taskDetail;
    @Enumerated(EnumType.STRING)
    private Status taskStatus;
    @Column(columnDefinition = "DATE")
    private LocalDate assignDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User assignedEmployee;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

}
