# webcrawler


To execute:
mvn exec:java -D"exec.mainClass"="com.sample.webcrawler.App" -D"exec.args"="sample.com"

Assumptions
================
1) All urls will either start with https://www.<domain> or http://www.<domain> and will be under href
2) All image uris will be under src and start with https://www.<domain> or http://www.<domain>
3) domain argument will always be a .com domain and will be passed as <company>.com with no http/https prefix.
4) Have considered a text/stream already downloaded from a page and parsed and checked for links/urls.
5) To further test with custom html text, copy contents to html.txt and can be tested with domain as argument.


