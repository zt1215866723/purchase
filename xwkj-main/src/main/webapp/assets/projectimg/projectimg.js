layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Projectimg = {
        tableId: "projectimgTable"
    };

    /**
     * 初始化表格的列
     */
    Projectimg.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'projectID', sort: true, title: ''},
            {field: 'imgType', sort: true, title: '1 图片 2 视频 3全景'},
            {field: 'imgClass', sort: true, title: '效果图、配套图、实景图等'},
            {field: 'imgUrl', sort: true, title: ''},
            {field: 'orderNum', sort: true, title: '默认为0   值越大越靠前'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Projectimg.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Projectimg.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Projectimg.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/projectimg/add',
            tableId: Projectimg.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Projectimg.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/projectimg/edit?id=' + data.id,
            tableId: Projectimg.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Projectimg.exportExcel = function () {
        var checkRows = table.checkStatus(Projectimg.tableId);
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
    Projectimg.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/projectimg/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Projectimg.tableId);
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
        elem: '#' + Projectimg.tableId,
        url: Feng.ctxPath + '/projectimg/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Projectimg.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Projectimg.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Projectimg.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Projectimg.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Projectimg.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Projectimg.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Projectimg.onDeleteItem(data);
        }
    });
});
