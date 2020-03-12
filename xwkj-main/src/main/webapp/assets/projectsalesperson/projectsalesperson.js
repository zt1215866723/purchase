layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectsalesperson = {
        tableId: "projectsalespersonTable"
    };

    /**
     * 初始化表格的列
     */
    Projectsalesperson.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'projectID', sort: true, title: ''},
            {field: 'salespersonID', sort: true, title: ''},
            {field: 'orderNum', sort: true, title: '默认为0  值越大靠前'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectsalesperson.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectsalesperson.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectsalesperson.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectsalesperson/add',
            tableId: Projectsalesperson.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectsalesperson.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectsalesperson/edit?id=' + data.id,
            tableId: Projectsalesperson.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectsalesperson.exportExcel = function () {
        var checkRows = table.checkStatus(Projectsalesperson.tableId);
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
    Projectsalesperson.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectsalesperson/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectsalesperson.tableId);
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
        elem: '#' + Projectsalesperson.tableId,
        url: Feng.ctxPath + '/projectsalesperson/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectsalesperson.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectsalesperson.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectsalesperson.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectsalesperson.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectsalesperson.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectsalesperson.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectsalesperson.onDeleteItem(data);
        }
    });
});
