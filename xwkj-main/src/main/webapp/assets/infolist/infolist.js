layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 存储新闻、公告等信息管理
     */
    var Infolist = {
        tableId: "infolistTable"
    };

    /**
     * 初始化表格的列
     */
    Infolist.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: ''},
            {field: 'infoType', sort: true, title: '1、新闻
            2、公告
            3、项目新闻'},
            {field: 'projectID', sort: true, title: ''},
            {field: 'title', sort: true, title: ''},
            {field: 'listTitle', sort: true, title: ''},
            {field: 'listPicUrl', sort: true, title: ''},
            {field: 'tagLabel', sort: true, title: ''},
            {field: 'abstract', sort: true, title: ''},
            {field: 'topLevel', sort: true, title: '消息置顶级别，默认为0，值越大，越靠前。后台、前台该类信息显示，根据固顶级别 、发布时间  降序进行排序显示'},
            {field: 'topTime', sort: true, title: ''},
            {field: 'content', sort: true, title: ''},
            {field: 'createTime', sort: true, title: ''},
            {field: 'createUserId', sort: true, title: ''},
            {field: 'status', sort: true, title: '0 删除 1发布 2暂存'},
            {field: 'readNum', sort: true, title: ''},
            {field: 'goodNum', sort: true, title: ''},
            {field: 'isPlay', sort: true, title: '默认值0  不轮播，1则轮播显示。（注：轮播默认显示状态为1的前几个）'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    Infolist.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(Infolist.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    Infolist.openAddDlg = function () {
        func.open({
            title: '添加存储新闻、公告等信息',
            content: Feng.ctxPath + '/infolist/add',
            tableId: Infolist.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    Infolist.openEditDlg = function (data) {
        func.open({
            title: '修改存储新闻、公告等信息',
            content: Feng.ctxPath + '/infolist/edit?id=' + data.id,
            tableId: Infolist.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    Infolist.exportExcel = function () {
        var checkRows = table.checkStatus(Infolist.tableId);
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
    Infolist.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/infolist/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(Infolist.tableId);
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
        elem: '#' + Infolist.tableId,
        url: Feng.ctxPath + '/infolist/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: Infolist.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Infolist.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Infolist.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Infolist.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + Infolist.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            Infolist.openEditDlg(data);
        } else if (layEvent === 'delete') {
            Infolist.onDeleteItem(data);
        }
    });
});
