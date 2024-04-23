package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.AnswerDao;
import fun.catadopt.cat.entity.AnswerEntity;
import fun.catadopt.cat.service.AnswerService;
import fun.catadopt.common.utils.Query;

@Service("answerService")
public class AnswerServiceImpl extends ServiceImpl<AnswerDao, AnswerEntity> implements AnswerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AnswerEntity> page = this.page(
                new Query<AnswerEntity>().getPage(params),
                new QueryWrapper<AnswerEntity>()
        );

        return new PageUtils(page);
    }

}