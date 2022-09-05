package com.jcs.education.course.unit.service.service;

import com.jcs.education.course.unit.service.exception.RequestValidationException;
import com.jcs.education.course.unit.service.proto.v1.GetCourseUnitsRequest;

public class CourseUnitServiceValidator {

    private CourseUnitServiceValidator() {
        throw new UnsupportedOperationException("CourseUnitServiceValidator is a static utility class");
    }

    static void validateGetCourseUnitsRequest(GetCourseUnitsRequest request) {
        if (request.getCourseId() == 0) {
            throw new RequestValidationException("course_id must be specified");
        }
    }

}
