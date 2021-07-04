package top.xsliu.detection.dao;

import org.apache.ibatis.annotations.Mapper;
import top.xsliu.detection.model.query.UserParams;
import top.xsliu.detection.entity.User;

import java.util.List;

/**
 * user维度提供的增改查方法
 * @author lxs
 * @description <a href="mailto:xsl2011@outlook.com" />
 * 2021/7/1/1:13 上午
 */
@Mapper
public interface UserMapper {

    int insertUser(User user);

    int updateUserById(User user);

    List<User> queryUserByParams(UserParams userParams);

    User queryUserById(Long userId);

    User queryUserByPhone(String phone);

    User queryUserByEmail(String email);


}
