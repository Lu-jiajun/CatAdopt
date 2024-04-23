package fun.catadopt.cat.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.catadopt.cat.entity.VolunteerEntity;
import fun.catadopt.cat.service.VolunteerService;
import fun.catadopt.common.utils.PageUtils;
import fun.catadopt.common.utils.R;



/**
 * VIEW
 *
 * @author lujiajun
 * @email emekaoyenusi@gmail.com
 * @date 2024-04-21 23:30:50
 */
@RestController
@RequestMapping("cat/volunteer")
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = volunteerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
        public R info(@PathVariable("id") Integer id){
		VolunteerEntity volunteer = volunteerService.getById(id);

        return R.ok().put("volunteer", volunteer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
        public R save(@RequestBody VolunteerEntity volunteer){
		volunteerService.save(volunteer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
        public R update(@RequestBody VolunteerEntity volunteer){
		volunteerService.updateById(volunteer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
        public R delete(@RequestBody Integer[] ids){
		volunteerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
