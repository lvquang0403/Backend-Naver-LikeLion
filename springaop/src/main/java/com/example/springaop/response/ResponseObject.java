package com.example.springaop.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class ResponseObject {
    private String status;
    private String message;
    private Object detailData;
}
