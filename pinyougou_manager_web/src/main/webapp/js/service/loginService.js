app.service("loginService",function ($http) {
    //获取到用户的名字
    this.loginName=function () {
        return $http.get("../login/name.do");
    };
})