package cn.leo.content.api;


import cn.leo.base.model.PageParams;
import cn.leo.base.model.PageResult;
import cn.leo.content.model.dto.QueryCourseParamsDto;
import cn.leo.content.model.po.CourseBase;
import cn.leo.content.service.CourseBaseInfoService;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程信息编辑接口
 */
@RestController
@EnableSwagger2Doc
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParamsDto){
        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParamsDto);

        return courseBasePageResult;
    }
}
