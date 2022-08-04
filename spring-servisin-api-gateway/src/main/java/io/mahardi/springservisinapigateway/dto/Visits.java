package io.mahardi.springservisinapigateway.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Value;

@Value
public class Visits {
    private List<VisitDetails> items = new ArrayList<>();
}
