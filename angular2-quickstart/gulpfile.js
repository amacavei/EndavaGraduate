var gulp = require('gulp');
var sourcemaps = require('gulp-sourcemaps');
var tsc = require('gulp-typescript');
var tsProject = tsc.createProject('tsconfig.json');
var ty = tsc.createProject('typings.json');
var bs = require('browser-sync').create(); // create a browser sync instance.

var reload = bs.reload;

gulp.task('serve', function() {
    bs.init({
        port: 8080,
        server: {
            baseDir: "./"
        },
        open: false
    });

    gulp.watch([
      "app/*.ts",
      "*.html"
    ], ['reloady']);
    gulp.watch('*.css', function(){
      gulp.src('*.css')
          .pipe(bs.stream());
    });
});

gulp.task('compile-ts',function(){

    var tsResult = gulp
        .src('app/*.ts')
        .pipe(sourcemaps.init())
        .pipe(tsc(tsProject));

    return tsResult.js
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('js'))
});

gulp.task('reloady', ['compile-ts'], function() {
    console.log("Reload SHOULD have happened.");
    bs.reload();
});
