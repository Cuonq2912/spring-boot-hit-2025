package org.example.btvnonline1.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestData<T> {

    RestStatus status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    T message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    T data;

    public RestData(T data){
        this.status = RestStatus.SUCCESS;
        this.data = data;
    }

    public static RestData<?> error(Object message){
        return new RestData<>(RestStatus.ERROR, message, null);
    }
}
