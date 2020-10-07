package com.mqxu.contentcenter.controller;

import com.mqxu.contentcenter.domain.dto.ShareDTO;
import com.mqxu.contentcenter.domain.dto.ShareRequestDTO;
import com.mqxu.contentcenter.domain.entity.Share;
import com.mqxu.contentcenter.service.ShareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * @author mqxu
 */
@RestController
@RequestMapping(value = "/shares")
@Api(tags = "分享接口", value = "提供分享相关的Rest API")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {

    private final ShareService shareService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "查询指定id的分享详情", notes = "查询指定id的分享详情")
    public ShareDTO findById(@PathVariable Integer id){
        return this.shareService.findById(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "分享列表", notes = "分享列表")
    public List<Share> query (
            @RequestParam(required = false) String title,
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) Integer userId)  {
        if (pageSize > 100) {
            pageSize = 100;
        }
        return this.shareService.query(title, pageNo, pageSize, userId).getList();
    }


    @PostMapping("/contribute")
    @ApiOperation(value = "投稿", notes = "投稿")
    public int contributeShare(@RequestBody ShareRequestDTO shareRequestDTO){
        return shareService.contribute(shareRequestDTO);
    }


    @GetMapping(value = "/hello")
    @ApiIgnore
    public String getHello()  {
        return this.shareService.getHello();
    }
}
