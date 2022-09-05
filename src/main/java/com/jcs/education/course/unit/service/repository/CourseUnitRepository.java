package com.jcs.education.course.unit.service.repository;

import com.jcs.education.course.unit.service.entity.CourseUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseUnitRepository extends JpaRepository<CourseUnitEntity, Integer> {
    List<CourseUnitEntity> findAllByCourseId(Integer courseId);
}
