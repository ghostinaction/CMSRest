package com.cms.serve;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.cms.dao.CarouselDao;
import com.cms.dao.CompanyInfoDao;
import com.cms.entity.Carousel;
import com.cms.entity.CompanyInfo;
import com.cms.utils.MybatisUtil;

@Service
public class CarouselServe {
	public List<Carousel> getCarousels(){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CarouselDao carouselDao = session.getMapper(CarouselDao.class);
		return carouselDao.getCarousels();
	}
	public int editCarousel(Carousel carousel){
		SqlSession session = MybatisUtil.getSqlSessionFactory().openSession(true);
		CarouselDao carouselDao = session.getMapper(CarouselDao.class);
		return carouselDao.updateCarouse(carousel);
	}
}
