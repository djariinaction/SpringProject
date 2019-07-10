app.controller('libraryController', function($scope, $http) {
    $scope.headingTitle = "Library";
    $scope.songs;
   
    $http.get('/songs/').then(onSuccess, onFailure);

    function onSuccess(response) {
      console.log('success');
      $scope.songs = response.data;
    }

    function onFailure(response) {
      console.log('failure');
    }
});