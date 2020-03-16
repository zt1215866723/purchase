layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Diccontent = {
        tableId: "diccontentTable"
    };

    /**
     * 初始化表格的列
     */
    Diccontent.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'typeID', sort: true, title: ''},
            {field: 'name', sort: true, title: ''},
            {field: 'orderNum', sort: true, title: ''},
            {field: 'memo', sort: true, title: ''},
            {field: 'state', sort: true, title: '0 删除 1正常'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Diccontent.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Diccontent.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Diccontent.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/diccontent/add',
            tableId: Diccontent.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Diccontent.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/diccontent/edit?id=' + data.id,
            tableId: Diccontent.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Diccontent.exportExcel = function () {
        var checkRows = table.checkStatus(Diccontent.tableId);
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
    Diccontent.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/diccontent/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Diccontent.tableId);
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
        elem: '#' + Diccontent.tableId,
        url: Feng.ctxPath + '/diccontent/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Diccontent.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Diccontent.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Diccontent.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Diccontent.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Diccontent.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Diccontent.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Diccontent.onDeleteItem(data);
        }
    });
});
