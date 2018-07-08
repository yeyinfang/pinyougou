/*定义控制器*/
app.controller("brandController", function ($scope, $controller,brandService) {
    $controller('baseController',{$scope:$scope});//继承



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