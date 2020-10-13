package com.mqxu.contentcenter.controller;

import com.mqxu.contentcenter.auth.CheckAuthorization;
import com.mqxu.contentcenter.domain.dto.ShareAuditDTO;
import com.mqxu.contentcenter.domain.entity.Share;
import com.mqxu.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ShareAdminController
 * @Description 管理员
 * @Author mqxu
 * @Date 2020/10/6
 **/
@RestController
@RequestMapping("/admin/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareAdminController {

    private final ShareService shareService;

    @PutMapping(value = "/audit/{id}")
    @CheckAuthorization("admin")
    public Share auditById(@PathVariable Integer id, @RequestBody ShareAuditDTO auditDTO) {
        //此处需要认证授权
        return this.shareService.auditById(id, auditDTO);
    }
}