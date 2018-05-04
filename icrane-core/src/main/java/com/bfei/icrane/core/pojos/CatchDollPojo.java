package com.bfei.icrane.core.pojos;

import com.bfei.icrane.core.models.Vip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatchDollPojo implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private Timestamp catchDate;
    private String videoUrl;
    private String catchContextPath;
    private String catchFileName;
    private Integer dollId;
    private String iconRealPath;
    private String memberID;
    private Vip vip;

}