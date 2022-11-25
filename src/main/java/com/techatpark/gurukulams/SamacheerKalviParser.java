package com.techatpark.gurukulams;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.*;

public class SamacheerKalviParser {

    public List<String> getSubjects() throws IOException {

        Document doc = Jsoup.connect("https://samacheerkalvi.guru/samacheer-kalvi-12th-books-solutions/").get();

        Elements headlines = doc.select("div.entry-content > ul > li > a");
        List<String> urls = new ArrayList<>(headlines.size());
        for (Element headline : headlines) {
            if(headline.absUrl("href").endsWith("solutions/")) {

                System.out.println(headline.text());

                urls.add(headline.absUrl("href"));
            }
        }
        return urls;
    }

    /**
     * Gets Questions.
     * @return Byte, Short, Integer, Long or BigInteger
     */
    public Map<String,List<String>> getQuestionsForSubject(String subjectUrl) throws IOException {
        Map<String,List<String>> c = new HashMap();

        Document doc = Jsoup.connect(subjectUrl).get();

        Elements paragraphs = doc.select("div.entry-content > ul > li > a");

        for (Element headline : paragraphs) {

            String chapterName = headline.attr("title")
                    .split("Chapter ")[1]
                    .replaceAll(" ","-")
                    .toLowerCase();
            chapterName = chapterName.substring(chapterName.indexOf('-')+1);
            c.put(chapterName, getQuestionsForChapter(headline.absUrl("href")));

        }

        return c;
    }

    private List<String> getQuestionsForChapter(String chapterUrl) throws IOException{

        JsonFactory factory = new JsonFactory();

        Document doc = Jsoup.connect(chapterUrl).get();

        Elements paragraphs = doc.select(" div.entry-content > p");

        List<String> questionJSONs = new ArrayList<>(paragraphs.size());

        for (Element paragraph : paragraphs) {
            String content = paragraph.toString();
            if(content.startsWith("<p>Question")
                    && content.contains("(a)")
                    && !content.contains("<img")) {

                List<String> tokens = new ArrayList<>(List.of(content.split("<br> ")));
                if(tokens.size() == 8
                && tokens.get(2).contains(")")) {
                    tokens.remove(0);
                    StringWriter jsonObjectWriter = new StringWriter();
                    JsonGenerator generator = factory.createGenerator(jsonObjectWriter);
                    generator.useDefaultPrettyPrinter(); // pretty print JSON
                    generator.writeStartObject();
                    generator.writeFieldName("question");
                    generator.writeString(tokens.get(0));

                    generator.writeFieldName("explanation");
                    generator.writeString("");

                    generator.writeFieldName("choices");
                    generator.writeStartArray();

                    generator.writeStartObject();
                    generator.writeFieldName("value");
                    generator.writeString(getAnswerValue(tokens.get(1)));
                    if(tokens.get(6).contains(tokens.get(1))) {
                        generator.writeFieldName("answer");
                        generator.writeBoolean(true);
                    }
                    generator.writeEndObject();

                    generator.writeStartObject();
                    generator.writeFieldName("value");
                    generator.writeString(getAnswerValue(tokens.get(2)));
                    if(tokens.get(6).contains(tokens.get(2))) {
                        generator.writeFieldName("answer");
                        generator.writeBoolean(true);
                    }
                    generator.writeEndObject();

                    generator.writeStartObject();
                    generator.writeFieldName("value");
                    generator.writeString(getAnswerValue(tokens.get(3)));
                    if(tokens.get(6).contains(tokens.get(3))) {
                        generator.writeFieldName("answer");
                        generator.writeBoolean(true);
                    }
                    generator.writeEndObject();

                    generator.writeStartObject();
                    generator.writeFieldName("value");
                    generator.writeString(getAnswerValue(tokens.get(4)));
                    if(tokens.get(6).contains(tokens.get(4))) {
                        generator.writeFieldName("answer");
                        generator.writeBoolean(true);
                    }
                    generator.writeEndObject();

                    generator.writeEndArray();

                    generator.writeEndObject();
                    generator.close();
                    questionJSONs.add(jsonObjectWriter.toString());
                }
            }

        }
        return questionJSONs;
    }

    private String getAnswerValue(final String ansText) {
        try {
            return ansText.split("\\)")[1].trim();
        } catch (ArrayIndexOutOfBoundsException w) {
            return ansText.trim();
        }

    }

}
