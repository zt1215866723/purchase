layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Houselayoutimg = {
        tableId: "houselayoutimgTable"
    };

    /**
     * 初始化表格的列
     */
    Houselayoutimg.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'houseLayID', sort: true, title: ''},
            {field: 'imgUrl', sort: true, title: ''},
            {field: 'isMain', sort: true, title: '主图显示在户型列表,默认为0 勾选为1 则主图'},
            {field: 'orderNum', sort: true, title: '某户型中轮播显示户型图的顺序，默认为0，数值越大排前'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Houselayoutimg.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Houselayoutimg.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Houselayoutimg.openAddDlg = function (data) {
        console.log(data)
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/houselayoutimg/add?id=' + data.id,
            tableId: Houselayoutimg.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Houselayoutimg.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/houselayoutimg/edit?id=' + data.id,
            tableId: Houselayoutimg.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Houselayoutimg.exportExcel = function () {
        var checkRows = table.checkStatus(Houselayoutimg.tableId);
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
    Houselayoutimg.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/houselayoutimg/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Houselayoutimg.tableId);
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
        elem: '#' + Houselayoutimg.tableId,
        url: Feng.ctxPath + '/houselayoutimg/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Houselayoutimg.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Houselayoutimg.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Houselayoutimg.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Houselayoutimg.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Houselayoutimg.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Houselayoutimg.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Houselayoutimg.onDeleteItem(data);
        }
    });
});
