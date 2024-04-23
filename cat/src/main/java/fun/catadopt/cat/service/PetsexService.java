package fun.catadopt.cat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.cat.entity.PetsexEntity;

import java.util.Map;

/**
 * VIEW
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 00:35:50
 */
public interface PetsexService extends IService<PetsexEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

