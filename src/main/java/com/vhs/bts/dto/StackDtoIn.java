package com.vhs.bts.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vhs.bts.entities.StackLaptop;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StackDtoIn {

    private String title;
    private String address;
    private Date dateOpen;
    private Date dateClose;
    private List<StackLaptop> laptops;

}
