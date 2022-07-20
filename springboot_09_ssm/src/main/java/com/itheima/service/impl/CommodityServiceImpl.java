package com.itheima.service.impl;

import com.itheima.dao.CommodityDao;
import com.itheima.domain.Commodity;
import com.itheima.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityDao commodityDao;

    @Override
    public boolean save(Commodity commodity) {
        return commodityDao.save(commodity) > 0;
    }

    @Override
    public boolean update(Commodity commodity) {
        return commodityDao.update(commodity) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return commodityDao.delete(id) > 0;
    }

    @Override
    public Commodity getById(Integer id) {
        return commodityDao.getById(id);
    }

    @Override
    public List<Commodity> getAll() {
        return commodityDao.getAll();
    }
}
