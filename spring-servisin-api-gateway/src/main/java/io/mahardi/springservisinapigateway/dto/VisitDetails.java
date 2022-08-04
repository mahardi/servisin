package io.mahardi.springservisinapigateway.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VisitDetails {
    private Integer id = null;
    private Integer carId = null;
    private String date = null;
    private String description = null;
}
