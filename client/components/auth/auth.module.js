'use strict';

angular.module('ksiazeczkaZdrowiaApp.auth', [
  'ksiazeczkaZdrowiaApp.constants',
  'ksiazeczkaZdrowiaApp.util',
  'ngCookies',
  'ui.router'
])
  .config(function($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
  });
