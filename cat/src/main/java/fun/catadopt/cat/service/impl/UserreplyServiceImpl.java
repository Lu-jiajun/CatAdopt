package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.UserreplyDao;
import fun.catadopt.cat.entity.UserreplyEntity;
import fun.catadopt.cat.service.UserreplyService;
import fun.catadopt.common.utils.Query;

@Service("userreplyService")
public class UserreplyServiceImpl extends ServiceImpl<UserreplyDao, UserreplyEntity> implements UserreplyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserreplyEntity> page = this.page(
                new Query<UserreplyEntity>().getPage(params),
                new QueryWrapper<UserreplyEntity>()
        );

        return new PageUtils(page);
    }

}