package cn.leo.content;

import cn.leo.base.model.PageParams;
import cn.leo.base.model.PageResult;
import cn.leo.content.mapper.CourseBaseMapper;
import cn.leo.content.model.dto.QueryCourseParamsDto;
import cn.leo.content.model.po.CourseBase;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseBaseMapperTests {


    @Autowired(required = false)
    CourseBaseMapper courseBaseMapper;

    @Test
    public void testCourseBaseMapper(){
        CourseBase courseBase = courseBaseMapper.selectById(74);
        Assertions.assertNotNull(courseBase);

        //查询条件
        QueryCourseParamsDto queryCourseParamsDto = new QueryCourseParamsDto();
        queryCourseParamsDto.setCourseName("java");//课程名称查询条件

        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        //根据名字模糊查询
        queryWrapper.like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName,queryCourseParamsDto.getCourseName());
        //审核状态精确查询
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus());


        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(5L);
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
    }
}
