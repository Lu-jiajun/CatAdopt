package fun.catadopt.cat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.cat.entity.BlogEntity;

import java.util.Map;

/**
 * 
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 00:35:50
 */
public interface BlogService extends IService<BlogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

