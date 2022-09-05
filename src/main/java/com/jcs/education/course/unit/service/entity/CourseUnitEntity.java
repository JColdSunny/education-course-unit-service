package com.jcs.education.course.unit.service.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "course_units")
@EqualsAndHashCode(of = "id")
public class CourseUnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "course_unit_name")
    private String name;

    @Column(name = "unit_order")
    private Integer order;

    private Integer courseId;

    @JoinColumn(name = "courseUnitId")
    @OneToMany(fetch = FetchType.EAGER)
    private Set<LessonEntity> lessons;
}
