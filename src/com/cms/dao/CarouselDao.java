package com.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cms.entity.Carousel;

public interface CarouselDao {
	@Select("select * from carouselTbl limit 4")
	public List<Carousel> getCarousels();
	@Update("update carouselTbl set imgUrl=#{imgUrl} , hrefUrl=#{hrefUrl} ,desic=#{desic} where id=#{id}")
	public int updateCarouse(Carousel carousel);
}
