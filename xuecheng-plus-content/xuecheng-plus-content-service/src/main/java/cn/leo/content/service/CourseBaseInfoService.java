package cn.leo.content.service;

import cn.leo.base.model.PageParams;
import cn.leo.base.model.PageResult;
import cn.leo.content.model.dto.QueryCourseParamsDto;
import cn.leo.content.model.po.CourseBase;

/**
 * 课程信息管理接口
 */
public interface CourseBaseInfoService {

    /**
     * 课程分页查询
     */
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);
}
