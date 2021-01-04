package com.newworld.acatorservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.newworld.acatorservice.entity.Acator;
import com.newworld.acatorservice.service.AcatorService;
import com.newworld.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 演员 前端控制器
 * </p>
 *
 * @author newworld
 * @since 2021-01-03
 */
@Api(description = "讲师列表")
@RestController
@RequestMapping("/acatorservice/acator")
public class AcatorController {

    //访问地址，http://localhost:8001/acatorservice/acator/findAll
    @Autowired
    private AcatorService acatorService;

    @ApiOperation(value = "所有演员列表")
    @GetMapping("findAll")
    public R list(){
        List<Acator> list=acatorService.list(null);
        System.out.println(list);
        return R.ok().data("items",list);
    }

    @ApiOperation(value ="新增一个演员" )
    @PutMapping("insert")
    public void insert(){
        Acator acator=new Acator();
        acator.setCareer("nothing");
        acator.setAvator("111111");
        acator.setIntro("ffefe");
        acator.setIsDeleted(true);
        acator.setLevel(1);
        acator.setName("加");
        acator.setSort(1);
        acatorService.save(acator);
    }
    @ApiOperation(value = "删除一个演员")
    @DeleteMapping("{id}")
    public R deleteById(@PathVariable String id)
    {
        boolean flag=acatorService.removeById(id);
        if(flag==true)
         return R.ok();
        else
         return R.error();
    }
    @ApiOperation(value = "演员分页查询")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable long page,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable long limit

    ){
        Page<Acator> acatorPage=new Page<>(page,limit);
        acatorService.page(acatorPage,null);
        List<Acator> acators=acatorPage.getRecords();
        long total=acatorPage.getTotal();
        Map map=new HashMap();
        map.put("total",total);
        map.put("rows",acators);
        return R.ok().data(map);


    }

}

