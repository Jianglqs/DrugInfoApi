package com.api.latticy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.api.latticy.common.constant.IdentityConstant;
import io.github.talelin.core.util.EncryptUtil;
import com.api.latticy.model.UserIdentityDO;
import com.api.latticy.mapper.UserIdentityMapper;
import com.api.latticy.service.UserIdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author pedro@TaleLin
 */
@Service
public class UserIdentityServiceImpl extends ServiceImpl<UserIdentityMapper, UserIdentityDO> implements UserIdentityService {


    @Override
    public UserIdentityDO createIdentity(Long userId, String identityType, String identifier, String credential) {
        UserIdentityDO userIdentity = new UserIdentityDO();
        userIdentity.setUserId(userId);
        userIdentity.setIdentityType(identityType);
        userIdentity.setIdentifier(identifier);
        userIdentity.setCredential(credential);
        return this.createIdentity(userIdentity);
    }

    @Override
    public UserIdentityDO createIdentity(UserIdentityDO userIdentity) {
        this.baseMapper.insert(userIdentity);
        return userIdentity;
    }

    @Override
    public UserIdentityDO createUsernamePasswordIdentity(Long userId, String identifier, String credential) {
        // 密码加密
        credential = EncryptUtil.encrypt(credential);
        return this.createIdentity(userId, IdentityConstant.USERNAME_PASSWORD_IDENTITY, identifier, credential);
    }

    @Override
    public boolean verifyUsernamePassword(Long userId, String username, String password) {
        QueryWrapper<UserIdentityDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserIdentityDO::getUserId, userId)
                .eq(UserIdentityDO::getIdentityType, IdentityConstant.USERNAME_PASSWORD_IDENTITY)
                .eq(UserIdentityDO::getIdentifier, username);
        UserIdentityDO userIdentity = this.baseMapper.selectOne(wrapper);
        return EncryptUtil.verify(userIdentity.getCredential(), password);
    }

    @Override
    public boolean changePassword(Long userId, String password) {
        String encrypted = EncryptUtil.encrypt(password);
        UserIdentityDO userIdentity = UserIdentityDO.builder().credential(encrypted).build();
        QueryWrapper<UserIdentityDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserIdentityDO::getUserId, userId);
        return this.baseMapper.update(userIdentity, wrapper) > 0;
    }

    @Override
    public boolean changeUsername(Long userId, String username) {
        UserIdentityDO userIdentity = UserIdentityDO.builder().identifier(username).build();
        QueryWrapper<UserIdentityDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserIdentityDO::getUserId, userId);
        return this.baseMapper.update(userIdentity, wrapper) > 0;
    }

    @Override
    public boolean changeUsernamePassword(Long userId, String username, String password) {
        UserIdentityDO userIdentity = UserIdentityDO.builder().identifier(username).credential(password).build();
        QueryWrapper<UserIdentityDO> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UserIdentityDO::getUserId, userId);
        return this.baseMapper.update(userIdentity, wrapper) > 0;
    }
}
