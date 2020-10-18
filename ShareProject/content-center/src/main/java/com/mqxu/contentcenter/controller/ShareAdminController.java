package com.mqxu.contentcenter.controller;

import com.mqxu.contentcenter.auth.CheckAuthorization;
import com.mqxu.contentcenter.auth.CheckLogin;
import com.mqxu.contentcenter.domain.dto.ShareAuditDTO;
import com.mqxu.contentcenter.domain.entity.Share;
import com.mqxu.contentcenter.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName ShareAdminController
 * @Description 管理员
 * @Author mqxu
 * @Date 2020/10/6
 **/
@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "管理员接口", value = "提供管理员相关的Rest API")
@Slf4j
public class ShareAdminController {

    private final ShareService shareService;

    @PutMapping(value = "/audit/{id}")
    @CheckAuthorization("admin")
    @ApiOperation(value = "管理员审核分享", notes = "管理员审核分享")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDTO auditDTO) {
        log.info(id + ">>>>>>>>>>>>>" + auditDTO);
        //此处需要认证授权
        return this.shareService.auditById(id, auditDTO);
    }

    @GetMapping(value = "/list")
    @CheckAuthorization("admin")
    @ApiOperation(value = "待审核分享列表", notes = "待审核分享列表")
    public List<Share> getSharesNotYet() {
        return shareService.querySharesNotYet();
    }
}