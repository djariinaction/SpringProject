var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/home',{
            templateUrl: '/views/home.html',
            controller: 'homeController'
        })
        .when('/library',{
            templateUrl: '/views/library.html',
            controller: 'libraryController'
        })
        .when('/admin',{
            templateUrl: '/views/admin.html',
            controller: 'adminController'
        })
        .when('/',{
            templateUrl: '/views/home.html',
            controller: 'homeController'
        })
        .otherwise(
            { redirectTo: '/views/home.html',}
        );
});

