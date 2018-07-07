/*定义控制器*/
pyg.controller("brandController", function ($scope, $controller,brandService) {
    $controller('baseController',{$scope:$scope});//继承

    /* 分页处理 */
    $scope.paginationConf = {
        //当前页
        currentPage: 1,
        //总记录数
        totalItems: 10,
        //每页查询的记录数
        itemsPerPage: 10,
        //分页选项，用于选择每页显示多少条记录
        perPageOptions: [10, 20, 30, 40, 50],
        //当页码变更后触发的函数
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    /*重新加载数据*/
    $scope.reloadList = function () {
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    /*
    * 以下是增加的方法
    * */
    $scope.add = function () {
        brandService.add($scope.entity).success(function (data) {
            //如果保存成功，重新加载数据
            if (data.success) {
                $scope.reloadList();
            }else{
                //失败时显示失败消息
                alert(data.message);
            }
        });
    }

    /*
    * 回显数据
    * */
    $scope.findById = function (id) {
        brandService.findById(id).success(function (data) {
            console.log(data);
            $scope.entity = data;
        })
    };

    /*
    * 下拉列表的选择
    * */
    $scope.selectIds = [];
    $scope.updateSelection = function ($event, id) {
        //如果是被选中,则增加到数组
        if ($event.target.checked) {
            $scope.selectIds.push(id);
        } else {
            //查找当前id的下标
            var idx = $scope.selectIds.indexOf(1);
            //删除数据
            $scope.selectIds.splice(idx, 1);

        }
    }
    /*
    * 删除数据
    * */
    $scope.delete = function () {
        brandService.delete($scope.selectIds).success(function (data) {
            if (data.success) {
                $scope.reloadList();
            } else {
                //失败时显示失败消息
                alert(data.message);
            }
        });
    }

    /*分页处理*/
    $scope.searchEntity={};
    $scope.findPage =function (page,size) {
        /*条件查询*/
        brandService.findPage(page , size,$scope.searchEntity).success(function (data) {
            //更新数据列表
            $scope.list = data.rows;
            //更新总记录数
            $scope.paginationConf.totalItems = data.total;
        });

    };
});