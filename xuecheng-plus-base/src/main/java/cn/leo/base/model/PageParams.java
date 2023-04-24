package cn.leo.base.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author leo
 * @description 分页查询通用
 */

@Data
@ToString
public class PageParams {


    //当前页码
    private Long pageNo = 1L;

    //每页记录数默认值
    private Long pageSize = 10L;

    public PageParams() {
    }

    public PageParams(Long pageNo, Long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
