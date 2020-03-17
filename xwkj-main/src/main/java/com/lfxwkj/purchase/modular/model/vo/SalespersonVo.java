package com.lfxwkj.purchase.modular.model.vo;

import com.lfxwkj.purchase.modular.entity.Salesperson;
import com.lfxwkj.purchase.modular.model.result.ProjectinfoResult;
import lombok.Data;

import java.util.List;

@Data
public class SalespersonVo extends Salesperson {

    List<ProjectinfoResult> projectInfo;

    List<SaleFollowVo> serviceTrajectory;
}
