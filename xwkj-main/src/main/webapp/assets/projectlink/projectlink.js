layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectlink = {
        tableId: "projectlinkTable"
    };

    /**
     * 初始化表格的列
     */
    Projectlink.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'projectID', sort: true, title: ''},
            {field: 'clientID', sort: true, title: ''},
            {field: 'linkType', sort: true, title: '1 预约登记
            2 变价通知
            3、开盘通知'},
            {field: 'linkTel', sort: true, title: ''},
            {field: 'submitTime', sort: true, title: ''},
            {field: 'isNotice', sort: true, title: '提交后，默认状态为0
            如 预约登记已通知，或变价通知已通知等则状态改为1'},
            {field: 'memo', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectlink.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectlink.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectlink.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectlink/add',
            tableId: Projectlink.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectlink.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectlink/edit?id=' + data.id,
            tableId: Projectlink.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectlink.exportExcel = function () {
        var checkRows = table.checkStatus(Projectlink.tableId);
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
    Projectlink.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectlink/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectlink.tableId);
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
        elem: '#' + Projectlink.tableId,
        url: Feng.ctxPath + '/projectlink/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectlink.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectlink.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectlink.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectlink.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectlink.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectlink.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectlink.onDeleteItem(data);
        }
    });
});
