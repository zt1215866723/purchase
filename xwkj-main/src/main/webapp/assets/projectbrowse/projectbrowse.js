layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectbrowse = {
        tableId: "projectbrowseTable"
    };

    /**
     * 初始化表格的列
     */
    Projectbrowse.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'clientID', sort: true, title: ''},
            {field: 'projectID', sort: true, title: '楼盘的项目的主键'},
            {field: 'creatTime', sort: true, title: '数据的添加时间'},
            {field: 'isRecom', sort: true, title: '是否已经推荐'},
            {field: 'orderNum', sort: true, title: '数据的状态'},
            {field: 'salesID', sort: true, title: '销售的主键'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectbrowse.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectbrowse.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectbrowse.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectbrowse/add',
            tableId: Projectbrowse.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectbrowse.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectbrowse/edit?id=' + data.id,
            tableId: Projectbrowse.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectbrowse.exportExcel = function () {
        var checkRows = table.checkStatus(Projectbrowse.tableId);
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
    Projectbrowse.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectbrowse/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectbrowse.tableId);
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
        elem: '#' + Projectbrowse.tableId,
        url: Feng.ctxPath + '/projectbrowse/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectbrowse.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectbrowse.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectbrowse.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectbrowse.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectbrowse.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectbrowse.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectbrowse.onDeleteItem(data);
        }
    });
});
