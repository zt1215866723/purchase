layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Dictype = {
        tableId: "dictypeTable"
    };

    /**
     * 初始化表格的列
     */
    Dictype.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'dictype', sort: true, title: ''},
            {field: 'memo', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Dictype.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Dictype.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Dictype.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/dictype/add',
            tableId: Dictype.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Dictype.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/dictype/edit?id=' + data.id,
            tableId: Dictype.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Dictype.exportExcel = function () {
        var checkRows = table.checkStatus(Dictype.tableId);
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
    Dictype.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/dictype/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Dictype.tableId);
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
        elem: '#' + Dictype.tableId,
        url: Feng.ctxPath + '/dictype/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Dictype.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Dictype.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Dictype.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Dictype.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Dictype.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Dictype.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Dictype.onDeleteItem(data);
        }
    });
});
