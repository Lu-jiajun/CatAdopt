package fun.catadopt.cat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.cat.entity.UserreplyEntity;

import java.util.Map;

/**
 * VIEW
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 00:35:56
 */
public interface UserreplyService extends IService<UserreplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

