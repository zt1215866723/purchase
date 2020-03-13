layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectinfo = {
        tableId: "projectinfoTable"
    };

    /**
     * 初始化表格的列
     */
    Projectinfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'areaId', sort: true, title: ''},
            {field: 'name', sort: true, title: ''},
            {field: 'recordName', sort: true, title: ''},
            {field: 'price', sort: true, title: '0 为待定***元/平方米'},
            {field: 'Tel', sort: true, title: ''},
            {field: 'address', sort: true, title: ''},
            {field: 'addrLng', sort: true, title: ''},
            {field: 'addrLat', sort: true, title: ''},
            {field: 'propertyType', sort: true, title: '多选'},
            {field: 'projectAdv', sort: true, title: ''},
            {field: 'buildType', sort: true, title: '多选'},
            {field: 'renovation', sort: true, title: '多选'},
            {field: 'years', sort: true, title: ''},
            {field: 'developer', sort: true, title: ''},
            {field: 'handDate', sort: true, title: ''},
            {field: 'saleStatus', sort: true, title: '在售 待售等'},
            {field: 'openDate', sort: true, title: ''},
            {field: 'saleAddr', sort: true, title: ''},
            {field: 'saleAddrLng', sort: true, title: ''},
            {field: 'saleAddrLat', sort: true, title: ''},
            {field: 'areaCovered', sort: true, title: ''},
            {field: 'buildArea', sort: true, title: ''},
            {field: 'plotRatio', sort: true, title: ''},
            {field: 'greenRate', sort: true, title: ''},
            {field: 'ParkNum', sort: true, title: ''},
            {field: 'floorNum', sort: true, title: ''},
            {field: 'houseNum', sort: true, title: ''},
            {field: 'propertyCorp', sort: true, title: ''},
            {field: 'propertyPrice', sort: true, title: ''},
            {field: 'storeyCon', sort: true, title: ''},
            {field: 'projectIntro', sort: true, title: ''},
            {field: 'projectSpot', sort: true, title: ''},
            {field: 'status', sort: true, title: '1 有效 0删除'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectinfo.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectinfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectinfo.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectinfo/add',
            tableId: Projectinfo.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectinfo.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectinfo/edit?id=' + data.id,
            tableId: Projectinfo.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectinfo.exportExcel = function () {
        var checkRows = table.checkStatus(Projectinfo.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    Projectinfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectinfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectinfo.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Projectinfo.tableId,
        url: Feng.ctxPath + '/projectinfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectinfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectinfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectinfo.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectinfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectinfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectinfo.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectinfo.onDeleteItem(data);
        }
    });
});
