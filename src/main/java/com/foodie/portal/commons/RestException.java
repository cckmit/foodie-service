package com.foodie.portal.commons;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper=false)
public class RestException extends RuntimeException {
    private int code;
    private String message;
    private Throwable t;

    public RestException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
