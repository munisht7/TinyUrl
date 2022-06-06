package com.demo.repo;


import com.demo.model.TinyUrlStats;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TinyUrlStatsRepository {

	private List<TinyUrlStats> tinyUrlStatsList = null;

	public TinyUrlStatsRepository() {
		tinyUrlStatsList = new ArrayList<TinyUrlStats>();
		tinyUrlStatsList.add(new TinyUrlStats("https://www.energyworx.com/", "ewx123", "2017-05-10T20:45:00.000Z", "2018-05-16T10:16:24.666Z", "6"));
	}


	public TinyUrlStats getStats(String shortcode) {
		return this.searchListWithStats(shortcode);
	}

	private TinyUrlStats searchListWithStats(String shortcode) {
		TinyUrlStats tinyUrlStats = null;
		for (TinyUrlStats t : tinyUrlStatsList) {
			if (t.getShortcode().equals(shortcode)) {
				tinyUrlStats = t;
				break;
			}
		}
		return tinyUrlStats;
	}

}
