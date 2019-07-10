/*app.controller('loginController', function($scope, $http) {
    $scope.headingTitle = "Login";
    Scope.credentials {};
    Scope.credentials.username = "";
    Scope.credentials.password = "";
    $http.get('user', {headers : headers}).then(onSuccess, onFailure);
    var headers = credentials ? {authorization : "Basic "
        + btoa(credentials.username + ":" + credentials.password)
    } : {};
    function onSuccess(response) {
      console.log('success');
    }

    function onFailure(response) {
      console.log('failure');
    }
});*/