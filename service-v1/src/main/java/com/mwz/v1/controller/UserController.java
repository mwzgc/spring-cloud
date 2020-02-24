package com.mwz.v1.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mwz.v1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mwz
 * @since 2020-02-24
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private IUserService IUserService;


    @GetMapping("/list")
    public ResponseEntity<Object> list() {
        return new ResponseEntity<>(IUserService.list(), HttpStatus.OK);
    }

}
