package fun.catadopt.cat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.catadopt.common.utils.PageUtils;

import fun.catadopt.cat.dao.VolunteerDao;
import fun.catadopt.cat.entity.VolunteerEntity;
import fun.catadopt.cat.service.VolunteerService;
import fun.catadopt.common.utils.Query;

@Service("volunteerService")
public class VolunteerServiceImpl extends ServiceImpl<VolunteerDao, VolunteerEntity> implements VolunteerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VolunteerEntity> page = this.page(
                new Query<VolunteerEntity>().getPage(params),
                new QueryWrapper<VolunteerEntity>()
        );

        return new PageUtils(page);
    }

}