package com.mqxu.contentcenter.controller;

import com.mqxu.contentcenter.auth.CheckLogin;
import com.mqxu.contentcenter.domain.dto.ExchangeDTO;
import com.mqxu.contentcenter.domain.dto.ShareDTO;
import com.mqxu.contentcenter.domain.dto.ShareRequestDTO;
import com.mqxu.contentcenter.domain.entity.Share;
import com.mqxu.contentcenter.service.ShareService;
import com.mqxu.contentcenter.utils.JwtOperator;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @description: UserController
 * @author: mqxu
 * @create: 2020-10-12
 **/
@RestController
@RequestMapping(value = "/shares")
@Api(tags = "分享接口", value = "提供分享相关的Rest API")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareController {
    private final ShareService shareService;
    private final JwtOperator jwtOperator;
    private final int MAX = 100;

    @GetMapping(value = "/{id}")
    @CheckLogin
    @ApiOperation(value = "查询指定id的分享详情", notes = "查询指定id的分享详情")
    public ShareDTO findById(@PathVariable Integer id) {
        return this.shareService.findById(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "分享列表", notes = "分享列表")
    public List<Share> query(
            @RequestParam(required = false) String title,
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestHeader(value = "X-Token", required = false) String token) {
        if (pageSize > MAX) {
            pageSize = MAX;
        }
        int userId = getUserIdFromToken(token);
        return this.shareService.query(title, pageNo, pageSize, userId).getList();
    }


    @PostMapping("/contribute")
    @CheckLogin
    @ApiOperation(value = "投稿", notes = "投稿")
    public int contributeShare(@RequestBody ShareRequestDTO shareRequestDTO, @RequestHeader(value = "X-Token", required = false) String token) {
        log.info(shareRequestDTO + ">>>>>>>>>>>>");
        int userId = getUserIdFromToken(token);
        shareRequestDTO.setUserId(userId);
        return shareService.contribute(shareRequestDTO);
    }

    @PostMapping("/exchange")
    @CheckLogin
    @ApiOperation(value = "兑换分享", notes = "兑换分享")
    public Share exchange(@RequestBody ExchangeDTO exchangeDTO) {
        log.info(exchangeDTO + ">>>>>>>>>>>>");
        return this.shareService.exchange(exchangeDTO);
    }

    @GetMapping("/my-exchange")
    @CheckLogin
    @ApiOperation(value = "我的兑换", notes = "我的兑换")
    public List<Share> myExchange(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestHeader(value = "X-Token", required = false) String token) {
        if (pageSize > MAX) {
            pageSize = MAX;
        }
        int userId = getUserIdFromToken(token);
        return this.shareService.myExchange(pageNo, pageSize, userId).getList();
    }


    @GetMapping("/my-contribute")
    @CheckLogin
    @ApiOperation(value = "我的投稿", notes = "我的投稿")
    public List<Share> myContribute(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize,
            @RequestHeader(value = "X-Token", required = false) String token) {
        if (pageSize > MAX) {
            pageSize = MAX;
        }
        int userId = getUserIdFromToken(token);
        return this.shareService.myContribute(pageNo, pageSize, userId).getList();
    }


    /**
     * 封装一个从token中提取userId的方法
     *
     * @param token
     * @return userId
     */
    private int getUserIdFromToken(String token) {
        log.info(">>>>>>>>>>>token" + token);
        int userId = 0;
        String noToken = "no-token";
        if (!noToken.equals(token)) {
            Claims claims = this.jwtOperator.getClaimsFromToken(token);
            log.info(claims.toString());
            userId = (Integer) claims.get("id");
        } else {
            log.info("没有token");
        }
        return userId;
    }
}
