package com.demo.repo;

import com.demo.model.TinyUrl;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TinyUrlRepository {

	private List<TinyUrl> tinyUrlList = null;


	public TinyUrlRepository() {
		tinyUrlList = new ArrayList<TinyUrl>();
		tinyUrlList.add(new TinyUrl("https://www.energyworx.com/", "ewx123"));
	}

	public String create(TinyUrl tinyUrl) {
		return this.getRandomGenerator();
	}

	public String get(String shortcode) {
		return this.searchList(shortcode);
	}

	private String searchList(String shortcode) {
		TinyUrl tinyUrl = null;
		for (TinyUrl t : tinyUrlList) {
			if (t.getShortcode().equals(shortcode)) {
				tinyUrl = t;
				break;
			}
		}
		return tinyUrl != null ? tinyUrl.getUrl() : null;
	}

	private String getRandomGenerator() {

		String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String underscore="_";

		String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase + numbers + underscore;
		StringBuilder randomString = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			int randomIndex = (int) (Math.random() * allCharacters.length());
			randomString.append(allCharacters.charAt(randomIndex));
		}
		return randomString.toString();
	}
}


