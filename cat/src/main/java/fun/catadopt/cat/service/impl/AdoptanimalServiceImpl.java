package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.AdoptanimalDao;
import fun.catadopt.cat.entity.AdoptanimalEntity;
import fun.catadopt.cat.service.AdoptanimalService;
import fun.catadopt.common.utils.Query;

@Service("adoptanimalService")
public class AdoptanimalServiceImpl extends ServiceImpl<AdoptanimalDao, AdoptanimalEntity> implements AdoptanimalService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdoptanimalEntity> page = this.page(
                new Query<AdoptanimalEntity>().getPage(params),
                new QueryWrapper<AdoptanimalEntity>()
        );

        return new PageUtils(page);
    }

}