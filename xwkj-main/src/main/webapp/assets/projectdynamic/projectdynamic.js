layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectdynamic = {
        tableId: "projectdynamicTable"
    };

    /**
     * 初始化表格的列
     */
    Projectdynamic.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'projectId', sort: true, title: ''},
            {field: 'dynamicType', sort: true, title: '预售证、开盘、交房等'},
            {field: 'title', sort: true, title: ''},
            {field: 'dynamicDate', sort: true, title: ''},
            {field: 'content', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectdynamic.search = function () {
        var queryData = {};
        queryData['title'] = $("#title").val();
        table.reload(Projectdynamic.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectdynamic.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectdynamic/add',
            tableId: Projectdynamic.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectdynamic.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectdynamic/edit?id=' + data.id,
            tableId: Projectdynamic.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectdynamic.exportExcel = function () {
        var checkRows = table.checkStatus(Projectdynamic.tableId);
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
    Projectdynamic.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectdynamic/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectdynamic.tableId);
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
        elem: '#' + Projectdynamic.tableId,
        url: Feng.ctxPath + '/projectdynamic/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectdynamic.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectdynamic.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectdynamic.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectdynamic.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectdynamic.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectdynamic.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectdynamic.onDeleteItem(data);
        }
    });
});
