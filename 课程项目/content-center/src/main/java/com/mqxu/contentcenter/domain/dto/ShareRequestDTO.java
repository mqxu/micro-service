package com.mqxu.contentcenter.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ShareRequestDTO
 * @Description TODO
 * @Author mqxu
 * @Date 2020/10/6
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel("分享信息")
public class ShareRequestDTO {

    @ApiModelProperty(name = "author",value = "作者")
    private String author;

    @ApiModelProperty(name = "downloadUrl",value = "下载地址")
    private String downloadUrl;

    @ApiModelProperty(name = "isOriginal",value = "作者")
    private Boolean isOriginal;

    @ApiModelProperty(name = "price",value = "加个")
    private Integer price;

    @ApiModelProperty(name = "summary",value = "简介")
    private  String summary;

    @ApiModelProperty(name = "title",value = "标题")
    private String title;

}
