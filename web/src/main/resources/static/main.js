var BASE_URL = 'http://localhost:8080/api';
var EMBEDDED_TAG = '_embedded';
var HREF_TAG = 'href';
var LINKS_TAG = 'links';
var GETLIST_OP = 'getList';
var SCREEN_MODE = Object.freeze({LIST: 0, NEW: 1, EDIT: 2});

var moneyApp = angular.module("moneyApp", ["ngStorage", "ui.router"]);