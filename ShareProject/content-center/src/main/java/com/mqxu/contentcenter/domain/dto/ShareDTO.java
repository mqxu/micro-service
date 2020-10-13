package com.mqxu.contentcenter.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mqxu.contentcenter.domain.entity.Share;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author mqxu
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel("分享详情，带发布人昵称")
public class ShareDTO {
//    /**
//     * id
//     */
//    @ApiModelProperty(name = "id",value = "分享id")
//    private Integer id;
//
//    /**
//     * 发布人id
//     */
//    @ApiModelProperty(name = "userId",value = "分享人id")
//    private Integer userId;
//
//    /**
//     * 标题
//     */
//    @ApiModelProperty(name = "title",value = "分享内容标题")
//    private String title;
//
//    /**
//     * 创建时间
//     */
//    @ApiModelProperty(name = "createTime",value = "创建时间")
//    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;
//
//    /**
//     * 修改时间
//     */
//    @ApiModelProperty(name = "updateTime",value = "更新时间")
//    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date updateTime;
//
//    /**
//     * 是否原创 0:否 1:是
//     */
//    @ApiModelProperty(name = "isOriginal",value = "是否原创 0：否 1：是")
//    private Boolean isOriginal;
//
//    /**
//     * 作者
//     */
//    @ApiModelProperty(name = "author",value = "资源作者")
//    private String author;
//
//    /**
//     * 封面
//     */
//    @ApiModelProperty(name = "cover",value = "资源封面图URL")
//    private String cover;
//
//    /**
//     * 概要信息
//     */
//    @ApiModelProperty(name = "summary",value = "资源摘要")
//    private String summary;
//
//    /**
//     * 价格（需要的积分）
//     */
//    @ApiModelProperty(name = "price",value = "下载需要的积分")
//    private Integer price;
//
//    /**
//     * 下载地址
//     */
//    @ApiModelProperty(name = "downloadUrl",value = "下载地址")
//    private String downloadUrl;
//
//    /**
//     * 下载数
//     */
//    @ApiModelProperty(name = "buyCount",value = "下载次数")
//    private Integer buyCount;
//
//    /**
//     * 是否显示 0:否 1:是
//     */
//    @ApiModelProperty(name = "showFlag",value = "是否显示 0：否 1：是")
//    private Boolean showFlag;
//
//    /**
//     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
//     */
//    @ApiModelProperty(name = "auditStatus",value = "审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过")
//    private String auditStatus;
//
//    /**
//     * 审核不通过原因
//     */
//    @ApiModelProperty(name = "reason",value = "审核不通过原因")
//    private String reason;

    @ApiModelProperty(name = "share",value = "分享资源信息")
    private Share share;

    /**
     * 发布人昵称
     */
    @ApiModelProperty(name = "wxNickname",value = "发布人昵称")
    private String wxNickname;
}