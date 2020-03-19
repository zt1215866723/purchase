/**
 * 详情对话框
 */
var DiccontentInfoDlg = {
    data: {
        typeID: "",
        name: "",
        orderNum: "",
        memo: "",
        state: ""
    }
};

layui.use(['form', 'admin', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/diccontent/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('diccontentForm', result.data);

    /*
    加载字典数据类型
     */
    var ajax = new $ax(Feng.ctxPath + "/dictype/list", function (data) {
        $("#typeID").empty();
        $.each(data.data,function (index,item) {
            $("#typeID").append("<option value='"+item.id+"'>"+item.dictype+"</option>")
        })
        $("#typeID").val(result.data.typeID)
        form.render('select')
        console.log(result.data)
    }, function (data) {
        Feng.error("加载字典数据类型错误！" + data.responseJSON.message)
    });
    ajax.start();

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/diccontent/editItem", function (data) {
            Feng.success("更新成功！");

            //传给上个页面，刷新table用
            admin.putTempData('formOk', true);

            //关掉对话框
            admin.closeThisDialog();

        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

});