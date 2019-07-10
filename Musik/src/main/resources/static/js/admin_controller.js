app.controller('adminController', function($scope, $http) {
	$scope.headingTitle = "Library";
	$scope.genres = [];
	$scope.languages = [];
	$scope.newSong = {}
	$scope.artistsCommaSeparated = "";
	$scope.selectedGenre = "";
	$scope.selectedLanguage = "";
	$scope.showAddSongDialogue = false;
	$scope.message = "";
	$http.get('/data/language/').then(
			function(response) {
				$scope.languages = response.data;
			}, function(response) {
				console.log('Error fetching genre');
			});

	$http.get('/data/genre/').then(
			function(response) {
				$scope.genres = response.data;
			}, function(response) {
				console.log('Error fetching languages');
			});
	
	
	$scope.addNewSong = function(){
		$http.get('/songs/newsong/').then(
				function(response) {
					console.log('Success');
					$scope.newSong = response.data;
				}, function(response) {
					console.log('Error fetching song');
				});
		$scope.showAddSongDialogue = true;
	}
	
	$scope.saveSong = function() {
		var array = $scope.artistsCommaSeparated.split(',');
		var artist = {};
		for (var i = 0; i < array.length; i++) {
		   artist.name = array[i];
		   $scope.newSong.artists.push(artist);
		   artist = {};
		}
		$scope.newSong.genre = $scope.selectedGenre.value;
		$scope.newSong.language = $scope.selectedLanguage.value;
		$http.post('/songs/', $scope.newSong).then(
				function(response) {
					console.log('song saved');
					$scope.showAddSongDialogue = false;
					$scope.message = "Song Added Successfully"
				}, function(response) {
					console.log('Error saving song');
					$scope.message = "Error saving song"
				});
	}
	
	$scope.songs;
	   
    $http.get('/songs/').then(onSuccess, onFailure);

    function onSuccess(response) {
      console.log('success');
      $scope.songs = response.data;
    }

    function onFailure(response) {
      console.log('failure');
    }
    
    $scope.edit = function(song) {
    	song.editable = true;
    }
    
    $scope.updateSong = function(song) {
    	song.editable = false;
    	var array = $scope.artistsCommaSeparated.split(',');
		var artist = {};
		song.artists = [];
		for (var i = 0; i < array.length; i++) {
		   artist.name = array[i];
		   song.artists.push(artist);
		   artist = {};
		}
		//song.genre = $scope.selectedGenre.value;
		//song.language = $scope.selectedLanguage.value;
		$http.put('/songs/' + song.songId, song).then(
				function(response) {
					console.log('song saved');
					$scope.showAddSongDialogue = false;
					$scope.message = "Song Added Successfully"
				}, function(response) {
					console.log('Error saving song');
					$scope.message = "Error saving song"
				});
    }
});