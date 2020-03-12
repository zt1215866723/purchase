layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 项目所属区域管理
     */
    var Projectarea = {
        tableId: "projectareaTable"
    };

    /**
     * 初始化表格的列
     */
    Projectarea.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'areaType', sort: true, title: '1 国内
            2 国外'},
            {field: 'areaName', sort: true, title: ''},
            {field: 'areaLatter', sort: true, title: ''},
            {field: 'status', sort: true, title: '1启用
            0停用'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectarea.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectarea.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectarea.openAddDlg = function () {
        func.open({
            title: '添加项目所属区域',
            content: Feng.ctxPath + '/projectarea/add',
            tableId: Projectarea.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectarea.openEditDlg = function (data) {
        func.open({
            title: '修改项目所属区域',
            content: Feng.ctxPath + '/projectarea/edit?id=' + data.id,
            tableId: Projectarea.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectarea.exportExcel = function () {
        var checkRows = table.checkStatus(Projectarea.tableId);
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
    Projectarea.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectarea/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectarea.tableId);
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
        elem: '#' + Projectarea.tableId,
        url: Feng.ctxPath + '/projectarea/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectarea.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectarea.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectarea.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectarea.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectarea.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectarea.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectarea.onDeleteItem(data);
        }
    });
});
