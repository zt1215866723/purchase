layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 企业的简介管理
     */
    var Companyinfo = {
        tableId: "companyinfoTable"
    };

    /**
     * 初始化表格的列
     */
    Companyinfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'companyName', sort: true, title: ''},
            {field: 'companyDesc', sort: true, title: ''},
            {field: 'creatTime', sort: true, title: ''},
            {field: 'status', sort: true, title: ''},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Companyinfo.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Companyinfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Companyinfo.openAddDlg = function () {
        func.open({
            title: '添加企业的简介',
            content: Feng.ctxPath + '/companyinfo/add',
            tableId: Companyinfo.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Companyinfo.openEditDlg = function (data) {
        func.open({
            title: '修改企业的简介',
            content: Feng.ctxPath + '/companyinfo/edit?id=' + data.id,
            tableId: Companyinfo.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Companyinfo.exportExcel = function () {
        var checkRows = table.checkStatus(Companyinfo.tableId);
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
    Companyinfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/companyinfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Companyinfo.tableId);
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
        elem: '#' + Companyinfo.tableId,
        url: Feng.ctxPath + '/companyinfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Companyinfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Companyinfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Companyinfo.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Companyinfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Companyinfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Companyinfo.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Companyinfo.onDeleteItem(data);
        }
    });
});
