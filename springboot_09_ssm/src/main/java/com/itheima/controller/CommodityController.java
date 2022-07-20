package com.itheima.controller;

import com.itheima.domain.Commodity;
import com.itheima.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commoditys")
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @PostMapping
    public Result save(@RequestBody Commodity commodity) {
        boolean flag = commodityService.save(commodity);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody Commodity commodity) {
        boolean flag = commodityService.update(commodity);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = commodityService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Commodity commodity = commodityService.getById(id);
        Integer code = commodity != null ? Code.GET_OK : Code.GET_ERR;
        String msg = commodity != null ? "" : "数据查询失败，请重试！";
        return new Result(code,commodity,msg);
    }

    @GetMapping
    public Result getAll() {
        List<Commodity> commodityList = commodityService.getAll();
        Integer code = commodityList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = commodityList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,commodityList,msg);
    }
}
