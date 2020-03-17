package com.lfxwkj.purchase.modular.api.result;


import com.lfxwkj.purchase.modular.model.result.ProjectimgResult;
import lombok.Data;

import java.util.List;

@Data
public class Projectimglist {

    private String typeName;

    private List<ProjectimgResult> list;

}
