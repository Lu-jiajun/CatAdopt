package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.AdminsDao;
import fun.catadopt.cat.entity.AdminsEntity;
import fun.catadopt.cat.service.AdminsService;
import fun.catadopt.common.utils.Query;


@Service("adminsService")
public class AdminsServiceImpl extends ServiceImpl<AdminsDao, AdminsEntity> implements AdminsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AdminsEntity> page = this.page(
                new Query<AdminsEntity>().getPage(params),
                new QueryWrapper<AdminsEntity>()
        );

        return new PageUtils(page);
    }

}