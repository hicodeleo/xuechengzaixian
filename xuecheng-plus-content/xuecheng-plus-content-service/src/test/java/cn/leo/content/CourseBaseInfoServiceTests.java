package cn.leo.content;

import cn.leo.base.model.PageParams;
import cn.leo.base.model.PageResult;
import cn.leo.content.model.dto.QueryCourseParamsDto;
import cn.leo.content.model.po.CourseBase;
import cn.leo.content.service.CourseBaseInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseBaseInfoServiceTests {


    @Autowired(required = false)
    CourseBaseInfoService courseBaseInfoService;

    @Test
    public void testCourseBaseInfoService(){

        //查询条件
        QueryCourseParamsDto queryCourseParamsDto = new QueryCourseParamsDto();
        queryCourseParamsDto.setCourseName("java");//课程名称查询条件
        queryCourseParamsDto.setAuditStatus("202004");//审核状态查询条件
        queryCourseParamsDto.setPublishStatus("203001");//发布状态查询条件
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(5L);

        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParamsDto);
        System.out.println(courseBasePageResult);
    }
}
