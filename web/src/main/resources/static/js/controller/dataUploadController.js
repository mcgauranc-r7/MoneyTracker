/**
 *
 * User: rowan.massey
 * Date: 26/09/2014
 */

"use strict";

/* Controllers */

moneyApp.controller("DataUploadController", ["$scope",
    function ($scope) {

        var dataUploadController = $scope.dataUploadController = {};

        dataUploadController.dataUpload = {};

        dataUploadController.save = function () {
            var dataUpload = getUserDto(dataUploadController.dataUpload);
            mnyUserService.save(user).then(function (userData) {
                userController.userLocation = userData.headers().location;
                //mnyAuthService.login(user.userName, user.password);
                var address = getAddressDto(userController.user);
                mnyAddressService.save(address).then(function (addressData) {
                    userController.addressLocation = addressData.headers().location;
                    mnyRelationshipService.associate(userController.userLocation, "address", userController.addressLocation).then(function () {
                        userController.user = {};
                    })
                });
            }, function (error) {
                console.log("There was an error processing the user: " + error);
            })

        };

        ////dataUploadController.all = Restangular.all('dataUploads');
        //dataUploadController.currentPage = 0;
        //dataUploadController.pages = 0;
        //dataUploadController.current = {};
        //dataUploadController.location = $location;
        //dataUploadController.pageSize = 5;
        //
        //dataUploadController.refresh = function () {
        //    //dataUploadController.all.getList({"size": dataUploadController.pageSize, "page": dataUploadController.currentPage, "sort": ""}).then(function (dataUploads) {
        //    //    $scope.dataUploads = dataUploads;
        //    //    dataUploadController.pages = dataUploads.page.totalPages;
        //    //}, function (error) {
        //    //    dataUploadController.location.path('/');
        //    //});
        //};
        //
        //dataUploadController.nextPage = function () {
        //    //if (dataUploadController.currentPage + 1 < dataUploadController.pages) {
        //    //    dataUploadController.currentPage = dataUploadController.currentPage + 1;
        //    //    dataUploadController.refresh();
        //    //}
        //};
        //
        //dataUploadController.previousPage = function () {
        //    //if (dataUploadController.currentPage > 0) {
        //    //    dataUploadController.currentPage = dataUploadController.currentPage - 1;
        //    //    dataUploadController.refresh();
        //    //}
        //};
        //
        //dataUploadController.save = function () {
        //    //dataUploadController.pageSize = 5;
        //    //dataUploadController.all.post(dataUploadController.current).then(function (result) {
        //    //    dataUploadController.current = {};
        //    //    dataUploadController.refresh();
        //    //});
        //};
        //
        //dataUploadController.newDataUpload = function () {
        //    dataUploadController.currentPage = 0;
        //    dataUploadController.pageSize = 4;
        //    dataUploadController.refresh();
        //    dataUploadController.current.dataupload_description = '';
        //};
        //
        //dataUploadController.cancel = function () {
        //    dataUploadController.pageSize = 5;
        //    dataUploadController.current = {};
        //    dataUploadController.refresh();
        //};
        //
        //dataUploadController.edit = function (dataUpload, event) {
        //    dataUploadController.current = dataUpload;
        //};
        //
        //dataUploadController.remove = function (dataUpload) {
        //    //dataUploads.remove().then(function (result) {
        //    //    dataUploadController.refresh();
        //    //});
        //};
        //
        //dataUploadController.refresh();
    }]);