/*定义服务*/
app.service("brandService", function ($http) {
    //查询所有
    this.findAll=function () {
        return $http.get("../brand/findAll.do");
    }
    //分页
    this.findPage = function (page, size, entity) {
        return $http.post("../brand/search.do?page=" + page + "&size=" + size, entity);
    }
    //增加
    this.add = function (entity) {
        //设置一个方法参数
        var methodName = "add.do";
        if (entity.id != null) {
            //这就证明要进行修改操作
            methodName = "update.do";
        }
        return $http.post("../brand/" + methodName, entity);
    }
    //查询
    this.findById = function (id) {
        return $http.get("../brand/findById.do?id="+id);
    }

    //删除
    this.delete = function (ids) {
        return $http.get("../brand/delete.do?ids="+ids);
    }


});