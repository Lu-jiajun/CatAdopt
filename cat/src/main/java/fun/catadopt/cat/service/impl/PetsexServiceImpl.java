package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.PetsexDao;
import fun.catadopt.cat.entity.PetsexEntity;
import fun.catadopt.cat.service.PetsexService;
import fun.catadopt.common.utils.Query;

@Service("petsexService")
public class PetsexServiceImpl extends ServiceImpl<PetsexDao, PetsexEntity> implements PetsexService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PetsexEntity> page = this.page(
                new Query<PetsexEntity>().getPage(params),
                new QueryWrapper<PetsexEntity>()
        );

        return new PageUtils(page);
    }

}