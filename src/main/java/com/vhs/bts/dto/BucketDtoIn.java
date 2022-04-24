package com.vhs.bts.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BucketDtoIn {
    private List<Long> laptopsId;
    private Long userId;
}
