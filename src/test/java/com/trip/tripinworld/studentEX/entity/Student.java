package com.trip.tripinworld.studentEX.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = Student.STUDENT)
public class Student implements Serializable {
    public static final String STUDENT = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = Student.ID)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = Student.NAME)
    private String name;

    @Column(name = Student.ADDRESS)
    private String address;
}
