package fun.catadopt.cat.dao;

import fun.catadopt.cat.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 00:35:50
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
