package com.chandrashekhar.hotelManagement.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomResponse {
    private Integer status;
    private String message;
    private Object data;
    private Long totalElements;
    private Integer currentPageSize;
    private Integer currentNumber;
    private Integer itemPerPage;

    public CustomResponse(Integer status ,String message ,Object data){
        this.status=status;
        this.message=message;
        this.data=data;

    }


}
