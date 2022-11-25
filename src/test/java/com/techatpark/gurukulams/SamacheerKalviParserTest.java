package com.techatpark.javapractice;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class SamacheerKalviParserTest {

    @Test
    void parserNumber() throws IOException {
        SamacheerKalviParser parser = new SamacheerKalviParser();
        File graderFolder = new File("data"+File.separator+"samacheerkalvi");
        graderFolder.mkdirs();

        Files.walk(graderFolder.toPath())
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);

        List<String> subjectUrls = parser.getSubjects();

        subjectUrls.forEach(subjectUrl -> {
            try {
                writeSubject(graderFolder, subjectUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private void writeSubject(File graderFolder, String subjectUrl) throws IOException  {

        SamacheerKalviParser parser = new SamacheerKalviParser();

        String subjectName = subjectUrl.substring(subjectUrl.indexOf("th-")+3,subjectUrl.indexOf("-book"));

        Map<String, List<String>> questions = parser.getQuestionsForSubject(subjectUrl);

        File subjectFolder = new File(graderFolder,subjectName);
        subjectFolder.mkdirs();


        questions.entrySet().forEach(stringListEntry -> {


            File folder = new File(subjectFolder, stringListEntry.getKey());
            folder.mkdirs();

            int i = 1;
            for (String json:
                    stringListEntry.getValue()) {

                File jsonFile =new File(folder, i + ".json");

                try {
                    Files.writeString(jsonFile.toPath(), json);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                i++;
            }

            if( folder.listFiles().length == 0 ) {
                folder.delete();
            } else {
                System.out.println(stringListEntry.getKey());
            }


        });



    }


}