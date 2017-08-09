package com.cms.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cms.entity.Carousel;
import com.cms.serve.CarouselServe;

public class TestCarousel {

	@Test
	public void test() {
		List<Carousel> sCarousels = new CarouselServe().getCarousels();
		for(Carousel carousel:sCarousels){
			System.out.println(carousel);
		}
	}
	@Test
	public void testUpdate(){
		List<Carousel> sCarousels = new CarouselServe().getCarousels();
		new CarouselServe().editCarousel(sCarousels.get(0));
	}

}
