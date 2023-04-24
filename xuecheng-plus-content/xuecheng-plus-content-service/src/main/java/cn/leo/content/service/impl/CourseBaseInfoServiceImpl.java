package cn.leo.content.service.impl;

import cn.leo.base.model.PageParams;
import cn.leo.base.model.PageResult;
import cn.leo.content.mapper.CourseBaseMapper;
import cn.leo.content.model.dto.QueryCourseParamsDto;
import cn.leo.content.model.po.CourseBase;
import cn.leo.content.service.CourseBaseInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    @Autowired
    CourseBaseMapper courseBaseMapper;


    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {

        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        //根据名字模糊查询
        queryWrapper.like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName,queryCourseParamsDto.getCourseName());
        //审核状态精确查询
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus());
        //课程发布状态精确查询
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getPublishStatus()),CourseBase::getStatus,queryCourseParamsDto.getPublishStatus());

        //创建page分页对象，参数="当前页码，每页记录数"
        Page<CourseBase> courseBasePage = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        //根据条件进行分页查询
        courseBaseMapper.selectPage(courseBasePage,queryWrapper);
        //数据列表
        List<CourseBase> items = courseBasePage.getRecords();
        long counts = courseBasePage.getTotal();



        //List<T> items, long counts, long pages, long pageSize
        PageResult<CourseBase> courseBasePageResult = new PageResult<CourseBase>(items,counts, pageParams.getPageNo(), pageParams.getPageSize());
        System.out.println(courseBasePageResult);

        return courseBasePageResult;
    }
}
