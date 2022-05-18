package com.vhs.bts.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackDto {

    private Long id;
    private String title;
    private String address;
    private LocalTime timeOpen;
    private LocalTime timeClose;
    private List<NumberOfLaptopsInStackDto> laptops;

}
