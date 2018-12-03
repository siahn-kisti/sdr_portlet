package com.sdr.carousel.util;

import java.util.Comparator;

import com.sdr.carousel.model.Slide;

public class OrderComparator implements Comparator<Slide> {

		public int compare(Slide slide1, Slide slide2) {

				if (slide1.getOrder() < slide2.getOrder()) {
						return -1;
				}
				else if (slide1.getOrder() > slide2.getOrder()) {
						return 1;
				}
				else
						return 0;
		}

}
