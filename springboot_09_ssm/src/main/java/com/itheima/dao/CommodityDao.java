package com.itheima.dao;

import com.itheima.domain.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommodityDao {
    @Insert("insert into commodity (comName,comDes,comPrice) values(#{comName},#{comDes},#{comPrice})")
    public int save(Commodity commodity);

    @Update("update commodity set comName = #{comName}, comDes = #{comDes}, comPrice = #{comPrice} where comNo = #{comNo}")
    public int update(Commodity commodity);

    @Delete("delete from commodity where comNo = #{id}")
    public int delete(Integer id);

    @Select("select * from commodity where comNo = #{id}")
    public Commodity getById(Integer id);

    @Select("select * from commodity")
    public List<Commodity> getAll();
}
