package com.techatpark.gurukulams.model;

import java.util.List;

public record Question(String question,
                       String explanation,
                       List<Choice> choices,
                       List<String> tags) {
}
