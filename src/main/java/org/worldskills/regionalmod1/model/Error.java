package org.worldskills.regionalmod1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String message;
    private String status;
}
