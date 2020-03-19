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
            {field: 'infoType', sort: true, title: '文章类型',templet:function (d) {
                    var state ="";
                    if (d.infoType == '1') {
                        state ="公司新闻";
                    } else if (d.infoType == '2') {
                        state ="公告";
                    } else if (d.infoType == '3') {
                        state ="项目新闻";
                    } else if (d.infoType == '4') {
                        state ="公司介绍";
                    } else if (d.infoType == '5') {
                        state ="轮播图";
                    }
                    return state;
                }},
            {field: 'projectName', sort: true, title: '项目名称'},
            {field: 'title', sort: true, title: '信息标题'},
            {field: 'listTitle', sort: true, title: '列表标题'},
            {field: 'listPicUrl', sort: true, title: '列表图片'},
            {field: 'tagLabel', sort: true, title: 'tag标签'},
            {field: 'abstract', sort: true, title: '摘要'},
            {field: 'topLevel', sort: true, title: '消息置顶级别，默认为0，值越大，越靠前。后台、前台该类信息显示，根据固顶级别 、发布时间  降序进行排序显示'},
            {field: 'topTime', sort: true, title: 'top时间'},
            {field: 'content', sort: true, title: '内容'},
            {field: 'createTime', sort: true, title: '发布时间'},
            {field: 'createUserId', sort: true, title: '发布人'},
            {field: 'status', sort: true, title: '文章状态',templet:function (d) {
                    var state ="";
                    if (d.status == '0') {
                        state ="删除";
                    } else if (d.status == '1') {
                        state ="发布";
                    } else if (d.status == '2') {
                        state ="暂存";
                    }
                    return state;
                }},
            {field: 'readNum', sort: true, title: '阅读数'},
            {field: 'goodNum', sort: true, title: '点赞数'},
            {field: 'isPlay', sort: true, title: '是否轮播'},
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
