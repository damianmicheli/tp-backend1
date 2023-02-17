package com.dh.g2.web.rest.model.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonRestResponse<T> {
    Boolean success;
    T response;
}
