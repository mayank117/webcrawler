package com.sample.webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidArgs() {
		String[] args = {""};
		App.main(args);
	}
	
	@Test
	public void testGetUrlsFound() {
		List<String> inputLines = new ArrayList<>();
		inputLines.add("<link rel=\"alternate\" href=\"https://www.sample.com/en-UKI/\" hreflang=\"en-uk\"/>\r\n" );
		inputLines.add(" <img data-toggle=\"modal\" data-target=\"#favourite-articles\" src=\"https://www.sample.com/etc/designs/nexus/images/header/heart.png\" alt=\"\"/>");
		Set<String> urls = App.getUrls(inputLines, "sample.com");
		Assert.assertEquals(urls.size(), 2);
	}
	
	@Test
	public void testGetUrlsNotFound() {
		List<String> inputLines = new ArrayList<>();
		inputLines.add("<link rel=\"alternate\" href=\"https://www.sample.com/en-UKI/\" hreflang=\"en-uk\"/>\r\n" );
		inputLines.add(" <img data-toggle=\"modal\" data-target=\"#favourite-articles\" src=\"https://www.sample.com/etc/designs/nexus/images/header/heart.png\" alt=\"\"/>");
		Set<String> urls = App.getUrls(inputLines, "junk.com");
		Assert.assertEquals(urls.size(),0 );
	}
	
	
}
