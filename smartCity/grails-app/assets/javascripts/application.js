// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require vendor/jquery
//= require vendor/bootstrap.min
//= require vendor/run_prettify.min
//= require vendor/jquery.serialize-object.min
//= require vendor/bootstrap-datepicker
//= require vendor/moment
//= require vendor/jquery.alphanum


if (typeof jQuery !== 'undefined') {
    (function($){
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });

        $(".number-only").numeric({
            allowMinus   : true,
            allowThouSep : false
        });


        $('#md-map').on('show.bs.modal', function(event) {
            if (event.namespace === 'bs.modal') {
                var link = $(event.relatedTarget).data('link');
                console.log(link)
                $('#frmMap').attr('src', link);
            }
        });

    })(jQuery);
}