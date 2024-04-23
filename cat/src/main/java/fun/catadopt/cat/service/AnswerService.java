package fun.catadopt.cat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.cat.entity.AnswerEntity;

import java.util.Map;

/**
 * 
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 00:35:50
 */
public interface AnswerService extends IService<AnswerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

