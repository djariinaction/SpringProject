app.controller('homeController', function($scope, $http) {
    $scope.headingTitle = "Home";
    $scope.songs;
    $scope.key = "";
    $scope.search = function() {
    	$http.get('/songs/' + $scope.key).then(onSuccess, onFailure);
    };
    

    function onSuccess(response) {
      console.log('success');
      $scope.songs = response.data;
    }

    function onFailure(response) {
      console.log('failure');
    }
});