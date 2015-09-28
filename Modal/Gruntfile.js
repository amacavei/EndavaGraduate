module.exports = function (grunt) {
  grunt.initConfig({
    browserSync: {
      bsFiles: {
        src: 'app/index.html'
      },
      options: {
        server: {
          baseDir: 'app',
          routes: {
                '/bower_components': './bower_components'
                }
        }
      }
    }
})

  grunt.loadNpmTasks('grunt-browser-sync');



  grunt.registerTask('default', ['browserSync']);
}
