package com.mwz.v1.service.impl;

import com.mwz.v1.entity.User;
import com.mwz.v1.mapper.UserMapper;
import com.mwz.v1.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mwz
 * @since 2020-02-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
