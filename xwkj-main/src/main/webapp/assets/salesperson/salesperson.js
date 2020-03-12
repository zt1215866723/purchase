layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Salesperson = {
        tableId: "salespersonTable"
    };

    /**
     * 初始化表格的列
     */
    Salesperson.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'name', sort: true, title: ''},
            {field: 'picUrl', sort: true, title: ''},
            {field: 'tel', sort: true, title: ''},
            {field: 'weChatNo', sort: true, title: ''},
            {field: 'QRCodeUrl', sort: true, title: ''},
            {field: 'goodNum', sort: true, title: ''},
            {field: 'serviceNum', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Salesperson.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Salesperson.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Salesperson.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/salesperson/add',
            tableId: Salesperson.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Salesperson.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/salesperson/edit?id=' + data.id,
            tableId: Salesperson.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Salesperson.exportExcel = function () {
        var checkRows = table.checkStatus(Salesperson.tableId);
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
    Salesperson.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/salesperson/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Salesperson.tableId);
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
        elem: '#' + Salesperson.tableId,
        url: Feng.ctxPath + '/salesperson/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Salesperson.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Salesperson.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Salesperson.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Salesperson.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Salesperson.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Salesperson.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Salesperson.onDeleteItem(data);
        }
    });
});
