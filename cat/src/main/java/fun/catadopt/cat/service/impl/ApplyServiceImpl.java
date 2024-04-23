package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.ApplyDao;
import fun.catadopt.cat.entity.ApplyEntity;
import fun.catadopt.cat.service.ApplyService;
import fun.catadopt.common.utils.Query;

@Service("applyService")
public class ApplyServiceImpl extends ServiceImpl<ApplyDao, ApplyEntity> implements ApplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ApplyEntity> page = this.page(
                new Query<ApplyEntity>().getPage(params),
                new QueryWrapper<ApplyEntity>()
        );

        return new PageUtils(page);
    }

}