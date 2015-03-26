module.exports = function (grunt) {

    var path = require('path');

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        bower: {
            install: {
                options: {
                    install: true,
                    copy: false,
                    cleanTargetDir: true
                }
            }
        },
        karma: {
            options: {
                configFile: 'karma.conf.js'
            },
            unit: {
                singleRun: true
            },
            continuous: {
                singleRun: false,
                autoWatch: true
            }
        },
        wiredep: {
            target: {
                src: "web/src/main/resources/static/index.html",
                options: {}
            }
        },
        concat: {
            options: {
                // define a string to put between each file in the concatenated output
                separator: ';'
            },
            dist: {
                // the files to concatenate
                src: ['web/src/main/resources/**/*.js', '!web/src/main/vendors/**/*.js'],
                // the location of the resulting JS file
                dest: 'dist/<%= pkg.name %>.js'
            }
        },
        uglify: {
            options: {
                // the banner is inserted at the top of the output
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n',
                mangle: false
            },
            dist: {
                files: {
                    'dist/<%= pkg.name %>.min.js': ['<%= concat.dist.dest %>']
                }
            }
        },
        jshint: {
            all: ['web/src/main/resources/static/*.js',
                'web/src/main/resources/static/components/**/*.js',
                'web/src/main/resources/static/functionality/**/*.js'],
            options: {
                // options here to override JSHint defaults
                globals: {
                    "angular": true
                }
            }
        },
        watch: {
            files: ['web/src/main/resources/static/*.js',
                'web/src/main/resources/static/components/**/*.js',
                'web/src/main/resources/static/functionality/**/*.js'],
            tasks: ['jshint'],
            options: {
                atBegin: true
                //,
                //livereload : true
            }
        },
        connect: {
            server: {
                options: {
                    hostname: 'localhost',
                    port: 9000,
                    base: 'web/src/main/resources/static/'
                },
                proxies: [
                    {
                        context: '/api',
                        host: 'localhost',
                        port: 8080,
                        https: false,
                        xforward: false
                        //headers: {
                        //    "x-custom-added-header": value
                        //}
                    }
                ]
            }
        },
        express: {
            all: {
                options: {
                    hostname: 'localhost',
                    port: 9000,
                    bases: [path.resolve('web/src/main/resources/static/')]
                }
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-uglify'); //This minifies all of the java script.
    grunt.loadNpmTasks('grunt-contrib-jshint'); //This validates code quality
    grunt.loadNpmTasks('grunt-contrib-watch'); //This will execute certain tasks when a file is modified.
    grunt.loadNpmTasks('grunt-contrib-concat'); //This will concatinate all of the JS files into one file.
    grunt.loadNpmTasks('grunt-contrib-connect'); //This will automatically run a webserver to test the application.
    grunt.loadNpmTasks('grunt-karma'); //allows us to exectute Karma from within Grunt.
    grunt.loadNpmTasks('grunt-wiredep'); //This will wire in all the javascript dependencies to the index.html.
    grunt.loadNpmTasks('grunt-express');
    grunt.loadNpmTasks('grunt-connect-proxy');


    grunt.registerTask('test', ['jshint']);
    grunt.registerTask('default', ['jshint', 'concat', 'uglify']);
    grunt.registerTask('dev', ['connect', 'watch']);
};