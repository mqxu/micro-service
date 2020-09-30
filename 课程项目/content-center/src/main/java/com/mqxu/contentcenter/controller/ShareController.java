package com.mqxu.contentcenter.controller;

import com.mqxu.contentcenter.common.ResponseResult;
import com.mqxu.contentcenter.domain.dto.ShareDTO;
import com.mqxu.contentcenter.service.ShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author mqxu
 */
@RestController
@RequestMapping(value =  "/shares")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;

    @GetMapping(value = "/{id}")
    public ResponseResult findById(@PathVariable Integer id) {
        return new ResponseResult(200,"请求成功",this.shareService.findById(id));
    }

    @GetMapping(value = "/hello")
    public String getHello(){
        return this.shareService.getHello();
    }
}
