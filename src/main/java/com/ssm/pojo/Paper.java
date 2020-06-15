package com.ssm.pojo;

import lombok.Data;

/**
 * @program: netdisc
 * @description:
 * @author: Mr.Gu
 * @create: 2020-06-15 14:52
 **/
@Data
public class Paper {
    private long paperId;
    private String paperName;
    private int paperNum;
    private String paperDetail;

}