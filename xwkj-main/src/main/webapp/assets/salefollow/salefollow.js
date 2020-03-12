layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Salefollow = {
        tableId: "salefollowTable"
    };

    /**
     * 初始化表格的列
     */
    Salefollow.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'salesID', sort: true, title: ''},
            {field: 'clientID', sort: true, title: ''},
            {field: 'followTime', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Salefollow.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Salefollow.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Salefollow.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/salefollow/add',
            tableId: Salefollow.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Salefollow.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/salefollow/edit?id=' + data.id,
            tableId: Salefollow.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Salefollow.exportExcel = function () {
        var checkRows = table.checkStatus(Salefollow.tableId);
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
    Salefollow.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/salefollow/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Salefollow.tableId);
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
        elem: '#' + Salefollow.tableId,
        url: Feng.ctxPath + '/salefollow/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Salefollow.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Salefollow.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Salefollow.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Salefollow.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Salefollow.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Salefollow.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Salefollow.onDeleteItem(data);
        }
    });
});
