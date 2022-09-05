package com.jcs.education.course.unit.service.api;

import com.jcs.education.course.unit.service.proto.v1.EducationCourseUnitServiceGrpc;
import com.jcs.education.course.unit.service.proto.v1.GetCourseUnitsRequest;
import com.jcs.education.course.unit.service.proto.v1.GetCourseUnitsResponse;
import com.jcs.education.course.unit.service.service.CourseUnitService;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EducationCourseUnitServiceRpc extends EducationCourseUnitServiceGrpc.EducationCourseUnitServiceImplBase {
    CourseUnitService courseUnitService;

    @Override
    public void getCourseUnits(GetCourseUnitsRequest request, StreamObserver<GetCourseUnitsResponse> responseObserver) {
        GetCourseUnitsResponse response = courseUnitService.getCourseUnits(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
