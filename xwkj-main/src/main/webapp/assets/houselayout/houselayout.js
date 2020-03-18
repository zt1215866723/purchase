layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 管理
     */
    var Houselayout = {
        tableId: "houselayoutTable"
    };

    /**
     * 初始化表格的列
     */
    Houselayout.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'projectName', sort: true, title: '项目名称'},
            {field: 'layoutName', sort: true, title: '户型名称'},
            {field: 'room', sort: true, title: '房间情况'},
            {field: 'storeyPrice', sort: true, title: '每套价格'},
            {field: 'buildArea', sort: true, title: '建筑面积'},
            {field: 'saleName', sort: true, title: '户型销售状态'},
            {field: 'content', sort: true, title: '户型解析'},
            {field: 'orderNum', hide:true, title: '户型顺序'},
            {field: 'main', sort: true, title: '主力户型',templet:function (d) {
                    var main = "";
                    if (d.isMain == "1") {
                        main = "<font color='red'>主力户型</font>";
                    } else if(d.isMain == "2"){
                        main = "<font >非主力户型</font>";
                    }
                    return main;
                }},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Houselayout.search = function () {
        var queryData = {};
        queryData['layoutName'] = $("#layoutName").val();
        table.reload(Houselayout.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Houselayout.openAddDlg = function () {
        func.open({
            title: '添加',
            content: Feng.ctxPath + '/houselayout/add',
            tableId: Houselayout.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Houselayout.openEditDlg = function (data) {
        func.open({
            title: '修改',
            content: Feng.ctxPath + '/houselayout/edit?id=' + data.id,
            tableId: Houselayout.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Houselayout.exportExcel = function () {
        var checkRows = table.checkStatus(Houselayout.tableId);
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
    Houselayout.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/houselayout/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Houselayout.tableId);
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
        elem: '#' + Houselayout.tableId,
        url: Feng.ctxPath + '/houselayout/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Houselayout.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Houselayout.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Houselayout.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Houselayout.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Houselayout.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Houselayout.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Houselayout.onDeleteItem(data);
        }else if (layEvent === 'upload') {
            Houselayout.openUploadDlg(data);
        }
    });

    /**
     * 点击上传图片
     *
     * @param data 点击按钮时候的行数据
     */
    Houselayout.openUploadDlg = function (data) {
        console.log(data.id)
        func.open({
            title: '上传图片',
            content: Feng.ctxPath + '/houselayout/upload?id=' + data.id,
            tableId: Houselayout.tableId
        });
    };

});
