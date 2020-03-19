/**
 * 详情对话框
 */
var SalefollowInfoDlg = {
    data: {
        salesID: "",
        clientID: "",
        followTime: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/clientinfo/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('salefollowForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        console.log(data.field)
        var ajax = new $ax(Feng.ctxPath + "/salefollow/addItemApoint", function (data) {
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
    //获取下拉框用户类型
        $.ajax({
            url: Feng.ctxPath + "/salesperson/personlist",
            dataType: 'json',
            data: {
                'state': 0
            }, //查询状态为正常的所有机构类型
            type: 'post',
            success: function (data) {
                $.each(data, function (index, item) {
                    $('#salePerson').append(
                        new Option(item.name, item.id));// 下拉菜单里添加元素
                });
                layui.form.render("select");
            }
        });
});