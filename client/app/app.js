'use strict';

angular.module('ksiazeczkaZdrowiaApp', [
  'ksiazeczkaZdrowiaApp.auth',
  'ksiazeczkaZdrowiaApp.admin',
  'ksiazeczkaZdrowiaApp.constants',
  'ngCookies',
  'ngResource',
  'ngSanitize',
  'btford.socket-io',
  'ui.router',
  'ui.bootstrap',
  'validation.match'
])
  .config(function($urlRouterProvider, $locationProvider) {
    $urlRouterProvider
      .otherwise('/');

    $locationProvider.html5Mode(true);
  });
