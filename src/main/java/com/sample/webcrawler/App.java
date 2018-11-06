package com.sample.webcrawler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.sample.webcrawler.util.FileUtil;

/**
 * App to read html code and identify the hyperlinks for webcrawler to function
 *
 */
public class App 
{
	private static String htmlTextPath = "html.txt";
	private static String outputTextPath = "./urls.txt";
	
    public static void main( String[] args )
    {
        String domain = null;
        
		if(args.length > 0) {
        	domain  = args[0];
        }
        if (domain == null || domain.trim().isEmpty() ) {
        	throw new IllegalArgumentException("domain parameter cannot be empty");
        }        
       
        List<String> text = FileUtil.readInputFile(htmlTextPath);       
        Set<String> webUrls = getUrls(text , domain);
        FileUtil.writeUrlsToFile(webUrls , outputTextPath);    		
        System.out.println("Than you");
    }

    protected static Set<String> getUrls(List<String> inputText, String domain) {
		String urlRegex = "^(href|src)=\"(https|http)://www." + domain;
        Predicate<String> websiteFilter = Pattern
        		.compile(urlRegex).asPredicate();
        
        List<String> noSpaceLines = new ArrayList<>();
        inputText.forEach(t -> noSpaceLines.addAll(Arrays.asList(t.split("\\s+"))));
        
        Set<String> webUrls = noSpaceLines.stream()
        		.filter(websiteFilter)
        		.map(s -> s.substring(s.indexOf("\"")+1, s.lastIndexOf("\"")))
        		.collect(Collectors.<String>toSet());
        
		return webUrls;
		
	}
}
