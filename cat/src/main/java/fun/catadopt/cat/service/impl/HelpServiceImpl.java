package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.HelpDao;
import fun.catadopt.cat.entity.HelpEntity;
import fun.catadopt.cat.service.HelpService;
import fun.catadopt.common.utils.Query;

@Service("helpService")
public class HelpServiceImpl extends ServiceImpl<HelpDao, HelpEntity> implements HelpService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<HelpEntity> page = this.page(
                new Query<HelpEntity>().getPage(params),
                new QueryWrapper<HelpEntity>()
        );

        return new PageUtils(page);
    }

}