layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectambitus = {
        tableId: "projectambitusTable"
    };

    /**
     * 初始化表格的列
     */
    Projectambitus.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'projectID', sort: true, title: ''},
            {field: 'ambitusType', sort: true, title: '如 交通、学校、医疗、购物等'},
            {field: 'name', sort: true, title: ''},
            {field: 'distance', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectambitus.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectambitus.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectambitus.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectambitus/add',
            tableId: Projectambitus.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectambitus.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectambitus/edit?id=' + data.id,
            tableId: Projectambitus.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectambitus.exportExcel = function () {
        var checkRows = table.checkStatus(Projectambitus.tableId);
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
    Projectambitus.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectambitus/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectambitus.tableId);
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
        elem: '#' + Projectambitus.tableId,
        url: Feng.ctxPath + '/projectambitus/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectambitus.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectambitus.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectambitus.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectambitus.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectambitus.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectambitus.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectambitus.onDeleteItem(data);
        }
    });
});
