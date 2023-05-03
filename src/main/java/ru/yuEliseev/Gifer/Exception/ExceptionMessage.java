package ru.yuEliseev.Gifer.Exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionMessage {
    private String msg;
    private int status;
    private String response_id;
    private int error_code;
}
