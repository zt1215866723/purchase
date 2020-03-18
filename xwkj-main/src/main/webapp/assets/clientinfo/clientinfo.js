layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Clientinfo = {
        tableId: "clientinfoTable"
    };

    /**
     * 初始化表格的列
     */
    Clientinfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'openID', hide: true, title: ''},
            {field: 'phone', sort: true, title: '电话'},
            {field: 'name', sort: true, title: '姓名'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Clientinfo.search = function () {
        var queryData = {};
        queryData['name'] = $("#name").val();
        table.reload(Clientinfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Clientinfo.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/clientinfo/add',
            tableId: Clientinfo.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Clientinfo.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/clientinfo/edit?id=' + data.id,
            tableId: Clientinfo.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Clientinfo.exportExcel = function () {
        var checkRows = table.checkStatus(Clientinfo.tableId);
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
    Clientinfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/clientinfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Clientinfo.tableId);
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
        elem: '#' + Clientinfo.tableId,
        url: Feng.ctxPath + '/clientinfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Clientinfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Clientinfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Clientinfo.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Clientinfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Clientinfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Clientinfo.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Clientinfo.onDeleteItem(data);
        }else if (layEvent === 'appoint') {
            Clientinfo.onAppointItem(data);
        }
    });
    /**
     * 点击指定销售员
     *
     * @param data 点击按钮时候的行数据
     */
    Clientinfo.onAppointItem = function (data) {
        console.log(data.id)
        func.open({
            title: '制定销售员',
            content: Feng.ctxPath + '/clientinfo/appoint?id=' + data.id,
            tableId: Clientinfo.tableId
        });
    };
});
