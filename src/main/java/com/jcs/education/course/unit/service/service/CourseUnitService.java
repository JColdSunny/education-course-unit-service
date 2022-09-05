package com.jcs.education.course.unit.service.service;

import com.jcs.education.common.proto.CourseUnit;
import com.jcs.education.course.unit.service.entity.LessonEntity;
import com.jcs.education.course.unit.service.proto.v1.GetCourseUnitsRequest;
import com.jcs.education.course.unit.service.proto.v1.GetCourseUnitsResponse;
import com.jcs.education.course.unit.service.repository.CourseUnitRepository;
import com.jcs.education.lesson.service.proto.v1.EducationLessonServiceGrpc.EducationLessonServiceBlockingStub;
import com.jcs.education.lesson.service.proto.v1.GetLessonsRequest;
import com.jcs.education.lesson.service.proto.v1.GetLessonsResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseUnitService {
    final CourseUnitRepository courseUnitRepository;

    @GrpcClient("education-utility-service")
    EducationLessonServiceBlockingStub lessonService;

    public GetCourseUnitsResponse getCourseUnits(GetCourseUnitsRequest request) {
        CourseUnitServiceValidator.validateGetCourseUnitsRequest(request);

        List<CourseUnit> courseUnits = courseUnitRepository.findAllByCourseId(request.getCourseId()).stream()
                .map(courseUnit -> {
                    List<Integer> lessonsIds = courseUnit.getLessons().stream()
                            .map(LessonEntity::getLessonId)
                            .sorted()
                            .toList();

                    GetLessonsResponse getLessonsResponse = lessonService.getLessons(GetLessonsRequest.newBuilder()
                            .addAllLessonsIds(lessonsIds)
                            .build());

                    return CourseUnit.newBuilder()
                            .addAllLessons(getLessonsResponse.getLessonsList())
                            .build();
                })
                .toList();

        return GetCourseUnitsResponse.newBuilder()
                .addAllCourseUnits(courseUnits)
                .build();
    }
}
