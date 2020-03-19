/**
 * 添加或者修改页面
 */
var ProjectsalespersonInfoDlg = {
    data: {
        projectID: "",
        salespersonID: "",
        orderNum: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    /*
    加载项目列表
     */
    var ajax = new $ax(Feng.ctxPath + "/projectinfo/list", function (data) {
        $("#projectID").empty();
        $.each(data.data,function (index,item) {
            $("#projectID").append("<option value='"+item.id+"'>"+item.name+"</option>")
        })
        // form.render('select','projectID')
        form.render();
    }, function (data) {
        Feng.error("加载项目列表错误！" + data.responseJSON.message)
    });
    ajax.start();

    /*
    加载销售列表
     */
    var ajax = new $ax(Feng.ctxPath + "/salesperson/list", function (data) {
        $("#salespersonID").empty();
        $.each(data.data,function (index,item) {
            $("#salespersonID").append("<option value='"+item.id+"'>"+item.name+"</option>")
        })
        // form.render('select','salespersonID')
        form.render();
    }, function (data) {
        Feng.error("加载销售列表错误！" + data.responseJSON.message)
    });
    ajax.start();

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/projectsalesperson/addItem", function (data) {
            Feng.success("添加成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();

        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

});