package com.itheima.service;

import com.itheima.domain.Commodity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CommodityService {
    /**
     * 保存
     * @param commodity
     * @return
     */
    public boolean save(Commodity commodity);

    /**
     * 修改
     * @param commodity
     * @return
     */
    public boolean update(Commodity commodity);

    /**
     * 按id删除
     * @param id
     * @return
     */
    public boolean delete(Integer id);

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Commodity getById(Integer id);

    /**
     * 查询全部
     * @return
     */
    public List<Commodity> getAll();
}
