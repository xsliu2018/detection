const $table = $("#bridge_table");
$(function() {
    load();
});
function load(){
    $table.bootstrapTable({ // 对应table标签的id
        url: "/common/bridge/list", // 获取表格数据的url
        method: "get",
        cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
        striped: true,  //表格显示条纹，默认为false
        pagination: true, // 在表格底部显示分页组件，默认false
        pageList: [10, 15, 20], // 设置页面可以显示的数据条数
        pageSize: 10, // 页面数据条数
        pageNumber: 1, // 首页页码
        sidePagination: 'client', // 设置为服务器端分页
        showRefresh : false,//刷新按钮
        queryParams: function (params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
            console.log(params)
            return {
                ex: new Date()*1, // 额外添加的参数
                keyword: $('#keyword').val()
            }
        },
        sortName: 'id', // 要排序的字段
        sortOrder: 'desc', // 排序规则
        columns: [
            {
                checkbox: true, // 显示一个勾选框
                align: 'center' // 居中显示
            }, {
                field: 'id', // 返回json数据中的name
                title: '编号', // 表格表头显示文字
                align: 'center', // 左右居中
                valign: 'middle',// 上下居中
                visible: false,
            }, {
                field: 'bridgeName',
                title: '桥梁名称',
                align: 'center',
                valign: 'middle'
            }, {
                field: 'span',
                title: '跨径组合',
                align: 'center',
                valign: 'middle',
            }, {
                field: "structure",
                title: "结构形式",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
            },{
                field: "structNum",
                title: "构件数量",
                align: "center",
                valign: "middle",
                width: 100,
            },{
                field: "pictureNum",
                title: "图像数量",
                align: "center",
                valign: "middle",
            },{
                field: "gmtCreate",
                title: "检测时间",
                align: "center",
                valign: "middle",
            },{
                field: "status",
                title: "状态",
                align: "center",
                valign: "middle",
                formatter: function (value, row, index){ // 单元格格式化函数
                    let text = '-';
                    if (value === 1) {
                        text = "排队中";
                    } else if (value === 2) {
                        text = "检测中";
                    } else if (value === 3) {
                        text = "量化中";
                    } else{
                        text = "已完成"
                    }
                    return text;
                }
            },{
                field: "status",
                title: "检测报告",
                align: "center",
                valign: "middle",
                formatter: function (value, row, index){
                    if (value === 4 || value === 0){
                        return "<button class='btn btn-success btn-sm' onclick='downloadReport(" + row.id + ")'>下载</button>"
                    }
                    else{
                        return "<button class='btn btn-success' disabled='disabled''>"
                    }
                }
            }
        ],
        onLoadSuccess: function(){  //加载成功时执行
            console.info("加载成功");
        },
        onLoadError: function(){  //加载失败时执行
            console.info("加载数据失败");
        }
    });
}

function search() {
    // 刷新表格
    reload()
}

function reload(){
    $table.bootstrapTable('destroy');
    load();
}

function downloadReport(id){
    // 下载桥梁id对应的报告文件
    console.log(id)
}

function deleteBridge(){
    // 获取选择的行
    let infos = $table.bootstrapTable('getSelections')
    if (infos == null || infos.length === 0) {
        return;
    }
    console.log(infos)
    // TODO 逻辑删除对应行的数据
    let ids = []
    for (let i = 0; i < infos.length; i ++){
        ids[i] = infos[i].id
    }
    // 提交post任务，删除ids，获取删除信息，显示模态框
    swal({
        title: "确认弹框",
        text: "确认要删除数据吗?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
            if (flag) {
                $.ajax({
                    type: "POST",
                    url: "/common/bridge/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (result) {
                        if (result.success) {
                            swal("删除成功", {
                                icon: "success",
                            });
                            reload()
                        } else {
                            swal(result.message, {
                                icon: "error",
                            });
                        }
                    }
                });
            }
        }
    );

}

function exportBridges(){
    // TODO 导出桥梁信息excel

}
