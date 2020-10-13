package com.mqxu.contentcenter.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author mqxu
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "share")
@ApiModel("分享")
public class Share {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(name = "id",value = "分享id")
    private Integer id;

    /**
     * 发布人id
     */
    @Column(name = "user_id")
    @ApiModelProperty(name = "userId",value = "分享人id")
    private Integer userId;

    /**
     * 标题
     */
    @Column(name = "title")
    @ApiModelProperty(name = "title",value = "分享内容标题")
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "createTime",value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "updateTime",value = "更新时间")
    private Date updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "is_original")
    @ApiModelProperty(name = "isOriginal",value = "是否原创 0：否 1：是")
    private Boolean isOriginal;

    /**
     * 作者
     */
    @Column(name = "author")
    @ApiModelProperty(name = "author",value = "资源作者")
    private String author;

    /**
     * 封面
     */
    @Column(name = "cover")
    @ApiModelProperty(name = "cover",value = "资源封面图URL")
    private String cover;

    /**
     * 概要信息
     */
    @Column(name = "summary")
    @ApiModelProperty(name = "summary",value = "资源摘要")
    private String summary;

    /**
     * 价格（需要的积分）
     */
    @Column(name = "price")
    @ApiModelProperty(name = "price",value = "下载需要的积分")
    private Integer price;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    @ApiModelProperty(name = "downloadUrl",value = "下载地址")
    private String downloadUrl;

    /**
     * 下载数
     */
    @Column(name = "buy_count")
    @ApiModelProperty(name = "buyCount",value = "下载次数")
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    @Column(name = "show_flag")
    @ApiModelProperty(name = "showFlag",value = "是否显示 0：否 1：是")
    private Boolean showFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    @Column(name = "audit_status")
    @ApiModelProperty(name = "auditStatus",value = "审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过")
    private String auditStatus;

    /**
     * 审核不通过原因
     */
    @Column(name = "reason")
    @ApiModelProperty(name = "reason",value = "审核不通过原因")
    private String reason;
}